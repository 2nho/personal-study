package kr.co.goodee39.date1111;

public class CModuleImpl implements CModule {

	@Override
	public void getList() {
		System.out.println("리스트 보여주기 : 모듈 C");
	}

	@Override
	public void getItem() {
		System.out.println("아이템 상세보기 : 모듈 C 아이템");
	}

}
