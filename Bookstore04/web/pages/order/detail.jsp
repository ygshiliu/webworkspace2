<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <%@include file="/WEB-INF/include/head.jsp"%>
<title>订单详情页</title>
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">订单详情页</span>
        <%@include file="/WEB-INF/include/menu.jsp"%>
	</div>

	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>金额</td>
				<td>单价</td>
				
			</tr>		
			<tr>
				<td>时间简史</td>
				<td>2</td>
				<td>60.00</td>
				<td>30.00</td>
			</tr>	
			
			<tr>
				<td>母猪的产后护理</td>
				<td>1</td>
				<td>10.00</td>
				<td>10.00</td>
			</tr>	
			
			<tr>
				<td>百年孤独</td>
				<td>1</td>
				<td>20.00</td>
				<td>20.00</td>
			</tr>		
			
		</table>
		
	
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2018 </span>
	</div>
</body>
</html>