<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Objects" %>
<%
    if (Objects.equals((String) session.getAttribute("AUTH"), "TRUE")) {
        if (Objects.equals((String) session.getAttribute("STATUS"), "user")) {
            request.getRequestDispatcher("user_lk.jsp").forward(request, response);
        } else if (Objects.equals((String) session.getAttribute("STATUS"), "admin"))
            request.getRequestDispatcher("admin_lk.jsp").forward(request, response);

    }
%>
<html>
<head>
    <title>Регистрация</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="styles/style.css">


</head>
<body>
<div id="container">
    <h1>Игромир<br></br>Регистрация</h1>
    <div id="non-id">
        <form method="post" action="reg" id="reg_form">
            <p>${login_error}</p>
            Введите имя:
            <input type="text" name="nickname" id="nickname" required><br>
            Логин:<input type="text" name="login" id="login" required><br>
            Пароль:
            <input type="password" name="password" id="password" required><br>
            <input type="submit" value="Зарегистрироваться" id="reg_btn">
        </form>
        <p>Уже есть аккаунт? <a href="login.jsp">Войти</a></p>
    </div>
</div>
</body>
</html>
