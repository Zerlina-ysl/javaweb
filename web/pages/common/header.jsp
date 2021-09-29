<%--
  Created by IntelliJ IDEA.
  User: 25129
  Date: 2021/9/14
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<base href="http://localhost:8080/bookStoreItem_war_exploded/">ip地址需动态获取--%>
<% String basePath = request.getScheme()
        + "://"
        + request.getServerName()
        + ":"
        + request.getServerPort()
//        + "/"     getContextPath()自带前斜杠
        + request.getContextPath()
        + "/";
request.setAttribute("path",basePath);
%>
<base href="<%= basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript"   src="script/jquery-1.7.2.min.js"></script>