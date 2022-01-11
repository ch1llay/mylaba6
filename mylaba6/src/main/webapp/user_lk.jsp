<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Objects" %>
<%
    if (!Objects.equals((String) session.getAttribute("AUTH"), "TRUE"))
        response.sendRedirect("login.jsp");
%>
<html>
<head>
    <title>Страница пользователя ${myPosts[0].get("login")} </title>
    <link rel="stylesheet" type="text/css" href="styles/style.css">


</head>
<body>

<h1>Личный кабинет пользователя <a href="\show_your_posts/${myPosts[0].get("login")}">${myPosts[0].get("login")}</a>
</h1>
<div id="navigate">
    Вы вошли как: <%=session.getAttribute("LOGIN")%>
    <h1>Привет, <%=session.getAttribute("NICKNAME")%></h1>
</a><br>
    <br>
    <form action="logout" method="post">
        <input type="submit" value="Выход" id="exit_btn">
    </form>
</div>
<%--<div id="posts">--%>
<%--    <c:choose>--%>
<%--        <c:when test="${myPosts[0].get(\"flag\") == \"true\"}">--%>
<%--            <h3>Посты</h3>--%>
<%--            <c:forEach var="par" items="${myPosts}">--%>
<%--                <div id="post">--%>
<%--                    <table>--%>
<%--&lt;%&ndash;                        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <th><a href="\show_your_posts/${par.get("login")}">${par.get("login")}</a></th>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </tr>&ndash;%&gt;--%>
<%--                        <tr>--%>
<%--                            <td>Имя:</td>--%>
<%--                            <td>${par.get("FirstName")}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Фамилия:</td>--%>
<%--                            <td>${par.get("LastName")}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Пол:</td>--%>
<%--                            <td>${par.get("gender")}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Сотовый телефон:</td>--%>
<%--                            <td>${par.get("phone")}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Возраст:</td>--%>
<%--                            <td>${par.get("age")}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Название поста:</td>--%>
<%--                            <td>${par.get("title")}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Тема:</td>--%>
<%--                            <td>${par.get("topic")}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Текст:</td>--%>
<%--                            <td>${par.get("content")}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Ключевые слова:</td>--%>
<%--                            <td>${par.get("key_words")}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Цитата:</td>--%>
<%--                            <td>${par.get("quote")}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Автор:</td>--%>
<%--                            <td>${par.get("author")}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Инстаграм:</td>--%>
<%--                            <td>${par.get("link")}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                    </table>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <p>Посты не найдены</p>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
</div>
</body>
</html>