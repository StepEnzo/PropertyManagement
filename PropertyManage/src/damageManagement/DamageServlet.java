package damageManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DamageServlet")
public class DamageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //123321112

        String tag = request.getParameter("tag");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        DamageManagement dm = new DamageManagement();
        switch (tag) {
            case "add":
                Integer pid =Integer.parseInt(request.getParameter("pid"));
                String level = request.getParameter("level");
                String solution = request.getParameter("solution");
                pw.println(dm.addDamageInfo(pid, level, solution) ? "Add item successful" : "Add failed");
                break;
            case "edit":
                int id1 = Integer.parseInt(request.getParameter("id"));
                int pid1 =Integer.parseInt(request.getParameter("pid"));
                String level1 = request.getParameter("level");
                String solution1 = request.getParameter("solution");
                pw.println(dm.editDamageInfo(id1,pid1, level1, solution1) ? "Edit successful" : "Edit failed");
                break;
        }
        DamageManagement damage = new DamageManagement();
        List<DamageBean> dbs;
        dbs = damage.getDamageInfo();
        request.setAttribute("damages",dbs);
        request.getRequestDispatcher("Damage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
    	request.setCharacterEncoding("utf-8");
    	String tag = request.getParameter("tag");
    	System.out.print(tag);
    	if(tag==null){
        	DamageManagement dm = new DamageManagement();
            List<DamageBean> dbs;
            dbs = dm.getDamageInfo();
            request.setAttribute("damages",dbs);
            request.getRequestDispatcher("Damage.jsp").forward(request,response);
    	}
    	else if(tag.equals("delete")){
    		DamageManagement damage = new DamageManagement();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            Integer id2 = Integer.parseInt(request.getParameter("id"));
            pw.println(damage.deleteDamageItem(id2) ? "Delete successful" : "Delete failed");
            List<DamageBean> dbs;
            dbs = damage.getDamageInfo();
            request.setAttribute("damages",dbs);
            request.getRequestDispatcher("Damage.jsp").forward(request,response);
    	}
    }
}
