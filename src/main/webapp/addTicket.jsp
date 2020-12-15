<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/15 0015
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加月票</title>
</head>
<body>
<div  class="container" >
    <h3>添加月票</h3>
    <form action="${pageContext.servletContext.contextPath}/tadd" method="post">
        <div class="form-group">
            <label for="uid">uid</label>
            <input type="text" class="form-control" id="uid" name="uid" placeholder="uid">
        </div>
        <div class="form-group">
        <label for="username">姓名：</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="请输入姓名">
    </div>
        <div class="form-group">
            <label for="carNumber">车牌</label>
            <input type="text" class="form-control" id="carNumber" name="carNumber" placeholder="车牌">
        </div>

        <div class="form-group">
            <label for="ktime">开始时间</label>
            <input type="date" class="form-control" id="ktime" name="ktime" placeholder="开始时间"/>
        </div>

        <div class="form-group">
            <label for="jtime">结束时间</label>
            <input type="date" class="form-control" id="jtime" name="jtime" placeholder="结束时间"/>
        </div>

        <div>
            <label for="cost">费用</label>
            <input type="text" class="form-control" id="cost" name="cost" placeholder="费用"/>
        </div>

        <div class="form-group" style="align-content: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" onclick="javascript:history.back(-1)" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>
