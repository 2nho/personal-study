package kr.co.goodee39.date1111;

public class AirConditioner implements UserInter1 {

	@Override
	public void putStart() {
		System.out.println("에어컨을 켭니다.");
	}

	@Override
	public void putMode() {
		System.out.println("터보모드 작동");
	}

}
