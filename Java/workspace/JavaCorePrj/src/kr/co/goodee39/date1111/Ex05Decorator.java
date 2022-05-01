package kr.co.goodee39.date1111;

public class Ex05Decorator {
	public static void main(String[] args) {
		Chart c1 = new ChartFinancialImpl(new MainChartImpl());
		System.out.println(c1.decorator());
		
		Chart c2 = new ChartFinancialImpl(
				new ChartStockImpl(
						new MainChartImpl()));
		System.out.println(c2.decorator());
	}
}
