<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
    <%@include file="/WEB-INF/include/head.jsp"%>
 <script >

     $(function () {
         $(".count").change(function () {
             var bookid = this.id;
             var count = this.value;
             location = "CartServlet?method=updateBookCount&bookid=" + bookid + "&count=" + count;
         });

     })
 </script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
        <%@include file="/WEB-INF/include/menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>金额</td>
				<td>单价</td>				
				<td>操作</td>
			</tr>
            <c:forEach items="${cart.cartItems}" var="item">
			<tr>
				<td>${item.book.title}</td>
				<td><input value="${item.count}" class="count" id="${item.book.id}" style="width:20px;text-align: center"></td>
				<td>${item.amount}</td>
				<td>${item.book.price}</td>
				<td><a href="CartServlet?method=deleteBook&bookid=${item.book.id}">删除</a></td>
			</tr>
            </c:forEach>
			
		</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${cart.totalAmount}</span>元</span>
			<span class="cart_span"><a href="CartServlet?method=clearCart">清空购物车</a></span>
			<span class="cart_span"><a href="checkout.html">去结账</a></span>
		</div>
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>