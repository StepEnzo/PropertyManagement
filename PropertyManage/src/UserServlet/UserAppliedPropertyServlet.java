package UserServlet;

import java.io.IOException;
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
 * Servlet implementation class UserAppliedPropertyServlet
 */
public class UserAppliedPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PusDAO pusDAO = new PusDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PusTable> appliedProList = new ArrayList<PusTable>();
		List<Pus> pus1 = new ArrayList<Pus>();
		List<Pus> pus2 = new ArrayList<Pus>();
		List<Pus> pus3 = new ArrayList<Pus>();
		List<Pus> puss = new ArrayList<Pus>();
		String status = "已领取";
		HttpSession session =request.getSession(true);
		int userid=(int)session.getAttribute("userid");
		//将状态为已领取的该用户的资产信息返回
		pus1 = pusDAO.searchByUser_Status(userid, status);
		pus2 = pusDAO.searchByUser_Status(userid, "待审核");
		pus3 = pusDAO.searchByUser_Status(userid, "已拒绝");
		if(pus1.size()>0) {
		for(Pus p:pus1)
			puss.add(p);
		}
		if(pus2.size()>0) {
			for(Pus p:pus2)
				puss.add(p);
			}
		if(pus3.size()>0) {
			for(Pus p:pus3)
				puss.add(p);
			}
		for(Pus p:puss ) {
			PusTable pustable=new PusTable();
			User user = new User();
			PropertyTable property = new PropertyTable();
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
			appliedProList.add(pustable);
		}
		//appliedProList = pusDAO.searchByUser_Status(userid, status);
		request.setAttribute("appliedProList", appliedProList);
		request.getRequestDispatcher("UserAppliedProperty.jsp").forward(request, response);
	}

}
