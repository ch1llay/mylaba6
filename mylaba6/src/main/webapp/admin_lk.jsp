<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Objects" %>

<%
    if (!Objects.equals((String) session.getAttribute("AUTH"), "TRUE"))
        response.sendRedirect("login.jsp");
    else if (!Objects.equals((String) session.getAttribute("STATUS"), "admin")) {
        String url = "/show_your_posts/";
        url += session.getAttribute("LOGIN");
        response.sendRedirect(url);
    }

%>
<html>
<head>
    <title>Кабинет администратора</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/style_admin.css">

</head>
<body>
<h1>Личный кабинет администратора</h1>
<div id="navigate">
    <div id="cent">
        <p>Вы вошли как <%=(String) session.getAttribute("LOGIN")%>
        </p>
        <form action="logout" method="post">
            <input type="submit" value="Выход" id="exit_btn">
        </form>
    </div>
</div>
<div id="all_users">
    <table border="1" width="600">
        <thead>
        <tr>
            <th>Id</th>
            <th>Никнейм</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Возраст</th>
            <th>Пол</th>
            <th>Телефон</th>
            <th>Пароль</th>
            <th>Роль</th>
            <th>Удалить</th>
            <th>Изменить роль</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="par" items="${users}">
            <tr>
                <td>${par.get("id")}</td>
                <td>${par.get("login")}</td>
                <td>${par.get("FirstName")}</td>
                <td>${par.get("LastName")}</td>
                <td>${par.get("age")}</td>
                <td>${par.get("gender")}</td>
                <td>${par.get("phone")}</td>
                <td>${par.get("password")}</td>
                <td>${par.get("role")}</td>

                <td>
                    <form action="delete" method="get">
                        <input type="hidden" name="id" value="${par.get("id")}">
                        <button id="delete_btn" type="submit">Удалить</button>
                    </form>
                </td>

                <td>
                    <form action="role" method="get">
                        <input type="hidden" name="id" value="${par.get("id")}">
                        <button id="role_btn" type="submit">Изменить роль</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
