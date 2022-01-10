<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Objects" %>
<%
    if (!Objects.equals((String) session.getAttribute("AUTH"), "TRUE"))
        response.sendRedirect("login.jsp");
%>
<html>
<head>
    <title>Лента</title>
    <link rel="stylesheet" href="styles/style_user_account.css">
</head>
<body>
<a href="show_your_posts/<%=session.getAttribute("LOGIN")%>">В личный кабинет</a>
<div id="posts">
    <h3>Список постов</h3>
    <c:forEach var="par" items="${allPosts}">
        <div id="post">
            <table>
                <tr>
                    <th><a href="show_your_posts/${par.get("login")}">${par.get("login")}</a></th>
                </tr>
                <tr>
                    <td>Имя:</td>
                    <td>${par.get("FirstName")}</td>
                </tr>
                <tr>
                    <td>Фамилия:</td>
                    <td>${par.get("LastName")}</td>
                </tr>
                <tr>
                    <td>Пол:</td>
                    <td>${par.get("gender")}</td>
                </tr>
                <tr>
                    <td>Телефон:</td>
                    <td>${par.get("phone")}</td>
                </tr>
                <tr>
                    <td>Возраст:</td>
                    <td>${par.get("age")}</td>
                </tr>
                <tr>
                    <td>Название поста:</td>
                    <td>${par.get("title")}</td>
                </tr>
                <tr>
                    <td>Тема:</td>
                    <td>${par.get("topic")}</td>
                </tr>
                <tr>
                    <td>Текст:</td>
                    <td>${par.get("content")}</td>
                </tr>
                <tr>
                    <td>Ключевые слова:</td>
                    <td>${par.get("key_words")}</td>
                </tr>
                <tr>
                    <td>Цитата:</td>
                    <td>${par.get("quote")}</td>
                </tr>
                <tr>
                    <td>Автор:</td>
                    <td>${par.get("author")}</td>
                </tr>
                <tr>
                    <td>Инстаграм:</td>
                    <td>${par.get("link")}</td>
                </tr>
                <tr>
            </table>
        </div>
    </c:forEach>
</div>
</body>
</html>
