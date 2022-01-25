package kr.co.goodee39.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz1Controller
 */
@WebServlet("/Quiz1Controller")
public class Quiz1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz1Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String isChecked = request.getParameter("chk");
		
		if(isChecked == null) {
			isChecked = "N";
		}
		
		if(isChecked.equals("Y")) {
			Cookie cookie = new Cookie("id", request.getParameter("id"));
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}else {
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("id")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		
		RequestDispatcher rdp = request.getRequestDispatcher("/sol/Quiz1_3.jsp");
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
