<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.Objects" %>

<%
    if (!Objects.equals((String) session.getAttribute("AUTH"), "TRUE"))
        response.sendRedirect("login.jsp");
    else if (!Objects.equals((String) session.getAttribute("STATUS"), "admin")) {
        request.getRequestDispatcher("/error_admin.jsp").forward(request, response);
    }

%>
<html>
<head>
    <title>Кабинет администратора</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
<h1>Личный кабинет администратора</h1>
<div id="navigate">
    <div id="cent">
        <p>Вы вошли как <%=(String) session.getAttribute("LOGIN")%>
        </p>
        <h3>Всего пользователей зарегистрировано ${count}</h3>
        <form action="logout" method="post">
            <input type="submit" value="Выход" id="exit_btn">
        </form>
    </div>
</div>
</body>
</html>
