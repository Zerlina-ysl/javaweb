<%--
  Created by IntelliJ IDEA.
  User: 25129
  Date: 2021/9/14
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>

    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="manager/orderServlet?action=queryMyOrders"}>我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
