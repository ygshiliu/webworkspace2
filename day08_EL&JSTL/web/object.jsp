<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<%--EL中的隐含对象:
1.pageContext
    类型：PageContext
    作用：与jsp中pageContext对象一样，可以获取其它对象
2.pageScope requestScope sessionScope applicationScope
    类型：map<String,Object>
    分别对应四个域，依次为：pageContext request session application
 3.param
    类型：map<String,String>
   paramValues
    类型：map<String,String[]>
    作用：获取请求参数中的值
  4.header
    类型：map<String,String>
    headerValues
    类型：map<String,String[]>
    作用：获取请求头中的值

  5.cookie
    类型：map<String,cookie>
    作用：获取cookie

  6.initParam
    类型：map<String,String>
--%>

${pageContext} <br>
<%--与4个域对象对应的对象--%>
<%--
${pageScope} <br>
${requestScope} <br>
${sessionScope} <br>
${applicationScope} <br>
--%>

<hr>
<%--可以获取请求参数--%>
${param} <br>
paramValues:${paramValues} <br>
paramValues.age:${paramValues.age[1]} <br>

<hr>
<%--获取请求头--%>
${header} <br>
${headerValues} <br>

<hr>
<%--cookie--%>
${cookie} <br>
${cookie.JSESSIONID} <br>

<hr>
<%--获取jsp初始化参数--%>
${initParam}

</body>
</html>
