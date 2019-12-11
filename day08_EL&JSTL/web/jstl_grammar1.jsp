<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
prefix:前缀
uri:标签库的唯一标识
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>jstl</title>
</head>
<body>
<h1>jstl_grammer</h1>
<%--向域中设置属性
    var：指定属性名;
    value:指定属性值;
    scope:指定域。 默认放在pageContext域中
--%>
<c:set var="username" value="wangwu" scope="request" ></c:set>

<%--从域中取出属性并显示在页面中
    value:指定域中的属性名
    default:用来设置默认值，如果没有获取到值，则使用默认值
    escapeXml：是否解析
--%>
<c:out value="username" default="xx" escapeXml="true"></c:out>
<br>
<br>
${applicationScope.username}

<%--
    从域中删除属性
    var指明要删除的属性名
    scope 指定域
--%>
<c:remove var="username" scope="request"></c:remove>

</body>
</html>
