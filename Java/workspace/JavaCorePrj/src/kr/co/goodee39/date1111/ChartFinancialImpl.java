package kr.co.goodee39.date1111;

public class ChartFinancialImpl extends ChartDecorator {
	
	public ChartFinancialImpl(Chart chart) {
		super(chart);
	}
	
	public String addFinancialList() {
		return "<<<재무재표 출력>>>";
	}
	
	@Override
	public String decorator() {
		return super.decorator() + addFinancialList();
	}
}
