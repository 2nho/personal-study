package main.java.goodee39.assembler;

import main.java.goodee39.module.ChangePasswordService;
import main.java.goodee39.module.MemberDao;
import main.java.goodee39.module.MemberRegisterService;

// 중계기
/* - memberDAO, MemberRegisterService, ChangePasswordService 를 제공하는 클래스
 * - 생성자에서 사용자들에게 필요한 자원을 초기화 해서 getter 메서드를 통해 제공한다.
 * */
public class Assembler {
	private MemberDao memberDAO;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		memberDAO = new MemberDao();
		regSvc = new MemberRegisterService(memberDAO);
		pwdSvc = new ChangePasswordService(memberDAO);
	}

	public MemberDao getMemberDAO() {
		return memberDAO;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
	
	
	
}
