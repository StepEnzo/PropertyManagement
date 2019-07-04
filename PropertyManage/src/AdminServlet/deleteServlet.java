package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.PusDAO;
import Model.UserDAO;
import Name.Pus;

/**
 * Servlet implementation class deleteServlet
 */
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
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
    	
    	String userid = request.getParameter("id");
    	int id = Integer.parseInt(userid);
    	PusDAO pus = PusDAO.getInstance();
    	ArrayList<Pus> list = new ArrayList<Pus>();
    	list = pus.selectByStatus("已领取");
    	boolean a =true;
    	for(Pus p:list) {
    		if(p.getUserid()==id) {
    		PrintWriter out=response.getWriter();
    		out.print("<script>alert('该用户有未归还财产，不能删除');window.location='allUserServlet';</script>");
    		a=false;
    		break;
    	}
    	}
    	if(a) {	
    	UserDAO userDAO = UserDAO.getInstance();
    		boolean f = userDAO.deleteById(id, 0);
    		if(f==false) {
    			PrintWriter out=response.getWriter();
        		out.print("<script>alert('删除失败，请重试');window.location='allUserServlet';</script>");
    		}
    		else {
    			PrintWriter out=response.getWriter();
        		out.print("<script>alert('删除成功');window.location='allUserServlet';</script>");
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
