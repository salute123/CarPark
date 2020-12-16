<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/14
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>月票查询</title>
</head>
<style type="text/css">
    td, th {
        text-align: center;
    }
</style>
<body >
<div class="container">
<div class="row" style="margin-bottom: 15px">
    <div class="col-md-8">
        <form action="" class="form-inline" action="${pageContext.servletContext.contextPath}/tquery" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="username" value="${condition.username[0]}" class="form-control" id= "exampleInputName2" placeholder=" name">
            </div>
            <div class="form-group">
                <label for="exampleInputName1">uid</label>
                <input type="text" name="uid" value="${condition.uid[0]}" class="form-control" id="exampleInputName1" placeholder="uid">
            </div>

            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div class="col-md-4">
        <div class="col-md-6">
            <a class="btn btn-primary" href="${pageContext.servletContext.contextPath}/addTicket.jsp">添加月票</a>
        </div>
        <div class="col-md-6">
            <a class="btn btn-primary" href="javascript:deleteSelected()" >删除选中</a>
        </div>
    </div>
</div>
    <script>
        window.onload = function() {
            //全选
            document.getElementById("checkAll").onclick = function () {
                let elements = document.getElementsByName("yid");
                for (let i = 0; i < elements.length; i++) {
                    elements[i].checked = this.checked;
                }
            }
        }
        //选中删除
        function deleteSelected() {
            if(confirm("确定要删除这些数据吗？")){
                // 检查一下有没有被勾选的复选框
                var ids = document.getElementsByName("yid");
                for (let i = 0; i <ids.length ; i++) {
                    if(ids[i].checked){
                        document.getElementById("myForm").submit();
                        return;
                    }
                }
                alert("请先勾选！")
            }
        }
    </script>
<div>
<form action="${pageContext.servletContext.contextPath}/tquery" method="post" id="myForm">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="checkAll"></th>
            <th>yid</th>
            <th>uid</th>
            <th>姓名</th>
            <th>车牌</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>消费</th>
            <th>是否有效</th>
        </tr>
        <c:forEach items="${ticket}" var="ticket">
            <tr>

                <td><input type="checkbox" id="check"></td>
                <td>${ticket.yid}</td>
                <td>${ticket.uid}</td>
                <td>${ticket.username}</td>
                <td>${ticket.carNumber}</td>
                <td>${ticket.ktime}</td>
                <td>${ticket.jtime}</td>
                <td>${ticket.cost}</td>
                <td>${ticket.online}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.servletContext.contextPath}/findoneticket?id=${ticket.yid}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:delticket(${ticket.yid})">删除</a></td>

            </tr>
        </c:forEach>

    </table>
</form>
</div>
</div>
</body>
</html>
