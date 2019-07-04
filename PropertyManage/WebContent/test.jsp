<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
     <%@ page import="Model.*" %>
      <%@ page import="Name.*" %>
       <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%

	//PropertyDAO k =new PropertyDAO();
	//boolean f = k.addProperty("z", "b", "a", "a", "2018-1-1");
	//System.out.print(f);
	/* ArrayList<Pus> l=new ArrayList<Pus>();
 PusDAO a =new PusDAO();
 l= a.selectByPropertyid(1);
 for(Pus c:l){
	 System.out.println(c.getUserid());
 }*/
 
 	Calendar c= Calendar.getInstance();
 	java.util.Date d=c.getTime();
	java.sql.Date date = new java.sql.Date(d.getTime());
    System.out.println(date);
	%>

</body>
</html>