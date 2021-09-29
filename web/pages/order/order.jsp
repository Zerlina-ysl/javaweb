<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@include file="../common/header.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
			<%@include file="../common/menu_success_login.jsp"%>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>

			<c:if test="${empty sessionScope.order}">

					<tr>

						<td colspan="4" ><a href="index.jsp">挑选点</a></td>

					</tr>

			</c:if>

			<c:if test="${ not empty sessionScope.order}">
				<c:forEach items="${sessionScope.order}" var="order">

			<tr>
				<td>${order.createDate}</td>
				<td>${order.price}</td>
				<c:if test="${order.status==0}">
				<td>未发货</td>
				</c:if>
				<c:if test="${order.status==1}">
					<td>已发货</td>
				</c:if>
				<c:if test="${order.status==2}">
					<td>已完成</td>
				</c:if>

				<td><a href="pages/manager/order_manager.jsp">查看详情</a></td>
			</tr>

			</c:forEach>

			</c:if>

		</table>
		
	
	</div>

	<%@include file="../common/footer.jsp" %>
</body>
</html>