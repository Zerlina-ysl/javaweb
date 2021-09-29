<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/header.jsp"%>
<script>
	$(function(){
		$("button#join").click(function(){
			//实质是把 book 中的内容 存储到 session域中的items
			var id = $(this).attr("book_id");
			location.href="http://localhost:8080/bookStoreItem_war_exploded/manager/cartServlet?action=addItem&id="+id;
		// $.getJSON("http://localhost:8080/bookStoreItem_war_exploded/manager/cartServlet","action=addItem&id="+id,function(data){
		// 			$("#cartTotalCount").text("您的购物车中有"+data.totalCount+"件商品");
		// 				$("#cartLastName").text(data.lastName);ajax
		});


		});
	});
</script>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<c:if test="${ empty sessionScope.user}">
					<a href="pages/user/login.jsp">登录</a> |
					<a href="pages/user/regist.jsp">注册</a>
				</c:if>
				<c:if test="${not empty sessionScope.user}">

					欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城
					<a href="manager/orderServlet?action=queryMyOrders">我的订单</a>
				<a href="userServlet?action=logout">注销</a>

					</c:if>
				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>

	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="manager/clientBookServlet" method="get">
					<input type="hidden" value="indexByPrice" name="action">
					价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
						<input id="max" type="text" name="max" value="${param.max}"> 元
						<input type="submit" value="查询"/>
				</form>
			</div>
			<c:if test="${not empty sessionScope.cart.items}">

			<div style="text-align: center">
				<span id="cartTotalCount">${sessionScope.cart.totalCount}</span>
				<div>
					您刚刚将<span style="color: red" id="cartLastName">${sessionScope.lastName}</span>加入到了购物车中
				</div>
			</div>
			</c:if>

			<c:if  test="${empty sessionScope.cart.items}">
				<div style="text-align: center">
				<span style="color: red">您的购物车为空</span>

				</div>
			</c:if>

			<c:forEach items="${requestScope.page.items}" var="book" >
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${book.imgpath}" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button id="join" book_id="${book.id}">加入购物车</button>
					</div>
				</div>
			</div>
			</c:forEach>

		</div>
		<%@include file="/pages/common/page.jsp"%>
	</div>

	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>

</body>
</html>