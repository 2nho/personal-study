package kr.co.goodee39.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.goodee39.beans.JdbcBean;

@Component
public class MapperMapper implements RowMapper<JdbcBean>{
	
	@Override
	public JdbcBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		JdbcBean bean = new JdbcBean();
		bean.setInt_data(rs.getInt("int_data"));
		bean.setStr_data(rs.getString("str_data"));
		
		return bean;
		
	}
}
