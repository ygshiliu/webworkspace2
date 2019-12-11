<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>函数标签库</h1>
<%
    request.setAttribute("str"," hell oend ");
%>
endsWith:${fn:endsWith(str,"end")}<br>
substring:${fn:substring(str, 5, 8)}<br>
contains:${fn:contains(str,"end" ) }<br>
length:${fn:length(str)}<br>
startsWith:${fn:startsWith(str, "he")}<br>
trim:${fn:trim(str)}<br>
</body>
</html>
