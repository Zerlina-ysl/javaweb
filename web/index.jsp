<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/header.jsp"%>
<jsp:forward page="manager/clientBookServlet?action=page"></jsp:forward>
<%--默认页面负责请求转发--%>