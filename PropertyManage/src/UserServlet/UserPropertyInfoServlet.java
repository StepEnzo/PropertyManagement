package UserServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.PropertyDAO;
import Name.PropertyTable;
/**
 * Servlet implementation class UserPropertyInfoServlet
 */
public class UserPropertyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PropertyDAO propertyDAO = new PropertyDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PropertyTable> propertyInfoList = new ArrayList<PropertyTable>();
		int id = Integer.parseInt(request.getParameter("id"));
		//将符合id的详细资产信息返回
		propertyInfoList = propertyDAO.searchById(id);
		request.setAttribute("propertyInfoList", propertyInfoList);
		request.getRequestDispatcher("UserPropertyInfo.jsp").forward(request, response);
	}

}
