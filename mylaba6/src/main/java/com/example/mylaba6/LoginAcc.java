package com.example.mylaba6;

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
     * @param req User request (to server) variable
     * @param resp Server response variable
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Получение из полей формы данных для авторизации
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("users.json");
        try {
            // Авторизация
            JSONArray oldUsers = (JSONArray) parser.parse(reader);
            JSONArray newUsers = new JSONArray();
            boolean auth = false;
            for(int i = 0; i < oldUsers.size(); i++) {
                JSONObject user = (JSONObject) oldUsers.get(i);
                // Проверка полученных логина и пароля на наличие в списке пользователей
                if (Objects.equals(login, user.get("login")))
                    if (Objects.equals(password, user.get("password"))) {
                        auth = true;
                        // Получение сессии
                        HttpSession session = req.getSession();
                        // Добавление атрибутов сессии
                        session.setAttribute("AUTH", "TRUE");
                        session.setAttribute("LOGIN", login);
                        session.setAttribute("STATUS", user.get("role"));
                        session.setAttribute("FIRSTNAME", user.get("FirstName"));
                        session.setAttribute("LASTNAME", user.get("LastName"));
                        session.setAttribute("GENDER", user.get("gender"));
                        session.setAttribute("PHONE", user.get("phone"));
                        session.setAttribute("AGE", user.get("age"));
                    }
                newUsers.add(user);
                // Запись в файл
                File file = new File("users.json");
                Writer writer = new FileWriter(file);
                writer.write(newUsers.toJSONString());
                writer.flush();
                writer.close();
            }
            // Если авторизация успешна
            if (auth){
                HttpSession session = req.getSession();
                req.setAttribute("login_user", login);
                String url = "/show_your_posts/";    // Формирование ссылки для редиректа в ЛК
                url += session.getAttribute("LOGIN");
                resp.sendRedirect(url); // Редирект в ЛК
            }
            else {
                // Выдача ошибки
                resp.setContentType("text/html");
                req.setAttribute("auth_error","Логин и/или пароль неправильный!");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        } catch (IOException | ParseException e) { e.printStackTrace(); }
    }
}
