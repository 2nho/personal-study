package kr.co.goodee39.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example2ServletController
 */
@WebServlet("/Example2ServletController")
public class Example2ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example2ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get으로 호출");
		request.setCharacterEncoding("UTF-8");
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		System.out.println(data1 + "," + data2);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setAttribute("data1", data1);
		request.setAttribute("data2", data2);
		
//		RequestDispatcher rdp = request.getRequestDispatcher("/ch08/example2_result.jsp");
//		rdp.forward(request, response);
		
		response.sendRedirect(request.getContextPath()+"/ch08/example2_result.jsp?data1="+data1+"&data2="+data2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post로 호출");
		doGet(request, response);
	}

}
