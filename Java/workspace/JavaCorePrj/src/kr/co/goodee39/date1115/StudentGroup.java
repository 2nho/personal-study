package kr.co.goodee39.date1115;

public class StudentGroup implements Aggregate{
	
	private Student[] student;
	private int num = 0;
	
	public StudentGroup(int num) {
		this.student = new Student[num];
	}
	
	public Student getStudent(int index) {
		return student[index];
	}
	
	public void addStudent(Student student) {
		this.student[num] = student;
		num++;
	}
	
	public int getLength() {
		return num;
	}
	
	@Override
	public Iterator iterator() {
		return new StudentGroupIterator(this);
	}

}
