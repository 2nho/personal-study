package kr.co.goodee39.date1111;

public class StockBoard implements SystemMode{

	@Override
	public void getList() {
		System.out.println("재고 보드 리스트 출력");
	}

	@Override
	public void selectItem() {
		System.out.println("재고 물량 확인");
	}

	@Override
	public void updateList() {
		System.out.println("새 재고 확인");		
	}

}
