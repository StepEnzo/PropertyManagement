<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
<%@ taglib uri="MyFirstTag" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>企业资产管理系统</title>
<style type="text/css">
        .headerbox{
            width:100%;
            height:60px;
            background-color:rgba(157,196,95,0.9);
        }
        .welcome{
            padding:2px 50px;
            height:58px;
            display:inline;
            font-size:20px;
        }
        .head{
            padding-top:2px;
            padding-left:300px;
            font-size:36px;
            height:58px;
            display:inline;
        }
        .logout{
            width:250px;
            padding-top:2px;
            height:58px;
            float:right;
            display:inline;
        }
        .button1{
            background-color: Transparent;
            border-style :none;
            text-align:center;
            width:250px;
            height:58px;
            font-size:25px;
        }
    </style>
</head>
<body>
<div class="headerbox">
    <div class="welcome">欢迎回来，<mytag:account /></div>
    <div class="head">用户资产管理系统</div>  
    <div class="logout">
        <a href="login.jsp">
            <button type="button" class="button1"  onmouseover="this.style.backgroundColor='#80A24A';this.style.color='#FFFFFF';"
                 onmouseout="this.style.backgroundColor='';this.style.color='#000000';">
                退出登录
            </button>
        </a>
    </div>
</div>
</body>
</html>