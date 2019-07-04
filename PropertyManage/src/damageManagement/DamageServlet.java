package damageManagement;

import net.sf.json.JSONArray;

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

        String tag = request.getParameter("tag");
        String id = request.getParameter("id");
        String pid = request.getParameter("pid");
        String level = request.getParameter("level");
        String solution = request.getParameter("solution");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        DamageManagement dm = new DamageManagement();
        switch (tag) {
            case "add":
                pw.println(dm.addDamageInfo(pid, level, solution) ? "Add item successful" : "Add failed");
                pw.flush();
                break;
            case "edit":
                pw.println(dm.editDamageInfo(pid, level, solution) ? "Edit successful" : "Edit failed");
                pw.flush();
                break;
            case "delete":
                pw.println(dm.deleteDamageItem(id) ? "Delete successful" : "Delete failed");
                pw.flush();
                break;
        }
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String offset = request.getParameter("offset");
        offset = new String(offset.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String limit = request.getParameter("limit");
        limit = new String(limit.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        DamageManagement dm = new DamageManagement();

        List<DamageBean> dbs;

        dbs = dm.getDamageInfoList(Integer.parseInt(offset), Integer.parseInt(limit));

        JSONArray jsonArray = JSONArray.fromObject(dbs);
        System.out.println(jsonArray.toString());

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonArray.toString());
        printWriter.flush();
        printWriter.close();
    }
}
