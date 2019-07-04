package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AdminDao;

public class AdminLogInServlet extends HttpServlet {
	private AdminDao adminDAO = new AdminDao();
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
				response.setContentType("text/html;charset = UTF-8");
				PrintWriter out = response.getWriter();
				String account = request.getParameter("account");
				String password = request.getParameter("password");
				int isLoginSuccess ;
				HttpSession session = request.getSession();
				session.setAttribute("account1", account);
				isLoginSuccess = adminDAO.logIn(account, password);
				
				if (isLoginSuccess == 1)
				{
					Cookie accountcookie = new Cookie("account1", account);
			    	Cookie passwordcookie = new Cookie("password1", password);
			    	//不设置的话，则cookies不写入硬盘,而是写在内存,只在当前页面有用,以秒为单位
				    accountcookie.setMaxAge(24*60*60);
				    passwordcookie.setMaxAge(24*60*60);
				    response.addCookie(accountcookie);
				    response.addCookie(passwordcookie);
					request.getRequestDispatcher("ShenheServlet").forward(request, response);
				}
				else if (isLoginSuccess == 0)
				{
					out.println("<script language='javascript'>alert('该管理员不存在')</script>");
					out.println("<script language='javascript'>window.location.href='adminLogin.jsp'</script>");
				}
				else {
					out.println("<script language='javascript'>alert('账号名或密码错误，请重新输入！')</script>");
					out.println("<script language='javascript'>window.location.href='adminLogin.jsp'</script>");
				}
			}
}
