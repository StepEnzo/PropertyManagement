package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.PusDAO;

/**
 * Servlet implementation class no
 */
public class no extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public no() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
    	request.setCharacterEncoding("utf-8");
    	System.out.println("uid"   );
    	int userid,pid;
    	Calendar c= Calendar.getInstance();
    	String uid = request.getParameter("userid");
    	String id =request.getParameter("pid");
    	
    	System.out.println("uid"   +uid);
    	System.out.println(id);
    	
    	 userid = Integer.parseInt(uid);
    	 pid = Integer.parseInt(id);
    	java.util.Date d=c.getTime();
    	java.sql.Date date = new java.sql.Date(d.getTime());

		PusDAO pusDAO = new PusDAO();
    	boolean f=pusDAO.changeStatus(userid, pid, "待审核", "已拒绝", date);
    	if(f==false) {
    		PrintWriter out=response.getWriter();
    		out.print("<script>alert(操作失败，请重试');window.location='ShenheServlet';</script>");

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
