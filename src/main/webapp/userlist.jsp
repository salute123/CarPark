<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/14
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主界面</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
            function f1(obj) {
                let elements = document.getElementsByName("selectId");
                for (let i = 0; i < elements.length; i++) {
                    elements[i].checked = obj.checked;

                }

            }


        function deleteSelected() {
            if (confirm("确定要删除这些数据吗？")) {
                var ids = document.getElementsByName("selectId");
                for (let i = 0; i < ids.length; i++) {
                    if (ids[i].checked) {
                        document.getElementById("myForm").submit();
                        return;
                    }
                }
            }
            alert("请先勾选");

        }

        function deleteUser(uid) {
            if (confirm("确定要删除这条数据吗？")) {
                window.location.href = "${pageContext.servletContext.contextPath}/DeleteUser?uid=" + uid;
            }


        }
    </script>
</head>
<body>
<style>
    div, ul, li {
        margin: 0px;
        padding: 0px;
    }

    .div {
        border: 1px solid #1594af;
        width: 600px;
        margin: auto;
        *text-align: center;
    }

    .div ul li {
        border: 1px solid #333333;
        background: #CCCCCC;
        color: #000000;
        text-align: center;
        margin-right: 5px;
        list-style: none;
    }

    ul {
        display: table;
        margin-left: auto;
        margin-right: auto;
    }

    ul li {
        float: left;
        *float: none;
        *display: inline;
        *zoom: 1;
    }
</style>
<header>
    <h2>停车管理系统</h2>

    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#" aria-controls="home" role="tab" data-toggle="tab">用户列表</a>
        </li>
        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">停车查询</a></li>
        <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">费率设置</a></li>
        <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">月票设置</a></li>
        <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">入/出口</a></li>
        <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">统计</a></li>
    </ul>

</header>

<div class="row" style="text-align: center"><h3>用户信息列表</h3></div>
<div class="row">


    <div class="col-lg-9">
        <form method="post" action="<%--${pageContext.servletContext.contextPath}/userlist?pageNum=1&rows=5--%>">
            <div class="col-lg-3">
                <div class="input-group">
                    <span class="input-group-addon" id="sizing-addon1">姓名</span>
                    <input type="text" class="form-control" placeholder="曹操" name="username"
                           aria-describedby="sizing-addon2">
                </div>
            </div>
            <div class="col-lg-3">
                <div class="input-group">
                    <span class="input-group-addon" id="sizing-addon2">车牌</span>
                    <input type="text" class="form-control" placeholder="鄂A123456" name="carNumber"
                           aria-describedby="sizing-addon2">
                </div>
            </div>
            <div class="col-lg-4">
                <div class="input-group">
                    <span class="input-group-addon" id="sizing-addon3">电话</span>
                    <input type="text" class="form-control" placeholder="" name="phoneNumber"
                           aria-describedby="sizing-addon2">
                </div>
            </div>

            <div class="col-lg-1">
                <input class="btn  btn-primary" type="submit" value="搜索">
            </div>
        </form>
    </div>

    <div class="col-lg-3">
        <div class="col-lg-2"></div>
        <div class="col-lg-10">
            <a class="btn btn-primary" href="${pageContext.servletContext.contextPath}/add.jsp">添加用户</a>
            <a class="btn btn-primary" href="javascript:deleteSelected()">删除选中</a>
        </div>
    </div>

</div>

<div style="margin-top: 15px">
    <form action="/deleteCheckUser" method="post" id="myForm">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="checkAll" onclick="f1(this)"></th>
                <th>编号</th>
                <th>姓别</th>
                <th>电话</th>
                <th>车牌</th>
                <th>姓名</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td><input type="checkbox" name="selectId" value="${user.uid}"></td>
                    <td>${user.uid}</td>
                    <td>${user.gender}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.carNumber}</td>
                    <td>${user.username}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.servletContext.contextPath}/FindUserById?uid=${user.uid}">修改</a>&nbsp;<a
                            class="btn btn-default btn-sm" href="javascript:deleteUser(${user.uid})">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
