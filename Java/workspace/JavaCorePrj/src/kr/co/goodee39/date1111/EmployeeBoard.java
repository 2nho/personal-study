package kr.co.goodee39.date1111;

public class EmployeeBoard implements SystemMode{

	@Override
	public void getList() {
		System.out.println("사원 리스트 확인");
	}

	@Override
	public void selectItem() {
		System.out.println("사원 스테이터스 확인");		
	}

	@Override
	public void updateList() {
		System.out.println("입사자 퇴사자 갱신");		
	}

}
