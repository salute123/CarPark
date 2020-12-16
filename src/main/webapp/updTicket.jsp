<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/16 0016
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 指定字符集 -->
<meta charset="utf-8">
<!-- 使用Edge最新的浏览器的渲染方式 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
width: 默认宽度与设备的宽度相同
initial-scale: 初始的缩放比，为1:1 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<!-- 1. 导入CSS的全局样式 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- 2. jQuery导入，建议使用1.9以上的版本 -->
<script src="js/jquery-2.1.0.min.js"></script>
<!-- 3. 导入bootstrap的js文件 -->
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap-datetimepicker.min.css" rel="external nofollow" rel="stylesheet" />
<script src="js/bootstrap-datetimepicker.js"></script>
<script src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<html>
<head>
    <title>修改月票信息</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/tupdate" method="post" class="container">
    <div class="form-group">
        <label for="yid">yid</label>
        <input type="text" class="form-control" id="yid" value="${tic.yid}" name="yid"  readonly>
    </div>
    <div class="form-group">
        <label for="uid">uid</label>
        <input type="text" class="form-control" id="uid" value="${tic.uid}" name="uid" readonly>
    </div>
    <div class="form-group">
        <label for="username">姓名：</label>
        <input type="text" class="form-control" id="username" value="${tic.username}"name="username" readonly>
    </div>
    <div class="form-group">
        <label for="carNumber">车牌</label>
        <input type="text" class="form-control" id="carNumber" value="${tic.carNumber}"name="carNumber" readonly>
    </div>

    <div class="form-group row">
        <div class="time">
            <div class="input-group">
                <input type="text" class="form-control form_datetime" id="ktime"value="${tic.ktime}" name="ktime"  placeholder="开始时间">
                <span class="input-group-addon" id="Span2"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
                <input type="text" class="form-control form_datetime" id="jtime"value="${tic.jtime}" name="jtime"  placeholder="结束时间">
                <span class="input-group-addon" id="Span1"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
            </div>
        </div>
    </div>
    <script>
        $('.form_datetime').datetimepicker({
            format: 'yyyy-mm-dd hh:ii:ss',
            autoclose: true,
            /* minView: "month",  *///选择日期后，不会再跳转去选择时分秒
            language: 'zh-CN',
            dateFormat: 'yyyy-mm-dd',//日期显示格式
            timeFormat: 'HH:mm:ss',//时间显示格式
            todayBtn: 1,
            autoclose: 1,
            minView: 0,  //0表示可以选择小时、分钟   1只可以选择小时
            minuteStep: 5,//分钟间隔1分钟
        });
    </script>

    <div>
        <label for="cost">费用</label>
        <input type="text" class="form-control" id="cost"value="${tic.cost}" name="cost" placeholder="费用"/>
    </div>

    <div class="form-group" style="align-content: center">
        <input class="btn btn-primary" type="submit" value="提交"/>
        <input class="btn btn-default" type="reset" value="重置"/>
        <input class="btn btn-default" type="button" onclick="javascript:history.back(-1)" value="返回"/>
    </div>
</form>
</body>
</html>
