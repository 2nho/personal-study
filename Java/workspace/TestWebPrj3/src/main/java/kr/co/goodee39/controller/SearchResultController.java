package kr.co.goodee39.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.goode39.service.LoginService;
import kr.co.goodee39.vo.UserVO;

/**
 * Servlet implementation class SearchResultController
 */
@WebServlet("/SearchResultController")
public class SearchResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserVO vo = new UserVO();
		vo.setUserid(request.getParameter("id"));
		
		LoginService service = new LoginService();
		vo = service.getUser(vo);
		String path = "";
		
		if(vo != null) {
			request.setAttribute("vo", vo);
			path = "/WEB-INF/app/success_find_account.jsp";
		}else {
			path = "/WEB-INF/app/search_page.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
