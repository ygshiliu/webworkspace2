<%@ page import="com.wnn.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<%--El数学运算符--%>
3+4：${3+4} <br>
3-4：${3-4} <br>
3*4：${3*4} <br>
3/4：${3/4} <br>

<hr>

<%--El逻辑运算符--%>
3>4：${3>4} <br>

<hr>
<%
    //empty可以判断字符串 数组 集合是否为空
    String str ="";

//    Integer[] integers = {1,2,3,4};
    Integer[] integers = {};

    //引用类型是不能使用empty的
    User user = new User();
//    User user = new User(1,"hehe","hehe@128.com",20);

    List list = new ArrayList();
//    list.add(1);
//    list.add(2);

    Map map = new HashMap();
//    map.put("username","xixi");
//    map.put("age",16);
//    map.put("email","xixi@163.com");
    request.setAttribute("map",map);

    request.setAttribute("str",str);
    request.setAttribute("array",integers);
    request.setAttribute("object",user);
    request.setAttribute("list",list);

%>

empty str: ${empty str} <br>
empty array: ${empty array} <br>
empty object: ${empty object} <br>
empty list: ${empty list} <br>
empty map: ${not empty map} <br>

</body>
</html>
