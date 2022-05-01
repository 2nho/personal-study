package kr.co.goodee39.beans;

public class TestBean1 {
	private int data1;
	private double data2;
	private String data3;
	private int data4;
	
	public TestBean1() {
		System.out.println("TestBean1의 기본 생성자");
	}
	
	public TestBean1(int data1) {
		this.data1 = data1;
	}
	
	public TestBean1(int data1, int data4) {
		this.data1 = data1;
		this.data4 = data4;
	}
	
	public TestBean1(double data2) {
		this.data2 = data2;
	}
	
	public TestBean1(String data3) {
		this.data3 = data3;
	}
	
	public TestBean1(int data1, double data2, String data3) {
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
	}
	
	public TestBean1(int data1, double data2, String data3, int data4) {
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
		this.data4 = data4;
	}

	public void printData() {
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		System.out.println("data3 : "+data3);
		System.out.println("data4 : "+data4);
	}
}
