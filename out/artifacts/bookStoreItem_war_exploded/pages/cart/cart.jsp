<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="../common/header.jsp"%>
	<script type="text/javascript">
		$(function(){
			$("tr #delete").click(function(){
				confirm("是否要删除["+$(this).parent().parent().find("td:first").text()+"]吗？");
			});
			$("span #clear").click(function(){
				confirm("是否要清空购物车？");
			});
			$(".update").change(function(){
				var newvalue = this.value;
				var name = $(this).parent().parent().find("td:first").text();

				if(confirm("你确定要修改["+name+"]的数量为"+newvalue+"吗？")){
					location.href = "${basePath}manager/cartServlet?action=updateItem&id="+id+"&value="+newvalue;
				}else{
						this.value = this.defaultValue;
				}

			});

		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@include file="../common/menu_success_login.jsp" %>
	</div>
	
	<div id="main">
	
			<c:if test="${not empty sessionScope.cart}">
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

			<c:forEach items="${sessionScope.cart.items}" var="entry">
			<tr>
				<td>${entry.value.name}</td>
				<td><input value="${entry.value.count}" style="width:40px;text-align: center" class="update" bookid="${entry.value.id}"></td>
				<td>${entry.value.singleprice}</td>
				<td>${entry.value.totalPrice}</td>
				<td><a href="manager/cartServlet?action=deleteItem&id=${entry.value.id}" id="delete">删除</a></td>
			</tr>
			</c:forEach>
		</table>
			</c:if>
			<c:if test="${empty sessionScope.cart.items}">
				<table>
				<tr>
					<td></td>
					<td></td>
					<td colspan="5" ><a href="index.jsp">挑选点</a></td>
					<td></td>
					<td></td>
				</tr>
				</table>
			</c:if>



		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a href="manager/cartServlet?action=clearItem" id="clear">清空购物车</a></span>
			<span class="cart_span"><a href="manager/orderServlet?action=createOrder">去结账</a></span>
		</div>



	</div>

	<%@include file="../common/footer.jsp" %>
</body>
</html>