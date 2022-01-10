<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Objects" %>
<%
    if (Objects.equals((String) session.getAttribute("AUTH"), "TRUE"))
        response.sendRedirect("user_lk.jsp");
%>
<html>
<head>
    <title>Вход</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/style_login.css">

</head>
<body>
<h1>Добро пожаловать в LavanderPeople!</h1>
<h2>Авторизация</h2>
<div id="non-id">
    <form method="post" action="auth" id="log_form">
        <p>${auth_error}</p>
        <table>
            <tr>
                <td>Никнейм</td>
                <td><input type="text" required name="login" id="login"></td>
            </tr>
            <tr>
                <td>Пароль</td>
                <td><input type="password" name="password" id="password"></td>
            </tr>
        </table>
        <input type="submit" value="Войти" id="log_btn">

    <p>Впервые на сайте?<a href="registr.jsp">Зарегистрируйтесь!</a></p>
    </form>
</div>
</body>
</html>