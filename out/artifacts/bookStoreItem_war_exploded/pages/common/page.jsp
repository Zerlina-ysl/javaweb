<%--
  Created by IntelliJ IDEA.
  User: 25129
  Date: 2021/9/17
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page_nav">

    <c:if test="${requestScope.page.pageTo>1}">

        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTo-1}">上一页</a>
    </c:if>


    <%--			设置页码的布局--%>
    <c:choose >
        <%--			页码<5--%>
        <c:when test="${requestScope.page.pageTotal<=5}" >

            <c:set var="begin" value="1" ></c:set>
            <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>

        </c:when>
        <%--			页码>5 --%>
        <c:when test="${requestScope.page.pageTotal>5}">
            <%--									当前页码》total-4--%>
            <c:choose>
                <c:when  test="${requestScope.page.pageTo>requestScope.page.pageTotal-4}">

                    <c:set var="begin" value="${requestScope.page.pageTotal-3}" ></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
                </c:when>
                <%--										页码《5--%>
                <c:when  test="${requestScope.page.pageTo<5}">

                    <c:set var="begin" value="1" ></c:set>
                    <c:set var="end" value="5"></c:set>
                </c:when>
                <%--									当前页码在中间位置--%>
                <c:otherwise>

                    <c:set var="begin" value="${requestScope.page.pageTo-2}" ></c:set>
                    <c:set var="end" value="${requestScope.page.pageTo+2}"></c:set>
                </c:otherwise>

            </c:choose>

        </c:when>
    </c:choose>
    <c:forEach var="i" begin="${begin}" end="${end}">
        <c:if test="${requestScope.page.pageTo==i}">
            <a>【${i}】</a>
        </c:if>
        <c:if test="${requestScope.page.pageTo!=i}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>

        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageTo < requestScope.page.pageTotal}">

        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>

    </c:if>
    共${requestScope.page.pageTotalCount}条记录，${requestScope.page.pageTotal}页
    到第<input value="${param.pageNo}" name="pn" id="pn_input" >页
    <input type="button" value="确认" class="confirm">
</div>