package kr.co.goodee39.ch10.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.goodee39.vo.DeptVO;
import kr.co.goodee39.vo.EmpVO;

public class EmpDAO {
	public List<EmpVO> getEmpList(Connection conn) throws Exception{
		String query = "select * from emp";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<EmpVO> list = new ArrayList<EmpVO>();
		while(rs.next()) {
			System.out.println(rs.getInt("EMPNO"));
			EmpVO vo = new EmpVO(
					rs.getInt("EMPNO"), 
					rs.getString("ENAME"),
					rs.getNString("JOB"),
					0,
					rs.getString("HIREDATE"),
					rs.getDouble("SAL"),
					0.0,
					rs.getInt("DEPTNO"));
			list.add(vo);
		}
		pstmt.close();
		rs.close();
		
		return list;
	}
	
	public int insertDept(Connection conn, DeptVO vo) throws Exception{
		String query = "insert into dept(deptno, dname, loc) values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, vo.getDeptno());
		pstmt.setString(2, vo.getDname());
		pstmt.setString(3, vo.getLoc());
		
		int i = pstmt.executeUpdate();
		
		return i;
	}
}




