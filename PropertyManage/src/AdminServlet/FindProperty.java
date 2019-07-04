package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.PropertyDAO;
import Name.PropertyTable;

/**
 * Servlet implementation class FindProperty
 */
public class FindProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindProperty() {
        super();
        // TODO Auto-generated constructor stub
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
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();

		ArrayList<PropertyTable> propertyList = new ArrayList<PropertyTable>();
		PropertyDAO propertyDAO = new PropertyDAO();
		String str = request.getParameter("guanjianci");
		
		propertyList = propertyDAO.searchProperty(str);
		if(propertyList.isEmpty()) {
			out.print("<script>alert('找不到相关资产，请检查关键词是否正确！');window.location='FindProperty.jsp';</script>");
		}else {
			session.setAttribute("propertys",propertyList);
			request.getRequestDispatcher( "FindProperty.jsp").forward(request,response);
		}
		
	}

}
