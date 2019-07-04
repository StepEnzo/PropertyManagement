<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>企业资产管理系统</title>
<style type="text/css">
    .navigation{
            margin:1px;
            border-width:1px;
            border-right-color:#FFFFFF;
            border-right-style:solid;
            width:200px;
            height:800px;
            float:left;
            background-color:rgba(255,255,255,0.6);
        }
    .button2{
            background-color: Transparent;
            text-align:center;
            height:80px;
            width:200px;
            font-size:20px;
            border-right-width:0;
            border-bottom-width:1px;
            border-bottom-color:#E0FFFF;
        }
</style>
</head>
<body>
<div class="navigation">
    <a href="UserLookPropertyServlet">
        <button type="button" class="button2"  onmouseover="this.style.backgroundColor='#9DC45F';this.style.color='#FFFFFF';"
                onmouseout="this.style.backgroundColor='';this.style.color='#000000';">
            浏览所有资产
        </button>
    </a>

    <a href="UserRequisitionServlet">
        <button type="button" class="button2"  onmouseover="this.style.backgroundColor='#9DC45F';this.style.color='#FFFFFF';"
                onmouseout="this.style.backgroundColor='';this.style.color='#000000';">
            申请领用资产
        </button>
    </a>

    <a href="UserAppliedPropertyServlet">
        <button type="button" class="button2"  onmouseover="this.style.backgroundColor='#9DC45F';this.style.color='#FFFFFF';"
                onmouseout="this.style.backgroundColor='';this.style.color='#000000';">
            我的申请资产和使用资产
        </button>
    </a>

    <a href="UserHistoryRecordServlet">
        <button type="button" class="button2"  onmouseover="this.style.backgroundColor='#9DC45F';this.style.color='#FFFFFF';"
                onmouseout="this.style.backgroundColor='';this.style.color='#000000';">
            我的领用资产历史记录
        </button>
    </a>
</div>
</body>
</html>