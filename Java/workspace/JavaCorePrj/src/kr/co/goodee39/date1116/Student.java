package kr.co.goodee39.date1116;

public class Student {
	private String name;
	private String gender;
	private int engScore;
	private int mathScore;
	
	public Student(String name, int engScore, int mathScore) {
		super();
		this.name = name;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	public Student(String name, String gender, int engScore, int mathScore) {
		super();
		this.name = name;
		this.gender = gender;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	public String getGender() {
		return gender;
	}
	public String getName() {
		return name;
	}
	public int getEngScore() {
		return engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	
	
}
