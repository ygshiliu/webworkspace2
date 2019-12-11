<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/include/head.jsp"%>
<title>图书管理</title>
<script>
    $(function () {
        $(".delA").click(function(){
            var title = $(this).parents("tr").find("td:first").text();
            var b = confirm("您确定要删除< "+title+" >图书吗?");
            if(!b){
                return false;
            }
        })
    })
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
        <%@include file="/WEB-INF/include/manager.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
                <td>作者</td>
                <td>价格</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
            <c:forEach items="${page.list}" var="book">
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>${book.sales}</td>
				<td>${book.stock}</td>
				<td><a href="ManagerServlet?method=getbookbyid&bookId=${book.id}">修改</a></td>
				<td><a class="delA" href="ManagerServlet?method=deletebook&bookId=${book.id}">删除</a></td>
			</tr>
            </c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>

        <%@include file="/WEB-INF/include/page.jsp"%>

<%--        <div class="scott">
            <c:choose>
                <c:when test="${page.totalPage<=5}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="${page.totalPage}"></c:set>
                </c:when>
                <c:when test="${page.pageNo<=3}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${page.pageNo-2}"></c:set>
                    <c:set var="end" value="${page.pageNo+2}"></c:set>
                    <c:if test="${end >= page.totalPage}">
                        <c:set var="begin" value="${page.totalPage-4}"></c:set>
                        <c:set var="end" value="${page.totalPage}"></c:set>
                    </c:if>
                </c:otherwise>
            </c:choose>
            <a href="ManagerServlet?method=getpage&pageNo=${page.pageNo-1}"> &lt; </a>
            <c:forEach begin="${begin}" end="${end}" var="index">
                <c:choose>
                    <c:when test="${page.pageNo==index}">
                        <span class="current">${index}</span>
                    </c:when>
                    <c:otherwise>
                        <a href="ManagerServlet?method=getpage&pageNo=${index}">${index}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <a href="ManagerServlet?method=getpage&pageNo=${page.pageNo+1}"> &gt; </a>
            共${page.totalPage}页，${page.totalRecord}条记录 到第<input value="${page.pageNo}" name="pn" id="pn_input" />页
                                    <input id="sendBtn" type="button" value="确定">

            <script>

                $("#sendBtn").click(function(){
                    var pageNo = $("#pn_input").val();
                    location.href = "ManagerServlet?method=getpage&pageNo="+pageNo;
                })

            </script>
        </div>--%>


	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>