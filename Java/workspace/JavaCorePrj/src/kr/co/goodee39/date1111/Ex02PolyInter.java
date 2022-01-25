package kr.co.goodee39.date1111;

public class Ex02PolyInter {
		
	public static void main(String[] args) {
		UserInter1 remote1 = new AirConditioner();
		remote1.putStart();
		remote1.putMode();
		
		UserInter1 remote2 = new AirCleaner();
		remote2.putStart();
		remote2.putMode();
	}

}
