package kr.co.goodee39.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.goodee39.beans.JdbcBean;

public interface MapperInterface {
	@Select("select int_data, str_data from jdbc_table")
	public List<JdbcBean> selectData();
	
	@Insert("insert into jdbc_table(int_data, str_data) values(#{int_data}, #{str_data})")
	public void insertData(JdbcBean bean);
	
	@Update("update jdbc_table set str_data = #{str_data} where int_data = #{int_data}")
	public void updataData(JdbcBean bean);
	
	@Delete("delete from jdbc_table where int_data = #{int_data}")
	public void deleteData(int int_data);
	
}
