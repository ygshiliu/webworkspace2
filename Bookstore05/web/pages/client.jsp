<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@include file="/WEB-INF/include/head.jsp"%>
 <script>
     $(function(){
         $("button:first").click(function(){
             var minprice = $("[name=min]").val();
             var maxprice = $("[name=max]").val();
             location="ClientServlet?method=getpagebyprice&pageNo=1&minprice="+minprice+"&maxprice="+maxprice;
         })

         $(".book_add").click(function () {
             var id = this.id;
             location = "CartServlet?method=addBook&bookid="+id;
         })
     })
 </script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<%@include file="/WEB-INF/include/menu.jsp"%>
	</div>
	
	<div id="main">
		<div id="book">
			<div class="book_cond">
				价格：<input type="text" name="min" value="${min}"> 元 - <input type="text" name="max" value="${max}"> 元 <button>查询</button>
			</div>
            <c:choose>
                <c:when test="${empty cart.cartItems}">
                    <div style="text-align: center">
                        <span>您还没有购物，快去选购吧！！</span>
                    </div>
                </c:when>
                <c:otherwise>
                    <div style="text-align: center">
                        <span>您的购物车中有${cart.totalCount}件商品</span>
                        <div>
                            您刚刚将<span style="color: red">${sessionScope.title}</span>加入到了购物车中
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>


            <c:forEach items="${page.list}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${book.imgPath}" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.title}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add" id="${book.id}">
						<button>加入购物车</button>
					</div>
				</div>
			</div>
            </c:forEach>

		</div>
		
	<%@include file="/WEB-INF/include/page.jsp"%>
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>