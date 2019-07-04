package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UserDAO;


public class UserPasswordReset extends HttpServlet{
	private static final long serialVersionUID = 1L;

	 protected void service(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html; charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();
	        int id = Integer.parseInt(request.getParameter("id"));
	        UserDAO userDao = new UserDAO();
	        int flag = userDao.update1(id);
	        if (flag == 1) {
	        	out.print("<script>alert('重置成功！');window.location='allUserServlet';</script>");
        } else {
        	out.print("<script>alert('重置失败！');window.location='allUserServlet';</script>");
	        }

	    }
}
