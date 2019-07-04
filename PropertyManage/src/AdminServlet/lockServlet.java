package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import Model.PusDAO;
import Model.UserDAO;
//import Name.Pus;

/**
 * Servlet implementation class lockServlet
 */
public class lockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lockServlet() {
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
    	PrintWriter out=response.getWriter();
    	String userid = request.getParameter("id");
    	String usercol =request.getParameter("col");
    	int id = Integer.parseInt(userid);
    	int col =Integer.parseInt(usercol);
    	UserDAO userDAO = UserDAO.getInstance();
    	if(col==1) {
    		boolean f1 = userDAO.deleteById(id, -1);
    		if(f1==false) {
        		out.print("<script>alert('操作失败，请重试');window.location='allUserServlet';</script>");
    		}
    		else {
        		out.print("<script>alert('锁定成功');window.location='allUserServlet';</script>");
    		}
    	}
    	else {
    		boolean f2 = userDAO.deleteById(id, 1);
    		if(f2==false) {
        		out.print("<script>alert('操作失败，请重试');window.location='allUserServlet';</script>");
    		}
    		else {
        		out.print("<script>alert('解锁成功');window.location='allUserServlet';</script>");
    		}
    	}
    		
    		
    		
    		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
