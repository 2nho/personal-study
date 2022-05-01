package kr.co.goodee39.date1105;

public class SingletonClass {
	private static TargetClass target;
	
//	public SingletonClass() {
//		target = new TargetClass();
//	}
	
	public TargetClass getTargetClass() {
		if(target == null) target = new TargetClass();
		
		return target;
	}
}
