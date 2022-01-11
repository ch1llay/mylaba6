<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Objects" %>
<%
    if (Objects.equals((String) session.getAttribute("AUTH"), "TRUE"))
        response.sendRedirect("/user_lk.jsp");
%>
<html>
<head>
    <title>Вход</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="styles/style.css">


</head>
<body>
<div style="text-align: center">
<h1 style="margin: auto" >Добро пожаловать в Игромир</h1>
<h2 style="margin: auto">Авторизация</h2>
<div id="non-id">
    <form method="post" action="auth" id="log_form">
        <p style="background-color: red;">${auth_error}</p>

                Логин<input type="text" required name="login" id="login"><br>
                Пароль
                <input type="password" name="password" id="password"><br>
        <br>
        <input type="submit" value="Войти" id="log_btn">

    <p>Впервые на сайте?<a href="registr.jsp">Зарегистрируйтесь!</a></p>
    </form>
</div>
</div>
</body>
</html>