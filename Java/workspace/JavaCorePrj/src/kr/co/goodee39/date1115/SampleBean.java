package kr.co.goodee39.date1115;

public class SampleBean {
	int a;
	String s;
	
	public SampleBean() {
		
	}
	public SampleBean(int a, String s) {
		this.a = a;
		this.s = s;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return "SampleBean [a=" + a + ", s=" + s + "]";
	}
	
	
}
