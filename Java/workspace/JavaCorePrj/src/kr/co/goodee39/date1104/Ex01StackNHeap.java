package kr.co.goodee39.date1104;

public class Ex01StackNHeap {
	// Heap 영역과 Stack 영역에서의 코드 동작
	/* - 인스턴스 선언 시 heap 영역에서 해당 인스턴스에 대한 메모리의 영역이 잡히게 된다.
	 * - 해당 인스턴스의 메소드를 호출하게 되면 해당 메소드의 영역을 실행하는 callstack 영역의
	 *   메모리 주소를 heap 영역의 인스턴스 메모리 영역에서 가리켜 해당 로직을 바이너리 향태로
	 *   실행하게 된다.
	 * - 바이너리 형태로 스택에서 실행 되어진 후 코드 동작이 종료되면 FILO(First Input Last Out)
	 *   방식으로 메모리에서 순차적으로 로직이 차지하던 메모리가 반환되며 종료가 된다.
	 * */
	
	// GC(Garbage Collector)
	/* - JVM 에서는 메모리에 대한 모니터링을 어플리케이션이 실행하는 동안 하게 된다.
	 * - 만약 불필요한 인스턴스가 생겼을 경우, 혹은 더이상 필요 없는 인스턴스가 생기게 되면
	 *   해당 인스턴스가 차지하고 있는 heap 메모리 영역을 반환해줘야 한다.
	 * - GC는 해당 인스턴스가 불필요하게 차지하는 메모리를 반환시켜주는 역할을 수행한다.
	 * - 단 주의할 점은 GC를 너무 자주사용하게 될 경우 시스템의 오버헤드가 증가하기 때문에
	 *   가급적이면 GC를 사용하지 않는 방향으로 프로그램을 짜는 것이 가장 좋다.
	 * 
	 * */
	
	public void method1() {
		int a = 1;
		int b = 2;
		System.out.println(a + b);
	}
	
	public void init() {
		{
			Ex01StackNHeap snh2 = new Ex01StackNHeap();
			snh2.method1();
		}
		System.out.println("이것은 init 메소드 입니다.");
	}
		
	public static void main(String[] args) {
		Ex01StackNHeap snh1 = new Ex01StackNHeap();
		// snh1.method1();
		snh1.init();
	}

}
