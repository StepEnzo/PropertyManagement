package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AdminDao;

public class ChangeCreditValueServlet extends HttpServlet {
	
	private AdminDao adminDao = new AdminDao();
	
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		int flag=0;
		try {
			flag = adminDao.changecreditvalue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if (flag == 1)
		{
			out.println("<script language='javascript'>alert('恢复成功！')</script>");
			out.println("<script language='javascript'>window.location.href='ShenheServlet'</script>");
		}
		else {
			out.println("<script language='javascript'>alert('恢复失败)</script>");
			out.println("<script language='javascript'>window.location.href='ShenheServlet'</script>");
		}
	}
}


