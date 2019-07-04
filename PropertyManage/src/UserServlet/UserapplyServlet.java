package UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Date;
//import java.text.ParsePosition;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import Model.PropertyDAO;
import Model.PusDAO;
//import Name.PropertyTable;
import Name.Pus;

/**
 * Servlet implementation class UserapplyServlet
 */
public class UserapplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PusDAO pusDAO = new PusDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] itemsSelected;
		
		itemsSelected=request.getParameterValues("item");
		PrintWriter out = response.getWriter();
		String status = "待审核";
		HttpSession session =request.getSession(true);
		int userid=(int)session.getAttribute("userid");
		//获取时间
//		Date currentTime = new Date(0);
//	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    String dateString = formatter.format(currentTime);
//	    ParsePosition pos = new ParsePosition(8);
//	    Date currentTime_2 = (Date) formatter.parse(dateString, pos);
		Calendar c= Calendar.getInstance();
		java.util.Date d=c.getTime();
    	java.sql.Date date = new java.sql.Date(d.getTime());
    	System.out.println(date);
	    for(int i=0;i<itemsSelected.length;i++){
			int pid=Integer.parseInt(itemsSelected[i]);
			System.out.println(pid);
			Pus pus = new Pus();
			pus.setDate(date);
			pus.setStatus(status);
			pus.setPropertyid(pid);
			pus.setUserid(userid);
			boolean f=pusDAO.insert(pus);
			if(f==false) {
				out.print("<script>alert('更新失败，请重试！');window.location='UserRequisitionServle';</script>");
			}
		}
		response.sendRedirect("UserAppliedPropertyServlet");
	}

}
