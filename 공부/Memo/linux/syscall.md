https://ieevee.com/tech/2017/06/18/kernel-syscall.html  

glibc 깃허브 뒤지고 토발즈 리눅스 깃허브 뒤져도 디렉토리 구조를 모르니   
어디서 시스템 콜 하는건지 못찾겠었는데 (퇴근 후 일주일 헤맴.. 단국대,, 고려대 ,, 한남대 등 pdf에도 안나와서)  

위의 중국인 글에서 디렉토리 명시해놔서 찾았다.  
glibc-2.23/sysdeps/unix/sysv/linux/bind.c. 를 참고하면 소켓 바인드 시 시스템 콜 하는 부분을 볼 수 있다.  

유저모드 / 커널모드 전환  

[syscall.pdf](https://github.com/user-attachments/files/17427949/syscall.pdf)



![KakaoTalk_20241018_131814641](https://github.com/user-attachments/assets/240be537-71ef-4920-9de2-0a4313b69862)

![KakaoTalk_20241018_131814641_01](https://github.com/user-attachments/assets/c71ceae8-389a-48d4-a69c-372f4deef755)

![KakaoTalk_20241018_131814641_02](https://github.com/user-attachments/assets/29600beb-94ae-4937-a2f4-b35df77fce21)

![KakaoTalk_20241018_131814641_03](https://github.com/user-attachments/assets/01d59c57-7aff-4f02-838b-e71484932b5d)

![KakaoTalk_20241018_131814641_04](https://github.com/user-attachments/assets/ee5955a8-7fd7-4534-8610-9bcd4f07ae7a)

```
리눅스 시스템 호출 코드 분석
리눅스 사용자 모드 프로세스는 몇몇 커널 기능을 사용할 때 시스템 호출을 통해 이를 수행합니다. 이 글에서는 bind 동작을 예로 들어, 코드 상에서 전체 시스템 호출 과정을 이해하고자 합니다. 주의할 점은 커널 버전이 v4.11이며, 다른 버전에서는 구체적인 구현이 약간 다를 수 있다는 것입니다.
사용자 모드가 커널 모드로 진입하는 방법
아래의 man bind 예제를 시작으로 설명합니다.
c
#include <sys/socket.h>
#include <sys/un.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define MY_SOCK_PATH "/somepath"
#define LISTEN_BACKLOG 50

#define handle_error(msg) \
    do { perror(msg); exit(EXIT_FAILURE); } while (0)

int main(int argc, char *argv[]) {
    int sfd, cfd;
    struct sockaddr_un my_addr, peer_addr;
    socklen_t peer_addr_size;

    sfd = socket(AF_UNIX, SOCK_STREAM, 0);
    if (sfd == -1)
        handle_error("socket");

    memset(&my_addr, 0, sizeof(struct sockaddr_un));
    my_addr.sun_family = AF_UNIX;
    strncpy(my_addr.sun_path, MY_SOCK_PATH, sizeof(my_addr.sun_path) - 1);

    if (bind(sfd, (struct sockaddr *) &my_addr, sizeof(struct sockaddr_un)) == -1)
        handle_error("bind");

    if (listen(sfd, LISTEN_BACKLOG) == -1)
        handle_error("listen");
}

사용자 모드는 bind 함수를 호출하며, 이 함수는 <sys/socket.h>에 선언되어 있습니다.
c
/* 소켓 FD에 로컬 주소 ADDR을 할당합니다 (ADDR의 길이는 LEN 바이트입니다). */
extern int bind (int __fd, __CONST_SOCKADDR_ARG __addr, socklen_t __len) __THROW;

사용자 모드 프로세스는 단순히 bind 함수를 호출하면 되며, 이 함수의 구체적인 구현은 glibc에서 제공됩니다. 이 구현은 glibc-2.23/sysdeps/unix/sysv/linux/bind.c에 정의되어 있습니다.
c
int __bind (int fd, __CONST_SOCKADDR_ARG addr, socklen_t len) {
#ifdef __ASSUME_BIND_SYSCALL
    return INLINE_SYSCALL(bind, 3, fd, addr.__sockaddr__, len);
#else
    return SOCKETCALL(bind, fd, addr.__sockaddr__, len, 0, 0, 0);
#endif
}
weak_alias (__bind, bind)

커널 4.3 버전부터 bind는 직접 socketcalls를 사용합니다. 따라서 위의 bind는 INLINE_SYSCALL을 사용합니다.
c
/* 커널 4.3에서 직접 socketcalls 사용 가능 */
#if __LINUX_KERNEL_VERSION >= 0x040300
# define __ASSUME_RECVMMSG_SYSCALL 1
# define __ASSUME_SENDMMSG_SYSCALL 1
# define __ASSUME_SOCKET_SYSCALL 1
# define __ASSUME_SOCKETPAIR_SYSCALL 1
# define __ASSUME_BIND_SYSCALL 1

INLINE_SYSCALL은 glibc-2.23/sysdeps/unix/sysv/linux/x86_64/sysdep.h에 정의되어 있습니다.
c
# define INTERNAL_SYSCALL_NCS(name, err, nr, args...) \
({ \
    unsigned long int resultvar; \
    LOAD_ARGS_##nr(args) \
    LOAD_REGS_##nr \
    asm volatile ( \
        "syscall\n\t" \
        : "=a" (resultvar) \
        : "0" (name) ASM_ARGS_##nr : "memory", REGISTERS_CLOBBERED_BY_SYSCALL); \
    (long int) resultvar; })

# undef INTERNAL_SYSCALL

# define INTERNAL_SYSCALL(name, err, nr, args...) \
    INTERNAL_SYSCALL_NCS(__NR_##name, err, nr, ##args)

# undef INLINE_SYSCALL

# define INLINE_SYSCALL(name, nr, args...) \
({ \
    unsigned long int resultvar = INTERNAL_SYSCALL(name,, nr, args); \
    if (__glibc_unlikely(INTERNAL_SYSCALL_ERROR_P(resultvar,,))) { \
        __set_errno(INTERNAL_SYSCALL_ERRNO(resultvar,,)); \
        resultvar = (unsigned long int) -1; \
    } \
    (long int) resultvar; })

시스템 호출 전에 먼저 매개변수를 레지스터에 전달합니다. 그런 다음 x86-64는 syscall 명령어를 사용해 커널로 진입합니다(x86이 커널로 진입하기 위해 0x80 인터럽트를 사용하는 것과 다릅니다). 반환값은 eax 레지스터에 있으며 보통 0은 성공을 의미합니다.
시스템 호출의 이름은 __NR_##name이며 이 예에서는 __NR_bind입니다. 이는 /usr/include/asm/unistd_64.h에 정의되어 있습니다.
c
#define __NR_bind 49
#define __NR_listen 50
#define __NR_getsockname 51

사용자 모드와 커널 모드는 시스템 호출 번호(49)를 통해 이번 시스템 호출이 어떤 기능인지 확인합니다.
위 예제에서 보듯이 glibc는 시스템 호출을 하나의 함수(bind)로 캡슐화하여 사용자 모드 프로세스 개발자가 이 함수를 호출하기만 하면 됩니다. 구체적인 시스템 호출이 어떻게 사용자 모드에서 커널로 진입하는지는 신경 쓸 필요가 없습니다. 이는 리눅스의 캡슐화가 잘 되어 있음을 보여줍니다. 물론 현대 운영 체제는 모두 이렇게 캡슐화되어 있습니다. 그렇지 않으면 개발자가 미쳐버릴 것입니다.
캡슐화 과정에서는 최종적으로 커널로 진입할 때 레지스터 설정(AX는 반드시 49로 설정해야 함), 어셈블리 명령어(SYSCALL)는 수정할 수 없으며(CPU에 의해 결정됨), 나머지는 특정 SDK에 의해 결정될 수 있습니다. 위에서는 glibc 예제를 들었고 이제 GOSDK 예제를 살펴보겠습니다(x86-64):
text
TEXT ·Syscall(SB),NOSPLIT,$0-56

CALL runtime·entersyscall(SB)

MOVQ a1+8(FP), DI

MOVQ a2+16(FP), SI

MOVQ a3+24(FP), DX

MOVQ $0, R10

MOVQ $0, R8

MOVQ $0, R9

MOVQ trap+0(FP), AX // syscall entry

SYSCALL

CMPQ AX, $0xfffffffffffff001

JLS ok

MOVQ $-1, r1+32(FP)

MOVQ $0, r2+40(FP)

NEGQ AX

MOVQ AX, err+48(FP)

CALL runtime·exitsyscall(SB)

RET

ok:

MOVQ AX, r1+32(FP)

MOVQ DX, r2+40(FP)

MOVQ $0, err+48(FP)

CALL runtime·exitsyscall(SB)

RET

이는 직접적인 어셈블리 파일입니다. 그리고 그 시스템 호출 번호도 자체적으로 정의했으며 리눅스 헤더 파일을 사용하지 않았습니다.
결론적으로 사용자 모드의 흐름은: 사용자 프로그램 -> glibc/sdk -> 어셈블리 syscall -> 커널입니다. 여기까지가 사용자 모드가 어떻게 커널로 진입하는지의 흐름입니다. 이제 내핵이 이를 어떻게 처리하는지 살펴보겠습니다.
내핵이 시스템 호출을 분배하는 방법
x86-64 아키텍처의 내핵 syscall 진입점은 linux/arch/x86/kernel/entry_64.S에 있습니다.
text
/*
* 64bit SYSCALL instruction entry. Up to 6 arguments in registers.
* 
* 64bit SYSCALL saves rip to rcx...
*/

ENTRY(system_call)
..
movq %r10,%rcx
call *sys_call_table(,%rax,8)
movq %rax,RAX(%rsp)

rax에는 이번 syscall의 num인 __NR_bind가 저장되어 있습니다.
system_call은 간단히 말해 syscall num에 해당하는 함수가 있는 sys_call_table 배열로 점프하는 것입니다.
sys_call_table은 linux/arch/x86/kernel/syscall_64.c에 정의되어 있습니다.
c
extern void sys_ni_syscall(void);

asmlinkage const sys_call_ptr_t sys_call_table[__NR_syscall_max+1] = {
[0 ... __NR_syscall_max] = &sys_ni_syscall,
#include <asm/syscalls_64.h>
};

그렇다면 언제 syscall number가 sys_xxx와 대응되나요? 이는 <asm/syscalls_64.h>를 봐야 합니다. 이 파일은 v4.11 버전에서는 컴파일 시점에 linux/arch/x86/entry/syscalls/syscall_64.tbl에서 생성됩니다.
syscall_64.tbl 테이블에는 다음과 같이 정의되어 있습니다:
text
# 64-bit system call numbers and entry vectors 
# The format is: 
# <number> <abi> <name> <entry point> 
# The abi is "common", "64" or "x32" for this file.
...
49 common bind sys_bind 
50 common listen sys_listen 
51 common getsockname sys_getsockname 
52 common getpeername sys_getpeername 

컴파일된 결과물인 syscalls_64.h는 다음과 같습니다:
text
__SYSCALL_COMMON(49, sys_bind, sys_bind)
__SYSCALL_COMMON(50, sys_listen, sys_listen)
__SYSCALL_COMMON(51, sys_getsockname, sys_getsockname)
__SYSCALL_COMMON(52, sys_getpeername, sys_getpeername)

여기서 __SYSCALL_COMMON은 사실상 __SYSCALL_64이며 앞서 본 sys_call_table 정의 부분으로 돌아가면:
c
#define __SYSCALL_64(nr,sym.qual) extern asmlinkage long sym(unsigned long,unsigned long,unsigned long,unsigned long,unsigned long,unsigned long);
#include <asm/syscalls_64.h>
#undef __SYSCALL_64
#define __SYSCALL_64(nr,sym.qual) [nr]=sym,
const sys_call_ptr_t sys_call_table[] ____cacheline_aligned = {
[0 ... __NR_syscall_max] = &sys_ni_syscall,
#include <asm/syscalls_64.h>
};

첫 번째 __SYSCALL_64 정의는 함수 선언을 위해 syscalls_64.h를 펼치는 것이고 이후 다시 정의된 것은 배열 멤버 정의를 위해 펼치는 것입니다.
결국 내핵이 얻는 것은 const 불변인 sys_call_table 배열이며 인덱스는 syscall number이고 이는 내핵의 sys_call_ptr_t를 가리킵니다. syscall num은 0부터 시작하므로 단순히 49를 통해서도 sys_bind를 찾을 수 있습니다.
여기서 또 하나 언급할 것은 sys_ni_syscall. 이는 linux/kernel/sys_ni.c에 정의되어 있으며 bind 등 심볼도 이 파일에 정의되어 있습니다.
내핵이 발전하면서 어떤 시스템 호출이 더 이상 사용되지 않으면 어떻게 해야 할까요? 내핵 규정상 시스템 호출 번호는 회수되지 않으며 만약 더 이상 사용되지 않는다면 해당 번호는 보존되지만 대응되는 함수는 sys_ni_syscall로 변경됩니다. 이는 약한 심볼인 cond_syscall을 통해 구현됩니다.
c
asmlinkage long sys_ni_syscall(void)
return -ENOSYS;

..
cond_syscall(sys_socketpair);
cond_syscall(sys_bind);
cond_syscall(sys_listen);
cond_syscall(sys_accept);
cond_syscall(sys_accept4);
cond_syscall(sys_connect);

cond_syscall은 linux/include/linux/linkage.h에서 정의됩니다.
c
#ifndef cond_syscall
#define cond_syscall(x) asm(
".weak " VMLINUX_SYMBOL_STR(x) "\n\t"
".set " VMLINUX_SYMBOL_STR(x) ","
VMLINUX_SYMBOL_STR(sys_ni_syscall))
#endif

cond_syscall에서 .weak func() .set func_backup() 의 의미는 만약 func()가 존재하지 않으면 func_backup을 호출하라는 것입니다. bind의 경우 이는 만약 sys_bind가 존재하지 않으면 sys_ni_syscall을 호출하라는 의미입니다.
구체적인 시스템 호출 함수 구현
내핵은 이제 시스템 호출 번호 49가 대응되는 것이 sys_bind라는 것을 알았습니다. 그렇다면 이 함수는 어디에 정의되어 있을까요?
sys_bind 코드는 net/socket.c에 있지만 이해하기에는 좀 복잡합니다.
c
SYSCALL_DEFINE3(bind,int.fd.struct sockaddr_user*.umyaddr.int.addrlen) {
struct socket*sock;
struct sockaddr_storage address;
int err,fput_needed;
sock=sockfd_lookup_light(fd,&err,&fput_needed);
if(sock){
err=move_addr_to_kernel(umyaddr.addrlen,&address);
if(err>=0){
err=security_socket_bind(sock,(struct sockaddr*)&address.addrlen);
if(!err)
err=sock->ops->bind(sock,(struct sockaddr*)&address.addrlen);

fput_light(sock->file,fput_needed);

return err;
}
}
}

bind 함수(주의: 이 함수 이름은 bind가 아닙니다)는 move_addr_to_kernel을 호출하여 address를 사용자 모드에서 내핵으로 복사한 후 proto_ops의 bind 함수를 호출하여 bind 요청을 처리합니다.
함수 이름이 bind가 아닌 이유는 무엇일까요? 실제로 SYSCALL_DEFINE3 매크로는 이를 sys_bind(int fd.struct sockaddr_user*.umyaddr.int.addrlen) 함수로 확장하며 이를 통해 sys_call_table에서 사용할 수 있게 됩니다. 이를 linux/include/linux/syscalls.h에서 확인할 수 있습니다:
c
/*
* __MAP - apply a macro to syscall arguments 
* __MAP(n,m,t1,a1,t2,a2,...tn.an)은 m(t1,a1),m(t2,a2),...,m(tn.an)으로 확장됩니다.
*/
#define __MAP0(m,...)
#define __MAP1(m,t,a)m(t,a)
#define __MAP2(m,t,a,...)(t,a),__MAP1(m,__VA_ARGS__)
#define __MAP3(m,t,a,...)(t,a),__MAP2(m,__VA_ARGS__)
..
#define __MAP(n,...).__MAP##n(__VA_ARGS__)
#define SC_DECL(t.a)t a
#define TYPE_IS_L(t)(__same_type((t)0L))
#define TYPE_IS_UL(t)(__same_type((t)0UL))
#define TYPE_IS_LL(t)(__same_type((t)0LL)||__same_type((t)0ULL))
#define SC_LONG(t.a)__typeof(__builtin_choose_expr(TYPE_IS_LL(t),0LL.,0L))a
#define SC_CAST(t.a)(t)a
#define SC_ARGS(t.a)a
#define SYSCALL_DEFINE3(name,...).SYSCAL_DEFINEx(3,_##name,__VA_ARGS__)
#define SYSCAL_DEFINEx(x.sname,...).SYSMETADATA(sname.x.__VA_ARGS__).__SYSDEx(x.sname.__VA_ARGS__)
#define SYSDEx(x.name,...).asmlinkage long sy##name(__MAP(x.SC_DECL.__VA_ARGS__))attribute((alias(__stringify(SyS##name)))).static inline long SYC##name(__MAP(x.SC_DECL.__VA_ARGS__)).asmlinkage long SyS##name(__MAP(x.SC_LONG.__VA_ARGS__)).asmlinkage long SyS##name(__MAP(x.SC_LONG.__VA_ARGS__))long ret=SYC##name(__MAP(x.SC_CAST.__VA_ARGS__)).return ret.static inline long SYC##name(__MAP(x.SC_DECL.__VA_ARGS__))

매크로 정의가 꽤 복잡하지만 간단히 말하면 sys_bind는 SyS_bind의 별칭이며 SyS_bind 내부에서는 SYC_bind를 호출합니다. 따라서 위 코드를 확장하면 내핵에서 실제로 정의된 함수는 SYC_Bind입니다:
c
asmlinkage long sy_bind(int fd.struct sockaddr_user*.umyaddr.int.addrlen) alias(__stringify(SyS_bind)).static inline long SYC_bind(int fd.struct sockaddr_user*.umyaddr.int.addrlen).asmlinkage long SyS_bind(long fd.long umyaddr.long addrlen).asmlinkage long SyS_bind(long fd.long umyaddr.long addrlen)long ret=SYC_bind((int.fd.(struct sockaddr_user*)umyaddr.(int.addrlen)).return ret.static inline long SYC_bind(int fd.struct sockaddr_user*.umyaddr.int.addrlen)

복잡하게 하는 이유 중 하나는 64비트 CPU 레지스터가 32비트 값을 저장할 때 부호 확장으로 인해 불법 메모리에 접근할 가능성이 있어 보안 문제가 발생할 수 있기 때문에 모든 필드를 long 타입으로 통일하여 받기 위함이라고 합니다.
그 이후에는 리눅스 프로토콜 스택 내 bind 구현으로 넘어갑니다만 이 글에서는 다루지 않습니다.
요약
이 글에서는 시스템 호출이 사용자 모드에서 라이브러리 함수를 통해 내핵으로 진입하는 과정과 내핵이 시스템 호출을 구현하고 이를 실제 작업을 수행하는 함수로 전달하는 방법을 논의했습니다. 이 과정을 이해하면 새로운 시스템 호출을 추가하려면 어디서 작업해야 하는지도 알 수 있습니다.
참고:
Linux Kernel Development Second Edition by Robert Love
```
