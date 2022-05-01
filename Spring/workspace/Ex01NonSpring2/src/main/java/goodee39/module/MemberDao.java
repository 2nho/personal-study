package main.java.goodee39.module;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
// 저장소 => DB
/* - map을 DB화 하여 데이터들이 읽기, 삽입, 갱신이 가능하도록 처리해주는 로직
 * 
 * */
public class MemberDao {
	private static long nextId =0;
	
	private Map<String, Member> map = new HashMap<>();
	// row 하나 읽기
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	// row 삽입
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	// row 갱신
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	public Collection<Member> selectAll(){
		return map.values();
	}
}
