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
            <th>Никнейм</th>
            <th>Логин</th>
            <th>Пароль</th>
            <th>Роль</th>
            <th>Удалить</th>
            <th>Изменить роль</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.getNickname()}</td>
<%--                <td>${users.get(user.key).getLogin()}</td>--%>
<%--                <td>${users.get(user.key).getPassword()}</td>--%>
<%--                <td>${users.get(user.key).getRole()}</td>--%>

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
