<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<%--
jsp:include 通过方法调用向当前jsp页面引入页面;
若引入的是jsp页面，jsp页面会单独进行翻译后通过方法调用引入，而include指令则不会翻译引入的jsp页面

jsp:forward 转发
转发相对项目的根目录
jsp:param 可以用来指定请求参数，name指定键，value指定值
注意：jsp forward如果没有请求参数的话，开始标签与结束标签之间是不能有空格的

--%>
<jsp:include page="one.html"></jsp:include>
<jsp:include page="index.jsp"></jsp:include>

<%--转发--%>
<%--<jsp:forward page="/second.jsp">
    <jsp:param name="username" value="lala"></jsp:param>
</jsp:forward>--%>

<jsp:forward page="/index.jsp"></jsp:forward>
</body>
</html>
