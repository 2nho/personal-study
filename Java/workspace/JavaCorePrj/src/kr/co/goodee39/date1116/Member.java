package kr.co.goodee39.date1116;

public class Member {
	private String name;
	private String id;
	private Address address;
	
	public Member() {
		System.out.println("Member() 실행");
	}
	
	public Member(String id) {
		super();
		this.id = id;
		System.out.println("Member(id) 실행");
	}

	public Member(String name, String id) {
		super();
		this.name = name;
		this.id = id;
		System.out.println("Member(name, id) 실행");
	}

	public Member(String name, String id, Address address) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public Address getAddress() {
		return address;
	}
	
	
	
}
