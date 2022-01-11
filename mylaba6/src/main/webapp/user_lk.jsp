<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Objects" %>
<%
    if (!Objects.equals((String) session.getAttribute("AUTH"), "TRUE"))
        response.sendRedirect("login.jsp");
%>
<html>
<head>
    <title>Страница пользователя </title>
    <link rel="stylesheet" type="text/css" href="styles/style.css">


</head>
<body>

<h1>Личный кабинет пользователя</h1>
<div id="navigate">
    Вы вошли как: <%=session.getAttribute("LOGIN")%>
    <h1>Привет, <%=session.getAttribute("NICKNAME")%></h1>
</a><br>
    <br>
    <form action="logout" method="post">
        <input type="submit" value="Выход" id="exit_btn">
    </form>
</div>
</div>
</body>
</html>