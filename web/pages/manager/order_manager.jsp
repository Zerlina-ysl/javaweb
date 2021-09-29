<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%@include file="../common/header.jsp"%>
</head>
<script type="text/javascript">
	$(function(){
		$("td #send").click(function(){
			var status = $(this).attr("status");
			var orderId = $(this).attr("orderid");
			if(status==0){
				alert("发货成功");
			}if(status==1){
				alert("该商品已发货");
				$(this).value="点击完成该订单";
			}
		location.href="http://localhost:8080/bookStoreItem_war_exploded/manager/orderServlet?action=sendOrder&orderId="+ordeId ;
		});
	});
</script>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
		<%@include file="../common/manager.jsp"%>
	</div>
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
			</tr>

			<c:if test="${ not empty sessionScope.order}">
				<c:forEach items="${sessionScope.order}" var="order">
			<tr>
				<td>${order.createDate}</td>
				<td>${order.price}</td>
				<td><a href="pages/manager/order_manager.jsp">查看详情</a></td>
				<td><a  status="${order.status}" id="send" orderid="${order.orderId}">点击发货</a></td>
			</tr>
				</c:forEach>
			</c:if>
					<c:if test="${empty sessionScope.order}">
				<tr>
					<td colspan="4" ><a href="index.jsp" >挑选点</a></td>
				</tr>
			</c:if>







		</table>
	</div>

	<%@include file="../common/footer.jsp" %>
</body>
</html>