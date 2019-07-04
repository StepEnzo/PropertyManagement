package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UserDAO;
//import Name.User;


public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private UserDAO userDAO = UserDAO.getInstance();
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
    	request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String account  = request.getParameter("account");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
	//	User user = new User();
		
		int isAddSuccess = -1;
		isAddSuccess = userDAO.add(account,password,phone,username);
		if (isAddSuccess == 1)
		{   
//			user.setAccount(account);
//			user.setPassword(password);
//			user.setPhone(phone);
//			user.setUsername(username);
			
			out.println("<script language='javascript'>alert('添加成功！')</script>");
			System.out.println("成功");
            out.println("<script language='javascript'>window.location.href='AddUser.jsp'</script>");
		}
		else if (isAddSuccess == -2)
		{
			PrintWriter out1 = response.getWriter();
			out1.println("<script language='javascript'>alert('账号名重复')</script>");
			out.println("<script language='javascript'>window.location.href='AddUser.jsp'</script>");
			System.out.println("重复");
//            out.println("<script language='javascript'>window.location.href='UserAdd.jsp'</script>");
		}
		else {
			out.println("<script language='javascript'>alert('添加失败，请重试！')</script>");
			System.out.println("失败");
            out.println("<script language='javascript'>window.location.href='AddUser.jsp'</script>");
		}
	}

}
