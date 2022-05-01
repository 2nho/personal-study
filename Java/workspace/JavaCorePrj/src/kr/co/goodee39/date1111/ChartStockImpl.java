package kr.co.goodee39.date1111;

public class ChartStockImpl extends ChartDecorator{
	
	public ChartStockImpl(Chart chart) {
		super(chart);
	}
	
	public String addStockList() {
		return "///재고 출력///";
	}
	
	@Override
	public String decorator() {
		return addStockList()+super.decorator();
	}
}
