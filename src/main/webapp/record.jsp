
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>查询消费记录</title>
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
    </script>
</head>
<body>
<style>
    div,ul, li {
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
        <li role="presentation" class="active"><a href="#" aria-controls="home" role="tab" data-toggle="tab">首页</a></li>
        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">停车查询</a></li>
        <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">费率设置</a></li>
        <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">月票设置</a></li>
        <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">入/出口</a></li>
        <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">统计</a></li>
    </ul>

</header>

<div class="row" style="text-align: center"><h3>用户信息列表</h3></div>
<div class="row">
    <form method="post" action="<%--${pageContext.servletContext.contextPath}/userlist?pageNum=1&rows=5--%>">

        <div class="col-lg-9">
            <div class="col-lg-3" >
                <div class="input-group">
                    <span class="input-group-addon" id="sizing-addon1">姓名</span>
                    <input type="text" class="form-control" placeholder="曹操" name="username"  aria-describedby="sizing-addon2">
                </div>
            </div>
            <div class="col-lg-3" >
                <div class="input-group">
                    <span class="input-group-addon" id="sizing-addon2">车牌</span>
                    <input type="text" class="form-control" placeholder="鄂A123456" name="carNumber" aria-describedby="sizing-addon2">
                </div>
            </div>
            <div class="col-lg-4" >
                <div class="input-group">
                    <span class="input-group-addon" id="sizing-addon3">电话</span>
                    <input type="text" class="form-control" placeholder=""  name="phoneNumber" aria-describedby="sizing-addon2">
                </div>
            </div>

            <div class="col-lg-1">
                <input class="btn btn btn-primary" type="submit" value="搜索">
            </div>


        </div>

    </form>

    <div class="col-lg-3">
        <div class="col-lg-2"></div>
        <div class="col-lg-10">
            <a class="btn btn-primary" href="${pageContext.servletContext.contextPath}/addRecord.jsp">添加消费记录</a>
            <a class="btn btn-primary" href="javascript:deleteSelected()">删除选中</a>
        </div>

    </div>

</div>

<form action="/UserServlet" method="post" id="myForm">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="checkAll"></th>
            <th>编号</th>
            <th>车牌</th>
            <th>进入时间</th>
            <th>离开时间</th>
            <th>是否结算</th>
            <th> 费用 </th>
            <th> </th>
        </tr>
        <c:forEach items="${records}" var="record">
            <tr>
                <td><input type="checkbox" name="uid" value="${record.id}"></td>
                <td>${record.id}</td>
                <td>${record.carNumber}</td>
                <td>${record.startime}</td>
                <td>${record.leavetime}</td>
                <td>${record.jiesuan}</td>
                <td>${record.cost} </td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.servletContext.contextPath}/FindRecordById?id=${record.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="${pageContext.servletContext.contextPath}/DeleteRecord?id=${record.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>

