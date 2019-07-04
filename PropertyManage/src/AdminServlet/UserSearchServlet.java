package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.UserDAO;
import Name.User;

public class UserSearchServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	
	  public UserSearchServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  UserDAO userDAO = UserDAO.getInstance();
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String str = request.getParameter("guanjianci");
		List<User> users = userDAO.search(str);

		if(users.isEmpty()) {
			out.print("<script>alert('找不到相关用户，请检查关键词是否正确！');window.location='FindUser.jsp';</script>");
		}else {
			session.setAttribute("users",users);
			request.getRequestDispatcher("FindUser.jsp").forward(request, response);
		}
		
	}
	
}
