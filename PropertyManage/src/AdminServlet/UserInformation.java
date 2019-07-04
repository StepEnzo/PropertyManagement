package AdminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.UserDAO;
import Name.User;

/**
 * Servlet implementation class UserInformation
 */
public class UserInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		User user = new User();
		UserDAO userDAO = new UserDAO();
		String userID = request.getParameter("id");
		int ID = Integer.parseInt(userID);
		user = userDAO.selectByUserid(ID);
		
		session.setAttribute("useid", user.getId());
		session.setAttribute("useaccound", user.getAccount());
		session.setAttribute("usepassword", user.getPassword());
		session.setAttribute("usephone", user.getPhone());
		session.setAttribute("usename", user.getUsername());
		
		request.getRequestDispatcher( "UserInformation.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		
//		User user = new User();
//		UserDAO userDAO = new UserDAO();
//		String userID = request.getParameter("ID");
//		int ID = Integer.parseInt(userID);
//		user = userDAO.selectByUserid(ID);
//		
//		session.setAttribute("usepassword", user.getPassword());
//		session.setAttribute("usephone", user.getPhone());
//		session.setAttribute("usename", user.getUsername());
//		
//		request.getRequestDispatcher( "UserInformation.jsp").forward(request,response);
		
	}

}
