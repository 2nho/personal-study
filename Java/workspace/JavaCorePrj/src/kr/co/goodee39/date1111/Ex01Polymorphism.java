package kr.co.goodee39.date1111;

public class Ex01Polymorphism {

	public static void main(String[] args) {
		ChildClass1 cc1 = new ChildClass1();
		cc1.method1();
		cc1.method2();
		System.out.println(cc1.str1);
		System.out.println(cc1.str2);
		
		cc1.method3();
		
		System.out.println("-------------------------------");
		
		ParentClass1 cc2 = new ChildClass1();
		cc2.method1();
		cc2.method2();
		System.out.println(cc2.str1);
		System.out.println(cc2.str2);
		
		((ChildClass1)cc2).method3();
		
		System.out.println("-------------------------------");
		
		ParentClass1 cc3 = new ChildClass2();
		cc3.method1();
		cc3.method2();
		System.out.println(cc3.str1);
		System.out.println(cc3.str2);
	}

}
