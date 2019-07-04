package UserServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.PropertyDAO;
import Name.PropertyNameTable;
/**
 * Servlet implementation class UserLookPropertyServlet
 */
public class UserLookPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PropertyDAO propertyDAO = new PropertyDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PropertyNameTable> allProList = new ArrayList<PropertyNameTable>();
		//将所有资产种类的信息存入allProList
		allProList = propertyDAO.allInfo();
		request.setAttribute("allProList", allProList);
		request.getRequestDispatcher("UserLookProperty.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
