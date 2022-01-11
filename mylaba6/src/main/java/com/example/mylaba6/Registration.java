package com.example.mylaba6;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;


/**
 * Class for user registration
 */
@WebServlet("/reg")
public class Registration extends HttpServlet {


    /**
     * @param req  User request (to server) variable
     * @param resp Server response variable
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // Получение из полей формы данных для авторизации
        String nickname = req.getParameter("nickname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=UTF-8");


        StringWriter writer = new StringWriter();

        //это объект Jackson, который выполняет сериализацию
        ObjectMapper mapper = new ObjectMapper();
        String path = "users.json";
        Users users = new Users();
        if (new File(path).exists()) {
            users = mapper.readValue(RW.readUsingFiles(path), Users.class);
        } else {
            mapper.writeValue(writer, users);
            RW.write(writer.toString(), path);
        }
        if (!users.users.containsKey(login)) {
            User newUser = new User();
            newUser.userLogin = login;
            newUser.password = password;
            newUser.nickname = nickname;
            users.users.put(login, newUser);
            writer = new StringWriter();
            mapper.writeValue(writer, users);
            RW.write(writer.toString(), path);


            HttpSession session = req.getSession();
            // Запуск сессии
            session.setAttribute("AUTH", "TRUE");
            session.setAttribute("LOGIN", login);
            session.setAttribute("STATUS", "user");
            session.setAttribute("NICKNAME", nickname);
            req.setAttribute("login_user", login);
            String url = "/user_lk.jsp";
            req.getRequestDispatcher(url).forward(req, resp);// Редирект в ЛК
        } else {
            req.setAttribute("login_error", "Логин уже занят!");
            req.getRequestDispatcher("/registr.jsp").forward(req, resp);
        }


    }
}



