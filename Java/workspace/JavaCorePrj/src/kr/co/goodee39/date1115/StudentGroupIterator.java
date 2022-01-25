package kr.co.goodee39.date1115;

public class StudentGroupIterator implements Iterator{
	
	private StudentGroup stdGroup;
	private int index;
	
	
	
	public StudentGroupIterator(StudentGroup stdGroup) {
		this.stdGroup = stdGroup;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		if(index < stdGroup.getLength()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Object next() {
		Student student = stdGroup.getStudent(index);
		index++;
		return student;
	}

}
