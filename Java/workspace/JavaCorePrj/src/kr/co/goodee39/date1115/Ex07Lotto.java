package kr.co.goodee39.date1115;

import java.util.Set;
import java.util.TreeSet;

public class Ex07Lotto {
	// Set
	/* - 데이터가 중복되지 않으며 순서가 없는 데이터를 관리할 때 사용하는 콜렉션
	 * - 리스트 하고는 달리 인덱스를 통해 접근할 수 없다.
	 * - 데이터에 순차적으로 접근하기 위해서 foreach 혹은 iterator를 통해 접근해야 한다.
	 * - Set은 동일 데이터를 넣을 시 false를 리턴하고 해당 데이터를 드랍한다.
	 * - 데이터의 중복을 불허하는 점에서 유니크한 데이터만 저장/관리가 가능하다는 장점이 있다.
	 * - Set의 대표적인 클래스로는 HashSet, TreeSet 등이 있다.
	 */
	public static void main(String[] args) {
		
		Set<Integer> set = new TreeSet<Integer>();
		
		while(set.size() < 6) {
			set.add(((int)(Math.random()*45)+1));
		}
		
		java.util.Iterator<Integer> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
