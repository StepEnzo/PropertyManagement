<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 盈凯
  Date: 2019/7/10
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .bg{
            background:url("image/bg.jpeg") no-repeat;
            background-size:cover;
        }
        .box{
            padding:40px;
            width:60%;
            margin-left:25%;
            font-size:30px;
        }
    table.style {
    font-family: verdana,arial,sans-serif;
    font-size:15px;
    color:#333333;
    border-width: 1px;
    border-color: #999999;
    border-collapse: collapse;
    width:600px;
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
<jsp:include page="AdminHeader.jsp" />
<jsp:include page="AdminIndex.jsp" />
<div class="box">
 <a href="AddDamage.jsp"><button>添加损坏记录</button></a>
<table class="style">
    <tr>
        <th>编号</th>
        <th>资产编号</th>
        <th>损坏情况</th>
        <th>处理方法</th>
        <th>编辑</th>
    </tr>
    <c:forEach var="damage" items = "${damages}" varStatus="Number">
    <tr>
        <td> ${damage.id}</td>
        <td> ${damage.pid}</td>
        <td> ${damage.level}</td>
        <td> ${damage.solution}</td>
        <td><a href="EditDamage?id=${damage.id}">修改</a><a href="DamageServlet?id=${damage.id}&tag=delete">删除</a></td>
        </c:forEach>
</table>
</div>
</body>
</html>
