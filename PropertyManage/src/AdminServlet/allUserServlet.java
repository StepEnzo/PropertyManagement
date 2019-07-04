package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import Model.PropertyDAO;
//import Model.PusDAO;
import Model.UserDAO;
//import Name.PropertyTable;
//import Name.Pus;
//import Name.PusTable;
import Name.User;

/**
 * Servlet implementation class allUserServlet
 */
public class allUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
    response.setContentType("text/html; charset=UTF-8");
	request.setCharacterEncoding("utf-8");
	 UserDAO userDAO = UserDAO.getInstance();
	HttpSession session = request.getSession();
	PrintWriter out = response.getWriter();
	List<User> users = userDAO.searchall();

	if(users.isEmpty()) {
		out.print("<script>alert('无用户，请确认！');window.location='FindUser.jsp';</script>");
	}else {
		session.setAttribute("users",users);
		request.getRequestDispatcher("FindUser.jsp").forward(request, response);
	}
	
}

		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
