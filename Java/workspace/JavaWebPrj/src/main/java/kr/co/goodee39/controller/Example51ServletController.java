package kr.co.goodee39.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.goodee39.beans.LoginBean;

/**
 * Servlet implementation class Example51ServletController
 */
@WebServlet("/Example51ServletController")
public class Example51ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example51ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
		
//		System.out.println("Servlet51");
//		System.out.println(id+","+pw);
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		LoginBean vo = new LoginBean();
//		vo.setId(id);
//		vo.setPw(pw);
		
//		request.setAttribute("vo", vo);
		
		RequestDispatcher rdp = request.getRequestDispatcher("/ch08/example4_result2.jsp");
		rdp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
