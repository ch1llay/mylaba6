<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Objects" %>
<%
    if (!Objects.equals((String) session.getAttribute("AUTH"), "TRUE"))
        response.sendRedirect("login.jsp");
    else if (Objects.equals((String) session.getAttribute("STATUS"), "admin"))
        response.sendRedirect("/show_users");
%>
<html>
<head>
    <title>Добавить пост</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/style_new_post.css">

</head>
<body>
<h1>Выложите свой пост</h1>
<div id="post">
    <form action="add_post" method="post" id="add_form">
        <a href="show_your_posts/<%=session.getAttribute("LOGIN")%>">Вернуться в личный кабинет</a>
        <p>Название поста:</p>
        <input type="text" required placeholder="Название поста" id="title" name="title">
        <p>Укажите тему:</p>
        <input type="text" required placeholder="Тема" id="topic" name="topic">
        <p>Содержание поста:</p>
        <input type="text" required placeholder="Текст" id="content" name="content">
        <p>Ключевые слова:</p>
        <input type="text" required placeholder="Ключевые слова" id="key_words" name="key_words">
        <p>Тематическая цитата:</p>
        <input type="text" placeholder="Цитата" id="quote" name="quote">
        <p>Автор:</p>
        <input type="text" placeholder="Автор" id="author" name="author">
        <p>Ссылка на инстаграм:</p>
        <input type="text" placeholder="@name" id="link" name="link"><br>


        <input type="submit" value="Опубликовать пост" id="add_btn">
    </form>
</div>
</body>
</html>
