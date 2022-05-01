package main.java.goodee39.main;

import java.util.Scanner;

import main.java.goodee39.assembler.Assembler;
import main.java.goodee39.module.ChangePasswordService;
import main.java.goodee39.module.MemberRegisterService;
import main.java.goodee39.module.RegisterRequest;

public class MainForAssembler {
	
	private static Assembler assembler = new Assembler();
	// 시작지점
	/* - 커맨드를 통한 요청 동작 실행
	 * - new : 회원 등록
	 * - change : 회원 패스워드 변경
	 * - exit : 로직 종료
	 * */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("명령어를 입력하세요");
			String command = scan.nextLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				return;
			}else if(command.startsWith("new")){
				processNewCommand(command.split(" "));
				continue;
			}else if(command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			printHelp();
			
		}

	}
	
	// 도움말 출력
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다 다시 명령어를 입력하세요.");
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	// 패스워드 변경 시 실행되는 메서드
	/* - 반드시 4개의 데이터가 존재해야 한다.
	 * - 형식 : change [이메일] [구패스워드] [신패스워드]
	 * */
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService cps = assembler.getPwdSvc();
		cps.changePassword(arg[1], arg[2], arg[3]);
		System.out.println("암호를 변경했습니다.");
	}
	
	// 회원 등록 시 실행되는 메서드
	/* - 반드시 5개의 데이터가 존재해야 한다.
	 * - 형식 : new [email] [name] [password] [confirmpassword]
	 * 
	 * */
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc = assembler.getRegSvc();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호가 일치하지 않습니다");
			return;
		}else {
			regSvc.regist(req);
			System.out.println("등록되었습니다.");
		}
		
	}

}

























