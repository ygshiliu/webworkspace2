<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%--jsp模块:就是html标签，在html文件中如何写，在jsp文件中就如何写--%>
<h1>First.jsp</h1>

<%--jsp脚本片段：需要写在jsp脚本片段的标签中,即以尖括号百分号开头，以百分号尖括号结尾--%>
<%
    //在这个标签里我们可以像在java方法中一样开发写代码 ，即遵循java方法中代码书写规则就好
    //可以定义局部变量，但是不可以使用修饰符，如public
    //每条语句必须以分号结尾
    //可以调用方法


     String username = "hehe";
     int age = 16;

    byte[] bytes = username.getBytes();
    System.out.println(Arrays.toString(bytes));  //在后台控制台输出
    System.out.println((char)bytes[0]);  //在后台控制台输出

%>

<%--jsp表达式：以尖括号百分号等号开头，以百分号尖括号结尾
    作用：可以将后台java中的数据输出到页面中
    最终被翻译到_jspService()方法中，作为out.print(age);方法的参数输出
--%>

<%=age%>
<%=username%>

<%--jsp声明：以尖括号百分号叹号开头，以百分号尖括号结尾
    作用：可以用来定义方法或类属性

--%>
<%!
    public ServletConfig getInfo(){
        return this.getServletConfig();
    }

    public String username;

%>

<%--jsp注释--%>
<!--html注释-->

<%--
            jsp         java        html

jsp注释       能           否           否
java注释      能           能           否
html注释      能           能           能

--%>

<%--jsp中的九大隐含对象--%>
<%
/*    pageContext 页面上下文对象，通过此对象可以获取到jsp中其它八个隐含对象
      作用范围：当前页面。
 */
    ServletConfig servletConfig = pageContext.getServletConfig();
    ServletContext servletContext = pageContext.getServletContext();


    pageContext.setAttribute("username","xixi");
//    pageContext.getAttribute("username");
//    pageContext.removeAttribute("username");

    request.setAttribute("username","hehe");
    session.setAttribute("username","haha");
    application.setAttribute("username","enen");

    //request.getRequestDispatcher("index.jsp").forward(request,response);
    response.sendRedirect("index.jsp");
%>

<hr>

<%--<%=pageContext.getAttribute("username")%><br>
<%=request.getAttribute("username")%><br>
<%=session.getAttribute("username")%><br>
<%=application.getAttribute("username")%><br>--%>


</body>
</html>
