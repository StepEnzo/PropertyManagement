<%--
  Created by IntelliJ IDEA.
  User: 盈凯
  Date: 2019/7/3
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ page isELIgnored="false" %>--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User-Login</title>
    <script type="text/javascript">
        function checkForm(){
            var id1=document.getElementById("1").value;
            if (id1==null||id1==''){
                alert("用户名不能为空！");
                return false;
            }
            var id2=document.getElementById("2").value;
            if (id2==null||id2==''){
                alert("账号不能为空！");
                return false;
            }
            var id3=document.getElementById("3").value;
            if (id3==null||id3==''){
                alert("密码不能为空！");
                return false;
            }
            var id4=document.getElementById("4").value;
            var pattern=/^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
            if (id4==null||id4==''){
                alert("邮箱不能为空！");
                return false;
            }else if(pattern.test(id4)){
                return true;
            }else{
                alert("请输入正确的邮箱！");
                return false;
            }
        }
    </script>
    <script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
    <script type="text/javascript" src="js/language.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
</head>
<style>
    .box{
        padding:40px;
        width:60%;
        margin-left:25%;
        font-size:30px;
    }
    form.style {
        max-width: 500px;
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
    form.style label {
        font-size:15px;
        margin: 0px 0px 5px;
    }
    form.style input[type="text"], .smart-green input[type="email"],  input[type="password"], .smart-green select {
        color: #555;
        height: 30px;
        line-height:15px;
        width: 100%;
        padding: 0px 0px 0px 10px;
        margin-top: 10px;
        border: 1px solid #E5E5E5;
        background: #FBFBFB;
        outline: 0;
        -webkit-box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
        box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
        font: normal 14px/14px Arial, Helvetica, sans-serif;
    }
    form.style select {
        appearance:none;
        -webkit-appearance:none;
        -moz-appearance: none;
        text-indent: 0.01px;
        text-overflow: '';
        margin-top: 10px;
        width:100%;
        height:30px;
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
        background: #dcddc0;
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #999999;
    }
</style>
<body>
<div class="box">
    <form id="form" class="style" action="register" method="post" >
        <h1>登录<span>用户</span></h1>
        <table>
            <tr>
            <td><label>用户名</label></td>
            <td width="350px"><input id="1" name="username"  value="" type="text" placeholder="username"></td>
            </tr>
            <tr>
                <td><label>账号</label></td>
                <td width="350px"><input id="2" name="account"   value="" type="text" placeholder="account"></td>
            </tr>
            <tr>
                <td><label>密码</label></td>
                <td width="350px"><input id="3" name="password"  value="" type="password" placeholder="password"></td>
            </tr>
            <tr>
                <td><label>邮箱</label></td>
                <td style="width:349px"><input  id="4" name="email"  value="" type="text" placeholder="email"></td>
            </tr>


        </table>
        <input class="button" type="submit" value="注册"onclick="return checkForm()">
    </form>
</div>
</body>
</html>