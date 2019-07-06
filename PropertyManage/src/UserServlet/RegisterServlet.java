package UserServlet;

import Model.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO=UserDAO.getInstance();
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        int result= userDAO.add(username,account,password,email);
        if(result==1){
            out.println("<script language='javascript'>alert('注册成功！')</script>");
            out.println("<script language='javascript'>window.location.href='login.jsp'</script>");
        }else if(result==0){
            out.println("<script language='javascript'>alert('注册失败，请重新注册！')</script>");
        }else if(result==2){
            out.println("<script language='javascript'>alert('注册失败，用户名重复！')</script>");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
