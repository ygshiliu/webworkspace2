<%@ page import="com.wnn.bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>$Title$</title>
</head>
<body>
<%


//    pageContext.setAttribute("user","xixi");
//    request.setAttribute("user","haha");
//    session.setAttribute("user","yiyi");
//    application.setAttribute("user","enen");
    //EL表达式默认是从小到大的顺序从域中查找获取数据，找到就显示出来，如果都没有则什么都不输出

    User user = new User(1,"xixi","xixi@163.com",16);
    pageContext.setAttribute("user1",user);

    List integers = new ArrayList();
    integers.add(1);
    integers.add(2);
    integers.add(3);
    integers.add(4);
    request.setAttribute("integers",integers);


    Map map = new HashMap();
    map.put("username","xixi");
    map.put("age",16);
    map.put("email","xixi@163.com");
    request.setAttribute("map",map);


%>
<%--EL中的隐含对象--%>
pageContext域：${pageScope.user}<br>
request请求域：${requestScope.user}<br>
session域: ${sessionScope.user}<br>
application域：${applicationScope.user}<br>

<hr>

<%--调用方法或属性--%>
user:${user1} <br>
${user1.toString()} #若是对象则调用对象的toString方法 <br>
${user1.setAge(4)} #调用user.getAge() <br>
${user1.getAge()} #调用user.setAge() <br>
${user1.age} #支持级联 <br>

<hr>

<%--集合--%>
list集合：${integers} <br>
方法：${integers.size()} <br>
第1个元素：${integers[1]} <br>

<hr>

<%--map--%>
map:${map} <br>
${map.username} <br>
${map.age} <br>
${map.email} <br>

</body>
</html>
