package servletSample.jp.co.aforce.t.yo.controller.registration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletSample.jp.co.aforce.t.yo.dao.RegisterDao;
import servletSample.jp.co.aforce.t.yo.dto.UsersDto;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        
        UsersDto user = new UsersDto();
        user.setUserID(id);
        user.setPassword(password);
        user.setUserName(username);
        user.setAge(age);

        RegisterDao dao = new RegisterDao();
        boolean isSuccess = dao.insertUser(user);

        if (isSuccess) {
            response.sendRedirect("signin.jsp");
        } else {
            request.setAttribute("error", "登録に失敗しました。");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
	}

}
