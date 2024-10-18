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
