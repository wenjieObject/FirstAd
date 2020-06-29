<%--
  Created by IntelliJ IDEA.
  User: wenjiejiang
  Date: 2020/6/28
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="static/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#btn_reg').click(function () {
                location.href='register.jsp'
            })
        })
    </script>
</head>
<body>
<center>
    <form action="user" method="post">
        <input type="hidden" name="method" value="login">
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
                <td colspan="2">
                    <input type="submit" value="login">
                    <input type="button" value="register" id="btn_reg">
                </td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
