<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>企业资产管理系统</title>
<style>
    .bg{
        background:url("image/bg.jpeg") no-repeat;
       background-size:cover;
    }
    .box{
        padding:40px;
        width:60%;
        margin-left:25%;
        font-size:25px;
    }
    .container { 
        border:2px solid #ccc; 
        width:600px; 
        height: 500px; 
        overflow-y: scroll;
        font-size:20px; 
    }
form.style {
    width: 600px;
    padding: 30px 30px 20px 30px;
    font: 12px Arial, Helvetica, sans-serif;
    border-radius: 5px;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    background-color:rgba(255,255,255,0.6);
}
form.style h1 {
    font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
    padding: 20px 0px 20px 40px;
    display: block;
    margin: -30px -30px 10px -30px;
    color: #FFF;
    background: #9DC45F;
    text-shadow: 1px 1px 1px #949494;
    border-radius: 5px 5px 0px 0px;
    -webkit-border-radius: 5px 5px 0px 0px;
    -moz-border-radius: 5px 5px 0px 0px;
    border-bottom:1px solid #89AF4C;
}
form.style h1>span {
    display: block;
    font-size: 15px;
    color: #FFF;
}
form.style .button {
    background-color: #9DC45F;
    border-radius: 5px;
    -webkit-border-radius: 5px;
    -moz-border-border-radius: 5px;
    border: none;
    margin:10px 50px;
    padding: 10px 25px 10px 25px;
    color: #FFF;
    text-shadow: 1px 1px 1px #949494;
}
form.style .button:hover {
    background-color:#80A24A;
}

table.style {
	font-family: verdana,arial,sans-serif;
	font-size:15px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.style th {
	background:#9DC45F;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
table.style td {
	background:#dcddc0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
</style>
</head>
<body class="bg">
<jsp:include page="UserHeader.jsp" />
<jsp:include page="UserNavigationBar.jsp" />

<div class="box">
 <form class="style" method="POST" action="UserapplyServlet" >
    <h1>本次申请领用资产如下<span>确认无误后点击按钮提交审核</span></h1>
    <div class="container">
    <table class="style">
    <tr>
    <th>勾选框</th>
    <th>资产名称</th>
    <th>品牌</th>
    <th>型号</th>
    <th>规格</th>
    <th>采购日期</th>
    </tr>
    <c:forEach var="item" items="${requisitionList}">
    <tr>
    <td><input id="item" name="item" type="checkbox" value="${item.pid}" checked="checked"/></td>
    <td>${item.propertyname}</td>
    <td>${item.brand}</td>
    <td>${item.modelnumber}</td>
    <td>${item.specification}</td>
    <td>${item.date}</td>
    </tr>
    </c:forEach>
    </table>
    </div>
    <input class="button" type="submit" value="申请"/> 
    <input class="button" type="button" value="返回重新选择" onclick="window.location.href('UserRequisition.jsp')" />
</form>
</div>

<jsp:include page="UserFooter.jsp" />
</body>
</html>