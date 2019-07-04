package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.PropertyDAO;
import Model.PusDAO;

/**
 * Servlet implementation class yes
 */
public class yes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public yes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
    	request.setCharacterEncoding("utf-8");
    	
    	int userid,pid;
    	Calendar c= Calendar.getInstance();
    	String uid = request.getParameter("userid");
    	String id =request.getParameter("pid");
    	
    	System.out.println(uid);
    	System.out.println(id);
    	
    	 userid = Integer.parseInt(uid);
    	 pid = Integer.parseInt(id);
    	java.util.Date d=c.getTime();
    	java.sql.Date date = new java.sql.Date(d.getTime());
    	PropertyDAO propertyDAO = new PropertyDAO();
		try {
			boolean f1= propertyDAO.updateStatus(pid, "不可用");
			if(f1==false) {
	    		PrintWriter out=response.getWriter();
	    		out.print("<script>alert('产品状态更改失败，请重试');window.location='ShenheServlet';</script>");

	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PusDAO pusDAO = new PusDAO();
    	boolean f=pusDAO.changeStatus(userid, pid, "待审核", "已领取", date);
    	if(f==false) {
    		PrintWriter out=response.getWriter();
    		out.print("<script>alert('批准失败，请重试');window.location='ShenheServlet';</script>");

    	}
		
    	
    	request.getRequestDispatcher("./ShenheServlet").forward(request, response);
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
