package damageManagement;

import damageManagement.DamageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditDamage")
public class EditDamage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        DamageBean damage=new DamageBean();
        damage.setId(id);
        request.setAttribute("damage",damage.getId());
        request.getRequestDispatcher("EditDamage.jsp").forward(request,response);
    }
}
