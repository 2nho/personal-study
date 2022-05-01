package kr.co.goodee39.beans;

public class DataBean {
	
	private int data1;
	
	public DataBean() {
		// TODO Auto-generated constructor stub
	}
	
	public DataBean(int data1) {
		this.data1 = data1;
	}

	@Override
	public String toString() {
		return "DataBean [data1=" + data1 + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	

}
