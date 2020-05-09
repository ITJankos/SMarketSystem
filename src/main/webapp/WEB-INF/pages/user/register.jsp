<%--
  Created by IntelliJ IDEA.
  User: 远远
  Date: 2020/4/23
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
    <style>
        label{
            width: 25%;
            display: inline-block;
        }
    </style>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>超市订单管理系统</h1>
    </header>
    <section class="loginCont">
        <form enctype="multipart/form-data" style="width: 20%;display: inline-block; width: 320px;height: 400px;" action="${pageContext.request.contextPath }/user/register"  name="actionForm" id="actionForm"  method="post" >
            <div class="info">${loginError}</div>
            <div class="inputbox">
                <label for="user">用户编码：</label>
                <input type="text" class="input-text" id="userCode" name="userCode" placeholder="请输入编码" required/>
            </div>
            <div class="inputbox">
                <label for="mima">用户名：</label>
                <input type="text" id="userName" name="userName" placeholder="请输入用户名" required/>
                <font color="red"></font>
            </div>
            <div class="inputbox">
                <label for="mima">密码：</label>
                <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
                <font color="red"></font>
            </div>
            <div class="inputbox">
                <label for="mima">性别：</label>
                <select name="gender" id="gender" style="width: 210px;height: 30px">
                    <option value="1" selected="selected">男</option>
                    <option value="2">女</option>
                </select>
            </div>
            <div class="inputbox">
                <label for="phone">用户头像：</label>
                <input type="file" name="imgFile" value=""/>
                <font color="red"></font>
            </div>
            <div class="inputbox">
                <label for="phone">用户电话：</label>
                <input type="text" name="phone" id="phone" value="" placeholder='请输入电话号码'>
                <font color="red"></font>
            </div>
            <div class="inputbox">
                <label for="address">用户地址：</label>
                <input name="address" id="address"  value="" placeholder='请输入地址'>
            </div>
            <div class="subBtn">
                <input type="submit" value="注册"/>
                <input type="reset" value="重置"/>
            </div>
        </form>
    </section>
</section>
</body>
</html>
