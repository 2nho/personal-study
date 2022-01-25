package kr.co.goodee39.date1211;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ex01HashCode {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		// hashcode : 일련의 16진수로 나타내는 코드
		Ex01HashCode hash1 = new Ex01HashCode();
		Ex01HashCode hash2 = new Ex01HashCode();
		Ex01HashCode hash3 = new Ex01HashCode();
		System.out.println(hash1.hashCode());
		System.out.println(hash2.hashCode());
		System.out.println(hash3.hashCode());
		
		String a = "abc";
		String b = "abc";
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		String text = "안녕하세요";
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes());
		
		System.out.println(md.digest());
	}
}




