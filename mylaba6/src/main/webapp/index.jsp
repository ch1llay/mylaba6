<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Objects" %>
<%
    if (Objects.equals((String) session.getAttribute("AUTH"), "TRUE"))
        response.sendRedirect("user_lk.jsp");
    else
        response.sendRedirect("login.jsp");
%>
<!DOCTYPE html>
<html>
<head>
    <title>It's index file</title>
</head>
<body>
</body>
</html>