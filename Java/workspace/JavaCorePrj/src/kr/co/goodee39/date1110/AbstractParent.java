package kr.co.goodee39.date1110;

public abstract class AbstractParent {
	String handleMaterial = "나무";
	String color = "노란색";
	
	public void method1() {
		System.out.println("두드린다.");
	}
	
	public abstract void method2();
}
