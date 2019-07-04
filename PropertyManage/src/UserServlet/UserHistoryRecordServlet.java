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
import Name.User;;
/**
 * Servlet implementation class UserHistoryRecordServlet
 */
public class UserHistoryRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PusDAO pusDAO = new PusDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PusTable> historyList = new ArrayList<PusTable>();
		List<Pus> puss = new ArrayList<Pus>();
		String status = "已归还";
		HttpSession session =request.getSession(true);
		int userid=(int)session.getAttribute("userid");
		//将状态为已归还的该用户的资产信息返回存入 
		puss = pusDAO.searchByUser_Status(userid, status);
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
			historyList.add(pustable);
		}
		request.setAttribute("historyList", historyList);
		request.getRequestDispatcher("UserHistoryRecord.jsp").forward(request, response);
	}

}
