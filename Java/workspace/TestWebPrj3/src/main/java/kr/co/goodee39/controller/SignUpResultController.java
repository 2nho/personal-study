package kr.co.goodee39.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.goode39.service.LoginService;
import kr.co.goodee39.vo.UserVO;

/**
 * Servlet implementation class SignUpResultController
 */
@WebServlet("/SignUpResultController")
public class SignUpResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpResultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		UserVO vo = new UserVO();
		
		LoginService service = new LoginService();
		
		vo.setUserid(request.getParameter("id"));
		String path ="";
		
		UserVO result = service.getUser(vo);
		if(result!=null) {
			path ="/WEB-INF/app/sign_up.jsp";
		}else {
			vo.setPassword(request.getParameter("pw"));
			vo.setName(request.getParameter("name"));
			service.setUser(vo);
			path ="/WEB-INF/app/login.jsp";
		}
		
		RequestDispatcher rdp = request.getRequestDispatcher(path);
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
