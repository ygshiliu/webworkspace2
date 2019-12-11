<%@ page import="com.wnn.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<%

    User user1 = new User(1,"xixi","xixi@163.com",16);
    User user2 = new User(2,"hehe","hehe@163.com",17);
    User user3 = new User(3,"yiyi","yiyi@163.com",18);
    User user4 = new User(4,"haha","haha@163.com",19);

    List users = new ArrayList();
    users.add(user1);
    users.add(user2);
    users.add(user3);
    users.add(user4);
    request.setAttribute("users",users);
%>

<h1>用户列表</h1>
<table>
    <tr>
        <td>序号</td>
        <td>名字</td>
        <td>邮箱</td>
        <td>年龄</td>
    </tr>
    <%
        for (Object user : users) {
            User u = (User) user;
    %>
    <tr>
        <td><%=u.getId()%></td>
        <td><%=u.getUsername()%></td>
        <td><%=u.getEmail()%></td>
        <td><%=u.getAge()%></td>
    </tr>


    <%
        }
    %>
</table>


</body>
</html>
