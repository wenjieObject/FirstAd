<%--
  Created by IntelliJ IDEA.
  User: wenjiejiang
  Date: 2020/6/28
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="user" method="post">
        <input type="hidden" name="method" value="userList">
        姓名：<input type="text" name="username" value="${username}">
        年龄：<input type="text" name="age" value="${age}">
        <input type="submit" value="查询">
        <input type="reset" value="重置">
    </form>

    <hr>
    <table>
        <tr>
            <td>编号</td>
            <td>用户名</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>生日</td>
            <td>注册时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.username}</td>
                <td>${u.realname}</td>
                <td>${u.age}</td>
                <td>${u.birthday}</td>
                <td>${u.regTime}</td>
                <td></td>
            </tr>
        </c:forEach>
    </table>
</center>

</body>
</html>
