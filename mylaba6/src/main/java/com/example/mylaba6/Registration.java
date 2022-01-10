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
 * Class for user registration
 */
@WebServlet("/reg")
public class Registration extends HttpServlet {
    /**
     * @param req User request (to server) variable
     * @param resp Server response variable
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // Получение из полей формы данных для авторизации
        String FirstName = req.getParameter("FirstName");
        String LastName = req.getParameter("LastName");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        resp.setContentType("text/html;charset=UTF-8");

        File file = new File("users.json");
        JSONParser parser = new JSONParser();
        Reader reader;
        try {
            reader = new FileReader("users.json");
        }
        catch (IOException e){
            System.out.println("создал ");
            Writer writer = new FileWriter(file);
            writer.write(" ");
            writer.close();
            reader = new FileReader("users.json");
        }
        try {
            // Считывание json
            JSONArray output = (JSONArray) parser.parse(reader);
            boolean repeatLogin = false;
            // Проверка на наличие пользователя с заданным логином
            for(int i = 0; i < output.size(); i++) {
                JSONObject user = (JSONObject) output.get(i);
                if (Objects.equals(login, (String) user.get("login"))) {
                    repeatLogin = true;
                    break;
                }
            }
            // Если логин не занят, регистрируем
            if (!repeatLogin) {
                // Заполнение json-объекта с данными о новом пользователе
                JSONObject newUser = new JSONObject(); // json-объект с данными о новом пользователе
                JSONObject lastUser = (JSONObject) output.get(output.size()-1);
                int lastId = (int) (long) lastUser.get("id"); // Получаем id последнего пользователя
                // Заполняем данные нового пользователя
                newUser.put("id", lastId + 1);
                newUser.put("FirstName", FirstName);
                newUser.put("LastName", LastName);
                newUser.put("login", login);
                newUser.put("password", password);
                newUser.put("phone", phone);
                newUser.put("gender", gender);
                newUser.put("age", age);
                newUser.put("role", "user");

                // Добавляем в json-массив json-объект с данными пользователя
                output.add(newUser);

                // Запись в файл
                Writer writer = new FileWriter(file);
                writer.write(output.toJSONString());
                writer.flush();
                writer.close();

                HttpSession session = req.getSession();
                // Запуск сессии
                session.setAttribute("AUTH", "TRUE");
                session.setAttribute("LOGIN", login);
                session.setAttribute("STATUS", "user");
                session.setAttribute("FIRSTNAME", FirstName);
                session.setAttribute("LASTNAME", LastName);
                session.setAttribute("GENDER", gender);
                session.setAttribute("PHONE", phone);
                session.setAttribute("AGE", age);
                req.setAttribute("login_user", login);
                String url = "/show_your_posts/";
                url += session.getAttribute("LOGIN");
                resp.sendRedirect(url); // Редирект в ЛК
            }
            else{
                req.setAttribute("login_error","Логин уже занят!");
                req.getRequestDispatcher("/registr.jsp").forward(req,resp);
            }
        } catch (IOException |  ParseException e) { e.printStackTrace(); }
    }
}



