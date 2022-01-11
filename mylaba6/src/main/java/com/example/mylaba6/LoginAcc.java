package com.example.mylaba6;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Objects;

/**
 * Class of the authorisation servlet
 */
@WebServlet("/auth")
public class LoginAcc extends HttpServlet {
    /**
     * @param req  User request (to server) variable
     * @param resp Server response variable
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Получение из полей формы данных для авторизации
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        StringWriter writer = new StringWriter();

        //это объект Jackson, который выполняет сериализацию
        ObjectMapper mapper = new ObjectMapper();
        String path = "users.json";
        Users users = new Users();
        if (new File(path).exists()) {
            users = mapper.readValue(RW.readUsingFiles(path), Users.class);
        } else {
            mapper.writeValue(writer, users);
        }
        HttpSession session = req.getSession();
        // Добавление атрибутов сессии

        User user = new User();
        if (users.users.containsKey(login)) {
            if (users.users.get(login).password.equals(password)) {
                user = users.users.get(login);

                session.setAttribute("AUTH", "TRUE");
                session.setAttribute("STATUS", user.role);
                session.setAttribute("LOGIN", user.userLogin);
                session.setAttribute("NICKNAME", user.nickname);
                if(user.role.equals("admin"))
                    req.setAttribute("count", users.users.values().size());
                req.getRequestDispatcher((user.role.equals("admin") )? "/admin_lk.jsp":"/user_lk.jsp").forward(req, resp); // Редирект в ЛК
            } else {
                // Выдача ошибки
                resp.setContentType("text/html");
                req.setAttribute("auth_error", "Логин и/или пароль неправильный!");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        } else {
            // Выдача ошибки
            resp.setContentType("text/html");
            req.setAttribute("auth_error", "Логин и/или пароль неправильный!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
