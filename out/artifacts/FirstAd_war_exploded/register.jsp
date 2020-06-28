<%--
  Created by IntelliJ IDEA.
  User: wenjiejiang
  Date: 2020/6/28
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="static/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#btn_login').click(function () {
                location.href='login.jsp'
            })
        })
    </script>
</head>
<body>
<center>
    <form action="" method="post">
        <table>
            <tr>
                <td>username:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>realname:</td>
                <td><input type="text" name="realname"></td>
            </tr>
            <tr>
                <td>age:</td>
                <td><input type="text" name="age"></td>
            </tr>
            <tr>
                <td>birthday:</td>
                <td><input type="text" name="birthday"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="register">
                    <input type="button" value="login" id="btn_login">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
