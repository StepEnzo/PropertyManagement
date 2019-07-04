package AdminServlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class UserHistory
 */
public class UserHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHistory() {
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
				
				String usertyid = request.getParameter("userid");
				int  uid = Integer.parseInt(usertyid);
				ArrayList<Pus> pus = new ArrayList<Pus>();
				ArrayList<PusTable> pusTable = new ArrayList<PusTable>();
				PusDAO  pusDAO = new PusDAO();
				
				pus = pusDAO.selectByUserid(uid);
				for(Pus p : pus) {
					PusTable pTable = new PusTable();
					User user = new User();
					UserDAO userDAO = new UserDAO();
					PropertyTable property = new PropertyTable();
					PropertyDAO propertyDAO = new PropertyDAO();
					
					user = userDAO.selectByUserid(p.getUserid());
					property = propertyDAO.searchByPid(p.getPropertyid());
					
					
					pTable.setUsername(user.getUsername());
					pTable.setBuydate(property.getDate());
					pTable.setModelnumber(property.getModelnumber());
					pTable.setBrand(property.getBrand());
					pTable.setSpecification(property.getSpecification());
					pTable.setPropertyname(property.getPropertyname());
					pTable.setPropertyid(p.getPropertyid());
					pTable.setUserid(p.getUserid());
					pTable.setStatus(p.getStatus());
					pTable.setDate(p.getDate());
					pusTable.add(pTable);
				}
				
				session.setAttribute("pusofuser", pusTable);
				
				request.getRequestDispatcher( "UserHistory.jsp").forward(request,response);
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
//		
//		String usertyid = request.getParameter("userid");
//		int  uid = Integer.parseInt(usertyid);
//		ArrayList<Pus> pus = new ArrayList<Pus>();
//		PusDAO  pusDAO = new PusDAO();
//		
//		pus = pusDAO.selectByUserid(uid);
//		session.setAttribute("pusofuser", pus);
//		
//		request.getRequestDispatcher( "userHistory.jsp").forward(request,response);
	}

}
