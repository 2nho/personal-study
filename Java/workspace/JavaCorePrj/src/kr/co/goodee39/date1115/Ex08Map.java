package kr.co.goodee39.date1115;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex08Map {
	// map
	/*
	 * - 키와 값의 쌍으로 이루어져 있는 콜렉션 객체
	 * - 키의 값을 기준으로 value를 저장할 경우 사용할 수 있다.
	 * - 현업에서는 DB의 컬럼과 데이터를 키와 값의 쌍으로 엮어서 클라이언트에 전송할 경우가 있따.
	 * - Map에서 put 메서드를 통해 데이터를 삽입하는 것이 가능하다
	 * - put 메서드로 삽입 시 key 값이 기존 key값과 동일하면 key는 중첩되지 않으며 남아있고 기존 값이 새로운 값으로 대체 된다.
	 * - remove 메서드를 통해 데이터 삭제가 가능하다.
	 * - map을 순회하기 위해서는 set 형태로 바꾸어 순회를 시켜주어야 하며 map에 들어있는 데이터를 EntrySet 형태로 바꿔서
	 *   순회하는 방식과 키만 Set 형태로 리턴하는 keySet, value들을 collection 형태로 출력하는 values가 존재한다.
	 */
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "aaa");
		map.put(2, "bbb");
		map.put(3, "ccc");
		System.out.println(map);
		
		map.put(2, "ddd");
		System.out.println(map);
		
		map.remove(2);
		System.out.println(map);
		
		System.out.println(map.containsKey(2));
		System.out.println(map.containsValue("ccc"));
		
		map.put(4, "ddd");
		map.put(5, "eee");
		
		System.out.println(map);
		
		System.out.println("-------------------------------");
		
//		Set<Entry<Integer, String>> set1 = map.entrySet();
//		for (Entry<Integer, String> entry : set1) {
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//			System.out.println("-------------------------------");
//		}
		
		Set<Integer> key = map.keySet();
		for (Integer integer : key) {
			System.out.println(integer);
		}
		
		System.out.println("-------------------------------");
		
		Collection<String> values = map.values();
		for (String string : values) {
			System.out.println(string);
		}
		
		Map<Integer, Student> map2 = new HashMap<Integer, Student>();
		
	}

}



