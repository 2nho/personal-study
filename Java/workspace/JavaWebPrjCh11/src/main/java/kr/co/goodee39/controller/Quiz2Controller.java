package kr.co.goodee39.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.goodee39.vo.ScoreVO;

/**
 * Servlet implementation class Quiz2Controller
 */
@WebServlet("/Quiz2Controller")
public class Quiz2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz2Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ScoreVO vo = new ScoreVO();
		vo.setGuk(Integer.parseInt(request.getParameter("guk")));
		vo.setEng(Integer.parseInt(request.getParameter("eng")));
		vo.setMath(Integer.parseInt(request.getParameter("math")));
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher rdp = request.getRequestDispatcher("/sol/quiz2_1.jsp");
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
