package kr.co.goodee39.date1117;

public class Ex03WrongException {

	public static void main(String[] args) {
		try {
			throw new SampleException1();
		}catch(SampleException1 e1) {
			e1.method1();
		}
	}

}
