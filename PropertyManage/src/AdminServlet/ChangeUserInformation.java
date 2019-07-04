package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import Model.UserDAO;
import Name.User;

/**
 * Servlet implementation class ChangeUserInformation
 */
public class ChangeUserInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		
		int flag = 1;
		User user = new User();
		UserDAO userDAO = new UserDAO();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		int ID = Integer.parseInt(userid);
		user = userDAO.selectByUserid(ID);
		user.setPassword(password);
		user.setPhone(phone);
		user.setUsername(username);
		flag = userDAO.update(user.getId(),user.getAccount(), user.getPassword(), user.getPhone(), user.getUsername(), user.getUsercontrol());
		if(flag == 1) {
			out.print("<script>alert('更改成功');window.location='allUserServlet';</script>");
		}else {
			out.print("<script>alert('更改失败，请重试');window.location='allUserServlet';</script>");
		}
		
	}

}
