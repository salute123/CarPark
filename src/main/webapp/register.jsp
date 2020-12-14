
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<script>

</script>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">用户注册</h3>
    <form action="${pageContext.servletContext.contextPath}" method="post">
        <div class="form-group">
            <label for="username">姓名：</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入姓名"/>
        </div>
        <div class="form-group">
            <label>密码：</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
        </div>
      <div class="form-group">
          <label for="carNumber">车牌号：</label>
          <input type="text" class="form-control" id="carNumber" name="carNumber" placeholder="请输入车牌号"/>
      </div>
        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" onclick="history.back()" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>