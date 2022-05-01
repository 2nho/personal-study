package kr.co.goodee39.date1102;

public class Ex05Class {

	public static void main(String[] args) {
		Car c = new Car();
		
		System.out.println(c.color);
		System.out.println(c.fuel);
		c.putAccel();
		c.putBreak();
		
		Car c1 = new Car();
		c1.putAccel();
	}

}
