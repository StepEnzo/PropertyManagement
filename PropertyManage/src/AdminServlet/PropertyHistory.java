package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.PropertyDAO;
import Model.PusDAO;
import Model.UserDAO;
import Name.PropertyTable;
import Name.Pus;
import Name.PusTable;
import Name.User;

/**
 * Servlet implementation class PropertyHistoty
 */
public class PropertyHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.setContentType("text/html; charset=UTF-8");
				request.setCharacterEncoding("UTF-8");
				HttpSession session = request.getSession();
				//PrintWriter out=response.getWriter();
				String propertyid = request.getParameter("propertyid");
				int  pid = Integer.parseInt(propertyid);
				List<Pus> pus = new ArrayList<Pus>();
				ArrayList<PusTable> pusTable = new ArrayList<PusTable>();
				PusDAO  pusDAO = new PusDAO();
				
				
				pus = pusDAO.selectByPropertyid(pid);
				if(pus.isEmpty()) {
					PrintWriter out = response.getWriter();
					out.println("<script language='javascript'>alert('该资产无出借历史')</script>");
					out.println("<script language='javascript'>window.location.href='FindProperty.jsp'</script>");
				}
				else {
				for(Pus p : pus) {
					PusTable pTable = new PusTable();
					User user = new User();
					UserDAO userDAO = new UserDAO();
					PropertyTable property = new PropertyTable();
					PropertyDAO propertyDAO = new PropertyDAO();
					
					user = userDAO.selectByUserid(p.getUserid());
					property = propertyDAO.searchByPid(p.getPropertyid());
					
					
					pTable.setUsername(user.getUsername());
					pTable.setPhone(user.getPhone());
					pTable.setPropertyname(property.getPropertyname());
					
					pTable.setPropertyid(pid);
					//System.out.println(p.getPropertyid());
					pTable.setUserid(p.getUserid());
					pTable.setStatus(p.getStatus());
					pTable.setDate(p.getDate());
					pusTable.add(pTable);
				
				
				session.setAttribute("pusofproperty", pusTable);
				
				request.getRequestDispatcher( "PropertyHistory.jsp").forward(request,response);
				}
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		//PrintWriter out=response.getWriter();
//		System.out.print("111jin");
//		String propertyid = request.getParameter("propertyid");
//		int  pid = Integer.parseInt(propertyid);
//		ArrayList<Pus> pus = new ArrayList<Pus>();
//		PusDAO  pusDAO = new PusDAO();
//		
//		pus = pusDAO.selectByPropertyid(pid);
//		session.setAttribute("pusofproperty", pus);
//		
//		request.getRequestDispatcher( "PropertyHistory.jsp").forward(request,response);
	}

}
