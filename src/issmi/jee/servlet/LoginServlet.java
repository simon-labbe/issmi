package issmi.jee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import issmi.jee.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/jeetest/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		String email = request.getParameter("loginmail");
		String password = request.getParameter("loginpwd");
		boolean new_account = (request.getParameter("loginnew") == null?false:true);
		boolean staylogged = (request.getParameter("loginstaylog") == null?false:true);
		
		if(testLogin(email, password)) {
			System.out.println("auth OK");
			request.getSession().setAttribute("user", new User(email, password));
			request.getRequestDispatcher("WEB-INF/app.jsp").forward(request, response);
		}
		System.out.println("m:"+email+"\tp:"+password+"\tn:"+new_account+"\ts:"+staylogged);
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		
	}

	private boolean testLogin(String email, String password) {
		if(password.equals("xd")) return true;
		return false;
	}

}
