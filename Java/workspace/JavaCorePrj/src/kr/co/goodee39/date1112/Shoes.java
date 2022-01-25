package kr.co.goodee39.date1112;

public enum Shoes {
	WARKING("워킹화"), RUNNING("러닝화"), TRANKING("트래킹화"), HIKING("하이킹화");
	
	private final String name;
	
	private Shoes(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void printName() {
		System.out.println("이 운동화는 "+name+"운동화 입니다.");
	}
}
