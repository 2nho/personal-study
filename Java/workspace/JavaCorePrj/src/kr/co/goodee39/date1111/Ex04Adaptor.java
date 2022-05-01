package kr.co.goodee39.date1111;

public class Ex04Adaptor {

	public static void main(String[] args) {
		CModule module1 = new CModuleImpl();
		Board(module1);
		
		System.out.println("------------------------");
		
		CModule module2 = new SModuleAdapter(new SModuleImpl());
		Board(module2);
	}
	
	public static void Board(CModule cModule) {
		cModule.getList();
		cModule.getItem();
	}
}
