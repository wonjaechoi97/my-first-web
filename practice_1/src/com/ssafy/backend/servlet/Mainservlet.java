package com.ssafy.backend.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.backend.dto.Book;
import com.ssafy.backend.dto.User;
import com.ssafy.backend.service.BookService;
import com.ssafy.backend.service.BookServiceImpl;
import com.ssafy.backend.service.UserService;
import com.ssafy.backend.service.UserServiceImpl;

/**
 * Servlet implementation class Mainservlet
 */
@WebServlet("/main")
public class Mainservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private BookService bsvc = BookServiceImpl.getInstance();
    private UserService usvc = UserServiceImpl.getInstance();
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		switch(action) {
		case "regist_form":
			regist_form(request, response);
			break;
		case "regist":
			regist(request, response);
			break;
		case "login":
			login(request, response);
			break;
		case "list":
			list(request, response);
			break;
		case "logout":
			logout(request, response);
			break;
		case "dele":
			dele(request, response);
			break;
		case "delm":
			delm(request, response);
			break;
		case "view":
			view(request, response);
			break;
		case "endbook":
			endbook(request, response);
			break;
		
		}
	}

	

	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Book book = null;
		String isbn = request.getParameter("isbn");
		try {
			book = bsvc.select(isbn);
			if(book!=null) {
				request.setAttribute("book", book);
				request.getRequestDispatcher("/view.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			response.sendRedirect("error/500.jsp");
			e.printStackTrace();
		}
		
	}

	private void endbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if("endbook".equals(cookie.getName())) {
				try {
					Book book = bsvc.select(cookie.getValue());
					request.setAttribute("book", book);
					request.getRequestDispatcher("/view.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

	private void delm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String[] isbns = request.getParameterValues("isbns");
		try {
			for(int i=0; i<isbns.length; i++) {
				bsvc.delete(isbns[i]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("main?action=list").forward(request, response);
		
	}

	private void dele(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String isbn = request.getParameter("isbn");
		try {
			bsvc.delete(isbn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("msg", "삭제가 완료되었습니다.");
		request.getRequestDispatcher("/main?action=list").forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("msg", "로그아웃 되었습니다.");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		try {
			User user = usvc.select(id);
			if(user!=null && user.getPass().equals(pass)) {
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", user);
				response.sendRedirect(request.getContextPath());
			}else {
				request.setAttribute("msg", "아이디 혹은 비밀번호를 확인하세요");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			response.sendError(500);
			e.printStackTrace();
		}
		
	}

	private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
		String img = request.getParameter("img");
		
		Book book = new Book(isbn, title, author, price, desc, img);
		try {
			int result = bsvc.insert(book);
			System.out.println(result);
			if(result>0) {
				Cookie cookie = new Cookie("endbook", isbn);
				cookie.setMaxAge(60*60);
				response.addCookie(cookie);
				request.setAttribute("book", book);
				request.getRequestDispatcher("/regist_result.jsp").forward(request, response);
				
			}else {
				request.setAttribute("msg", "이미 등록된 번호입니다.");
				request.getRequestDispatcher("/main?action=regist_form");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			List<Book> books = bsvc.select();
			request.setAttribute("books", books);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void regist_form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect(request.getContextPath()+"/regist.jsp");
		
	}

}
