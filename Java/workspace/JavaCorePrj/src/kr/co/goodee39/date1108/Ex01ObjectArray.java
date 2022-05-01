package kr.co.goodee39.date1108;

public class Ex01ObjectArray {

	public static void main(String[] args) {
		DataVO[] dv1 = new DataVO[10];
		
		// dv1[0].getData1(); // error
		dv1[0] = new DataVO();
		dv1[0].setData1(7);
		dv1[0].setData2("abcd");
		
		System.out.println(dv1[0].getData1());
		System.out.println(dv1[0].getData2());
		
		DataVO[] dv2 = {new DataVO(3, "aaa"), new DataVO(4, "bbb")};
		
		System.out.println(dv2[0].getData1());
		System.out.println(dv2[1].getData1());
	}

}
