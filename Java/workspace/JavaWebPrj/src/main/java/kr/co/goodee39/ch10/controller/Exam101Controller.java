package kr.co.goodee39.ch10.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.goodee39.ch10.service.Exam101Service;

/**
 * Servlet implementation class Exam1Controller
 */
@WebServlet("/Exam101Controller")
public class Exam101Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam101Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		int data1 = Integer.parseInt(request.getParameter("data1"));
//		int data2 = Integer.parseInt(request.getParameter("data2"));
//		String type = request.getParameter("type");
//		
//		if(type.equals("plus")) {
//			request.setAttribute("result", data1+data2);
//		}else if(type.equals("minus")) {
//			request.setAttribute("result", data1-data2);
//		}else if(type.equals("mul")) {
//			request.setAttribute("result", data1*data2);
//		}else {
//			request.setAttribute("result", data1/data2);
//		}
		Exam101Service service = new Exam101Service();
		service.getCalc(request);
		
		RequestDispatcher rdp = request.getRequestDispatcher("/ch10/example1_result.jsp");
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
