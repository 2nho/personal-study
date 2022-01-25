package kr.co.goodee39.mapper;

import org.apache.ibatis.annotations.Select;

public interface MemberQueryMapper1 {
	@Select("select count(*) from member")
	public int getCount();
}
