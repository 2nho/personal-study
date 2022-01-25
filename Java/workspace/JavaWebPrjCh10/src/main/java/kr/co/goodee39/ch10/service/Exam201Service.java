package kr.co.goodee39.ch10.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.goodee39.ch10.dao.EmpDAO;
import kr.co.goodee39.conn.JDBCCreateConn;
import kr.co.goodee39.vo.DeptVO;
import kr.co.goodee39.vo.EmpVO;

public class Exam201Service {
	public void getEmpList(HttpServletRequest request) {
		try {
			EmpDAO dao = new EmpDAO();
			List<EmpVO> list = dao.getEmpList(JDBCCreateConn.getConn());
			
			request.setAttribute("list", list);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setDept(HttpServletRequest request) {
		try {
			DeptVO vo = new DeptVO();
			vo.setDeptno(Integer.parseInt(request.getParameter("deptno")));
			vo.setDname(request.getParameter("dname"));
			vo.setLoc(request.getParameter("loc"));
			
			EmpDAO dao = new EmpDAO();
			int i = dao.insertDept(JDBCCreateConn.getConn(), vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
