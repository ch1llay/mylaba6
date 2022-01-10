<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ page import="java.util.Objects" %>--%>
<%--<%--%>
<%--    if (Objects.equals((String) session.getAttribute("AUTH"), "TRUE")) {--%>
<%--        if (Objects.equals((String) session.getAttribute("STATUS"), "user")) {--%>
<%--            String url = "/show_your_posts/";--%>
<%--            url += session.getAttribute("LOGIN");--%>
<%--            response.sendRedirect(url);--%>
<%--        } else if (Objects.equals((String) session.getAttribute("STATUS"), "admin"))--%>
<%--            response.sendRedirect("/show_users");--%>
<%--    }--%>
<%--%>--%>
<html>
<head>
    <title>Регистрация</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/style_reg.css">

</head>
<body>
<div id="container">
    <h1>Регистрация</h1>
    <div id="non-id">
        <form method="post" action="reg" id="reg_form">
            <p>${login_error}</p>
            <table>
                <tr>
                    <td>Ваше имя:</td>
                    <td><input type="text" name="FirstName" id="FirstName" required></td>
                </tr>
                <tr>
                    <td>Ваша фамилия:</td>
                    <td><input type="text" name="LastName" id="LastName" required></td>
                </tr>
                <tr>
                    <td>Никнейм:</td>
                    <td><input type="text" name="login" id="login" required></td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input type="password" name="password" id="password" required></td>
                </tr>
                <tr>
                    <td>Мобильный телефон:</td>
                    <td><input type="text" name="phone" id="phone" required></td>
                </tr>
                <tr>
                    <td>Пол:</td>
                    <td><select name="gender" id="gender" required>
                        <option value="null">Женский/мужской</option>
                        <option value="Девушка">Женский</option>
                        <option value="Парень">Мужской</option>
                    </select></td>
                </tr>
                <tr>
                    <td>Ваш возраст:</td>
                    <td><input type="text" name="age" id="age" required></td>
                </tr>
            </table>

            <input type="submit" value="Зарегистрироваться" id="reg_btn">
        </form>
        <p>Уже есть аккаунт? <a href="login.jsp">Войти</a></p>
    </div>
</div>
</body>
</html>
