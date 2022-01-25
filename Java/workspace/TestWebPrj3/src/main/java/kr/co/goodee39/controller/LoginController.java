package kr.co.goodee39.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.goode39.service.LoginService;
import kr.co.goodee39.vo.UserVO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		LoginService service = new LoginService();
		UserVO vo = new UserVO();
		vo.setUserid(request.getParameter("id"));
		vo.setPassword(request.getParameter("pw"));
		vo = service.getUser(vo);
		String path = "";
		
		if(vo == null) {
			path ="/WEB-INF/app/login.jsp";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo);
			path ="/WEB-INF/app/login_success.jsp";
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
