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
 * Servlet implementation class UserRequisitionServlet
 */
public class UserRequisitionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PropertyDAO propertyDAO = new PropertyDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PropertyTable> requisitionList = new ArrayList<PropertyTable>();
		String status = "可用";
		//返回所有资产状态为可用的资产信息?
		requisitionList = propertyDAO.searchByStatus(status);
		request.setAttribute("requisitionList", requisitionList);
		request.getRequestDispatcher("UserRequisition.jsp").forward(request, response);
	}

}
