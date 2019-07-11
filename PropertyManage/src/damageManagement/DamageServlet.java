package damageManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "DamageServlet")
public class DamageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //123321112

        String tag = request.getParameter("tag");
        System.out.print(2);
        System.out.print(tag);
        int id = Integer.parseInt(request.getParameter("id"));
        int pid =Integer.parseInt(request.getParameter("pid"));
        String level = request.getParameter("level");
        String solution = request.getParameter("solution");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        DamageManagement dm = new DamageManagement();
        switch (tag) {
            case "add":
            	System.out.print(1);
                pw.println(dm.addDamageInfo(pid, level, solution) ? "Add item successful" : "Add failed");
                pw.flush();
                break;
            case "edit":
                pw.println(dm.editDamageInfo(id,pid, level, solution) ? "Edit successful" : "Edit failed");
                pw.flush();
                break;
            case "delete":
                pw.println(dm.deleteDamageItem(id) ? "Delete successful" : "Delete failed");
                pw.flush();
                break;
        }
        pw.close();
//        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DamageManagement dm = new DamageManagement();
        List<DamageBean> dbs;
        dbs = dm.getDamageInfo();
        request.setAttribute("damages",dbs);
        request.getRequestDispatcher("Damage.jsp").forward(request,response);
    }
}
