package kr.co.goodee39.date1111;

public class SModuleImpl implements SModule {

	@Override
	public void listUp() {
		System.out.println("S모듈의 리스트 보여주기");
	}

	@Override
	public void detailItem() {
		System.out.println("S모듈의 아이템 상세 보기");
	}

}
