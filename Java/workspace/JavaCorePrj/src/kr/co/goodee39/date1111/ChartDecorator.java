package kr.co.goodee39.date1111;

public class ChartDecorator implements Chart {
	
	private Chart chart;	
	
	public ChartDecorator(Chart chart) {
		this.chart = chart;
	}
	
	@Override
	public String decorator() {
		return chart.decorator();
	}

}
