<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"   %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>second</title>
</head>
<body>

<%--jsp指令标签 page

page指令标签可以写在jsp页面的任意位置，通常我们写在页面的首行
page属性：
    contentType 用来设置响应字符集，会被翻译成 response.setContentType("text/html;charset=UTF-8");
    import  用来导包

    extends 用来指定父类，通常不设置
    isErrorPage 用来指定当前是否为异常页面。默认为false.当为true时，jsp中会添加一个隐含对象Exception
    errorPage  用来指定当前页面出错后转发到的页面
    isELIgnored 是否忽略EL表达式
    session 是否启用session对象。默认为true
    language  用来指定jsp解析时使用的语言。目前有且只有一种，java
    pageEncoding 只用来设置页面中的字符集
--%>
<h1>page指令</h1>

<%--<%
    int i=1/0;
%>--%>


<%--
include标签：
        可在写在任意位置。实际上include指令是原封不动的将目标资源拷贝到当前页面的相应位置上，我们也称这种方式为静态包含。
    作用：向当前页面引入其它资源,如 jsp页面 html页面
    注意：不能引入图片视频或像word等文件
    属性：
        file 指来指向要引入的资源路径

--%>
<%@include file="index.jsp"  %>
<%@include file="one.html"%>
<%--<%@include file="logo.gif"%>--%>


</body>
</html>
