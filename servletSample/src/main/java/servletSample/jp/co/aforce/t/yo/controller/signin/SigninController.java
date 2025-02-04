package servletSample.jp.co.aforce.t.yo.controller.signin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletSample.jp.co.aforce.t.yo.dto.UsersDto;
import servletSample.jp.co.aforce.t.yo.model.SigninModel;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/signin")
public class SigninController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		SigninModel model = new SigninModel();
		UsersDto result = model.checkExistsUser(id, password);
		
		if(result.getUserID() == null) {
			request.setAttribute("errorMsg", "IDまたはパスワードが誤っています");
			
			RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("id", id);
			request.setAttribute("password", password);
			request.setAttribute("name", result.getUserName());
			request.setAttribute("age", result.getAge());
			RequestDispatcher rd = request.getRequestDispatcher("top.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
