<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
    <%@include file="/WEB-INF/include/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
            <%@include file="/WEB-INF/include/manager.jsp"%>
		</div>
		
		<div id="main">
  <%--          <c:if test="${empty book.title}">
                <form action="ManagerServlet?method=savebook" method="post">
            </c:if>
            <c:if test="${!empty book.title}">
                <form action="ManagerServlet?method=updatebook" method="post">

                    <input name="id" type="hidden" value="${book.id}"/>
            </c:if>--%>

            <form action="ManagerServlet?method=saveorupdate" method="post">
                <c:if test="${!empty book.title}">
                    <input name="id" type="hidden" value="${book.id}"/>
                </c:if>

				<table>
					<tr>
						<td>名称</td>
                        <td>作者</td>
                        <td>价格</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>

					<tr>
						<td><input name="title" type="text" value="${book.title}"/></td>
                        <td><input name="author" type="text" value="${book.author}"/></td>
                        <td><input name="price" type="text" value="${book.price}"/></td>
						<td><input name="sales" type="text" value="${book.sales}"/></td>
						<td><input name="stock" type="text" value="${book.stock}"/></td>
						<td><input  type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>

            <div style="text-align: center;color: red">${msg}</div>
	
		</div>
		
		<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>