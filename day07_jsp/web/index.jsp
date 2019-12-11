<%@ page import="java.sql.SQLOutput" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>$Title$</title>
</head>
<body>
	  <h1>首页</h1>
      <hr>
<div>这是我们的第一个jsp页面，helloworld!!</div>

<%--java代码--%>
<%
    String username = "xixi";
    System.out.println(username);
%>

<%--向页面输出信息--%>
<%=username%>

      <hr>

      <%=pageContext.getAttribute("username")%><br>
      <%=request.getAttribute("username")%><br>
      <%=session.getAttribute("username")%><br>
      <%=application.getAttribute("username")%><br>
      <%=request.getParameter("username")%><br>

      <hr>
      <%--在servlet中设置数据，在jsp中获取数据--%>
      <a href="servletandjsp">从servlet到jsp共享数据</a>
</body>
</html>
