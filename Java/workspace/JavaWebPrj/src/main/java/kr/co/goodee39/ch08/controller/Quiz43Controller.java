package kr.co.goodee39.ch08.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz43Controller
 */
@WebServlet("/Quiz43Controller")
public class Quiz43Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz43Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String time=request.getParameter("time");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String major=request.getParameter("major");
		String gender=request.getParameter("gender");
		String[] favor=request.getParameterValues("favor");
		String query = "?";
		System.out.println("수강 타임 : "+time);
		query += "time="+time;
		System.out.println("이름 : "+name);
		query += "&name="+name;
		System.out.println("이메일 : "+email);
		query += "&email="+email;
		System.out.println("패스워드 : "+password);
		query += "&password="+password;
		System.out.println("전공 : "+major);
		query += "&major="+major;
		System.out.println("성별 : "+gender);
		query += "&gender="+gender;
		for (String string : favor) {
			System.out.println("관심사 : "+string);
			query += "&favor="+string;
		}
		
		response.sendRedirect(request.getContextPath()+"/ch08/quiz4_3.jsp"+query);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
