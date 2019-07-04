package AdminServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.PropertyDAO;
import Model.PusDAO;
import Model.UserDAO;
import Name.PropertyTable;
import Name.Pus;
import Name.PusTable;
import Name.User;

/**
 * Servlet implementation class guiHuan
 */
public class guihuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public guihuanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        response.setContentType("text/html; charset=UTF-8");
    	request.setCharacterEncoding("utf-8");
    	 
    	ArrayList<Pus> puslist = new ArrayList<Pus>();
        ArrayList<PusTable> pustablelist = new  ArrayList<PusTable>();
    	try {
    		PusDAO pus = new PusDAO();
    		//获取pus表中已领取的列表。
    		puslist=pus.selectByStatus("已领取");
    		for(Pus p:puslist ) {
    			PusTable pustable=new PusTable();
    			User user = new User();
    			PropertyTable property = new PropertyTable();
    			int userid=p.getUserid();
    			System.out.println(userid);
    			int propertyid=p.getPropertyid();
    			PropertyDAO propertyDAO=new PropertyDAO();
    			UserDAO userDAO=new UserDAO();
    			//根据返回的pus中的userid在user表中查询该user的具体信息。
    			user=userDAO.selectByUserid(userid);
    			//根据返回的pus中的propertyid在propertyname表与propertyitem表中查询该资产的具体信息。
    			property=propertyDAO.searchByPid(propertyid);
    			//将获取的user信息与property信息整合到pusTable中。
    			pustable.setUserid(userid);
    			pustable.setAccount(user.getAccount());
    			pustable.setPassword(user.getPassword());
    			pustable.setPhone(user.getPhone());
    			pustable.setUsername(user.getUsername());
    			pustable.setId(property.getId());
    			pustable.setPropertyid(property.getPid());
    			pustable.setPropertyname(property.getPropertyname());
    			pustable.setBrand(property.getBrand());
    			pustable.setModelnumber(property.getModelnumber());
    			pustable.setSpecification(property.getSpecification());
    			pustable.setBuydate(property.getDate());
    			pustable.setDate(p.getDate());
    			pustable.setStatus(p.getStatus());
    			pustablelist.add(pustable);
    		}
    		request.setAttribute("guihuan", pustablelist);
    		request.getRequestDispatcher("./Guihuan.jsp").forward(request, response);
    		
    	}catch (NumberFormatException e) {
			
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
