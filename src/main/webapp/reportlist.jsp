<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>日报表</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>

        window.onload=function () {
            document.getElementById("checkAll").onclick=function (){
                let elements = document.getElementsByName("uid");
                for (let i=0; i<elements.length;i++) {
                    elements[i].checked=this.checked;
                }

            }
        }
        function deleteSelected() {
            if (confirm("确定要删除这些数据吗？"))
            { var ids = document.getElementsByName("uid");
                for (let i=0; i<ids.length;i++) {
                    if(ids[i].checked){
                        document.getElementById("myForm").submit();
                        return;
                    }
                }
            }
            alert("请先勾选");

        }
    </script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container">

    <div class="row" style="text-align: center"><h3>日报表</h3></div>

    <header class="row">
        <form method="post" action="${pageContext.servletContext.contextPath}/reportList?pageNum=1&rows=5">
            <div class="col-lg-8">
                <div class="col-lg-4" >
                </div>
                <div class="col-lg-4" >
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon2">停车日期</span>
                        <input type="text" class="form-control" placeholder="2020-12-12" name="date" aria-describedby="sizing-addon2">
                    </div>
                </div>

                <div class="col-lg-1"></div>
                <div class="col-lg-1">
                    <input class="btn btn btn-primary" type="submit" value="搜索">
                </div>
            </div>
        </form>

        <div class="col-lg-3">
            <div class="col-lg-4">
            </div>

            <div class="col-lg-4">
                <a class="btn btn-primary" href="${pageContext.servletContext.contextPath}/updateReport">更新</a>
            </div>

            <div class="col-lg-4">
                <a class="btn btn-primary" href="javascript:deleteSelected()">删除选中</a>
            </div>
        </div>
    </header>


    <div style="margin-top: 15px">
        <form action="${pageContext.servletContext.contextPath}/deleteCheckReport" method="post" id="myForm">
            <table border="1" class="table table-bordered table-hover">

                <tr class="success">
                    <th><input type="checkbox" id="checkAll" onclick="f1()"></th>
                    <th>停车日期</th>
                    <th>收入</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="user">
                    <tr>
                        <th><input type="checkbox" name="uid" value="${user.id}"></th>
                        <td>${user.date}</td>
                        <td>${user.income}</td>
                        <td><a class="btn btn-default btn-sm" href="${pageContext.servletContext.contextPath}/deleteReport?id=${user.id}">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>

    <footer class="row">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pageInfo.pageNum !=1}">
                    <li>
                        <a href="${pageContext.servletContext.contextPath}/reportList?pageNum=${pageInfo.pageNum-1}&rows=5&username=${a}&address=${b}&email=${c}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${pageInfo.totalPage}" var="i" >
                    <c:if test="${pageInfo.pageNum == i}">
                        <li class="active"><a href="${pageContext.servletContext.contextPath}/reportList?pageNum=${i}&rows=5&username=${a}&address=${b}&email=${c}">${i}</a></li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum != i}">
                        <li><a href="${pageContext.servletContext.contextPath}/reportList?pageNum=${i}&rows=5&username=${a}&address=${b}&email=${c}">${i}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${pageInfo.pageNum != pageInfo.totalPage}">
                    <li>
                        <a href="${pageContext.servletContext.contextPath}/reportList?pageNum=${pageInfo.pageNum+1}&rows=5&username=${a}&address=${b}&email=${c}"  aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <span style="font-size: 28px;margin-left: 10px">共${pageInfo.totalCount}条记录,共${pageInfo.totalPage}页</span>
            </ul>
        </nav>
    </footer>
</div>