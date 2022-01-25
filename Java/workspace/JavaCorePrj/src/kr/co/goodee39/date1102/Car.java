package kr.co.goodee39.date1102;

public class Car {
	
	public Car() {
		System.out.println("이것은 Car의 생성자입니다.");
	}
	
	public String color = "빨간색";
	public int fuel = 85;
	
	public void putAccel() {
		System.out.println("차가 갑니다.");
	}
	
	public void putBreak() {
		System.out.println("차가 섭니다.");
	}
}
