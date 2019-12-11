<%@ page import="com.wnn.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <%--
        分支语句:
        if -- else if -- else  ===>c:if 相当java中的if语句
        switch...case...default ===> c:choose...c:when...c:otherwise来表示
    --%>

    <%--
        c:if 满足条件的情况下才会执行,类型java中的if语句
        test:可以接合EL表达式，接收一个boolean值，为true时则会执行
        scope:设置域
        var:指定属性名
    --%>

    <c:if test="false">
        <h1>答对了</h1>
    </c:if>

    <c:set var="score" value="54" ></c:set>
<%--
    <c:if test="${score>=90}">
        <h1>优</h1>
    </c:if>
    <c:if test="${score<90 && score>=80}">
        <h1>良</h1>
    </c:if>
    <c:if test="${score<80 && score>=60}">
        <h1>及格</h1>
    </c:if>
    <c:if test="${score<60 }">
        <h1>不及格</h1>
    </c:if>--%>
<%--
    c:choose是c:when与c:otherwise的父标签，它们是不能脱离c:choose单独使用的
    其功能类似java中的if -- else if -- else
    只有所有c:when都不满足条件时才会执行c:otherwise
    注：c:when之间要注意满足条件的范围，只要前面满足条件就会被执行，同时跳出判断
--%>
    <c:choose>
        <c:when test="${score>=90}">
            <h1>优</h1>
        </c:when>
        <c:when test="${score>=80}">
            <h1>良</h1>
        </c:when>
        <c:when test="${score>=60}">
            <h1>及格</h1>
        </c:when>
        <c:otherwise>
            <h1>不及格</h1>
        </c:otherwise>
    </c:choose>

---------------------------------------------------<br>
    <%--
    c:forEach 用来实现循环功能
    begin 起始值
    end 结束值
    step:步长 默认1
    var:用来定义在域中存放的值的属性名，默认是pageContext
    类似java中的for(int i=0;i<10;i++){}

    --%>

    <c:forEach begin="1" end="10"  var="index">
        ${index}<br>
    </c:forEach>

    <hr>

    <%--
    items用来指向一个集合，可以是数组、list|set、map
    varStatus:将遍历的元素重新封装成一个新对象javax.servlet.jsp.jstl.core.LoopTagSupport
        --count用来表示元素在集合中的位置
        --first：返回一个布尔值，是否是第一个元素，若是则返回true,其它都返回false
        --last: 返回一个布尔值，是否为最后一个元素，若是返回true,其它都返回false
        --current: 返回当前元素
    --%>
    <%
        int[] ints = new int[]{1,2,3,4,5};
        pageContext.setAttribute("ints",ints);

        ////////////////////////
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
    <c:forEach  var="i" items="${users}" varStatus="obj" >
        ${i}--varStatus:${obj}----step:${obj.step}--begin:${obj.begin}--end:${obj.end}--count:${obj.count}--first:${obj.first}--last:${obj.last}--current:${obj.current}<br>
    </c:forEach>

<hr>

<%--
    var: 代表一个entity
    通过key获取元素的键
    通过value获取元素的值
--%>
<%
    Map map = new HashMap();
    map.put("username","xixi");
    map.put("age",16);
    map.put("email","xixi@163.com");
    request.setAttribute("map",map);
%>

    <c:forEach  var="i" items="${map}" varStatus="obj" >
        ${i}--${i.key} -- ${i.value}<br>
    </c:forEach>

----------------------------------

<%--
    页面中重定向到另一资源，通过c:redirect
    注意：它是基于项目名
--%>

<c:redirect url="index.jsp"></c:redirect>
</body>
</html>
