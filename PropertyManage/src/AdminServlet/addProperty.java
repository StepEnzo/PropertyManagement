package AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.PropertyDAO;

/**
 * Servlet implementation class addProperty
 */
public class addProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProperty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
    	request.setCharacterEncoding("utf-8");
    	
    	String name = request.getParameter("propertyname");
    	System.out.println(name);
    	String brand = request.getParameter("brand");
    	String modelnumber = request.getParameter("modelnumber");
    	String specification = request.getParameter("specification");
    	String n = request.getParameter("number");
    	Calendar c=Calendar.getInstance();
    	java.util.Date d=c.getTime();
    	java.sql.Date date = new java.sql.Date(d.getTime());
    	int number = Integer.parseInt(n);
    	boolean f;
    	for (int i=0;i<number;i++) {
    		PropertyDAO propertyDAO = new PropertyDAO();
    		try {
				 f = propertyDAO.addProperty(name, brand, modelnumber, specification, date);
				 if(f==false) {
		        		PrintWriter out=response.getWriter();
		        		out.print("<script>alert(添加失败，请重试');window.location='AddProperty.jsp';</script>");
		        	}
				 else {
					 PrintWriter out=response.getWriter();
		        		out.print("<script>alert('添加成功');window.location='AddProperty.jsp';</script>");
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	request.getRequestDispatcher("./AddProperty.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

}
}
