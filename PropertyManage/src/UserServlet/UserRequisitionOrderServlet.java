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
 * Servlet implementation class UserRequisitionOrderServlet
 */
public class UserRequisitionOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PropertyDAO propertyDAO = new PropertyDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PropertyTable> requisitionList = new ArrayList<PropertyTable>();
		String[] itemsSelected;
		int pid;
		itemsSelected=request.getParameterValues("item");
	    for(int i=0;i<itemsSelected.length;i++){
			pid=Integer.parseInt(itemsSelected[i]);
//			System.out.println(pid);
			requisitionList.add(propertyDAO.searchByPid(pid));
		}
		request.setAttribute("requisitionList", requisitionList);
		request.getRequestDispatcher("UserRequisitionOrder.jsp").forward(request, response);
	}

}
