<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@include file="../common/header.jsp"%>
	<script type="text/javascript">

		$(function(){
			$("a.delete").click(function(){
					//返回true 点击确认，返回false 点击取消
				return confirm("确认要删除"+$(this).parent().parent().find("td:first").text()+"吗？");

			});
			$("input.confirm").click(function(){
			    var obj = $("#pn_input").val();
			    if(obj>${requestScope.page.pageTotal}||obj<1){
			        alert("跳转的页码数不合法！");
                }
                location.href ="${requestScope.path}manager/bookServlet?action=page&pageNo="+obj;//wpcap

            });

		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>

		<%@include file="../common/manager.jsp"%>
	</div>
	
	<div id="main">

		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.items}"  var="books">
				<tr>
					<td>${books.name}</td>
					<td>${books.price}</td>
					<td>${books.author}</td>
					<td>${books.sales}</td>
					<td>${books.stock}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${books.id}&method=update&pageNo=${requestScope.page.pageTo}">修改</a></td>
					<td><a href="manager/bookServlet?action=delete&id=${books.id}&pageNo=${requestScope.page.pageTo}" class="delete">删除</a></td>
				</tr>
			</c:forEach>


			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?method=add&pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>
		</table>

		<%@include file="/pages/common/page.jsp"%>
	</div>

	<%@include file="../common/footer.jsp" %>
</body>
</html>