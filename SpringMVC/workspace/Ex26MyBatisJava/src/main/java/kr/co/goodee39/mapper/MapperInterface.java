package kr.co.goodee39.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.goodee39.vo.DataVO1;

public interface MapperInterface {
	
	@Insert("insert into springsample(column1, column2, column3) values(#{column1}, #{column2}, #{column3})")
	public void insertData(DataVO1 vo);
	
	@Select("select column1, column2, column3 from springsample")
	public List<DataVO1> selectDataList();
}
