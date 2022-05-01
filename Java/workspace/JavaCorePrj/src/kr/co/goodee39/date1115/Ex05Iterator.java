package kr.co.goodee39.date1115;

public class Ex05Iterator {

	public static void main(String[] args) {
		StudentGroup stdGroup = new StudentGroup(5);
		stdGroup.addStudent(new Student("마동석",10));
		stdGroup.addStudent(new Student("김종국",20));
		stdGroup.addStudent(new Student("이정제",48));
		stdGroup.addStudent(new Student("이순재",50));
		stdGroup.addStudent(new Student("이나영",30));
		
		StudentGroupIterator iterator = (StudentGroupIterator)stdGroup.iterator();
		
		while(iterator.hasNext()) {
			Student std = (Student)iterator.next();
			System.out.println("이름 : "+std.getName());
			System.out.println("나이 : "+std.getAge());
			System.out.println("-------------------------");
		}
	}

}
