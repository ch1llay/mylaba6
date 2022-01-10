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

/**
 * Class for adding a questionnaire
 */
@WebServlet("/add_post")
public class AddPost extends HttpServlet {
    /**
     * @param req  User request (to server) variable
     * @param resp Server response variable
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // Запись в переменные значений, полученных из полей при отправке формы на сервлет
        String title = req.getParameter("title");
        String topic = req.getParameter("topic");
        String content = req.getParameter("content");
        String key_words = req.getParameter("key_words");
        String quote = req.getParameter("quote");
        String author = req.getParameter("author");
        String link = req.getParameter("link");

        resp.setContentType("text/html;charset=UTF-8");
        // Подключение к файлу с анкетами (у тебя с постами будет)
        File file = new File("posts.json");
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("posts.json");

        try {
            JSONArray output = (JSONArray) parser.parse(reader);
            // json-объект с добавляемой анкетой
            JSONObject obj = new JSONObject();
            HttpSession session = req.getSession(); // Подключение к сессии
            // Добавление информации о пользователе в анкету из сессии
            obj.put("login", (String) session.getAttribute("LOGIN"));
            obj.put("FirstName", (String) session.getAttribute("FIRSTNAME"));
            obj.put("LastName", (String) session.getAttribute("LASTNAME"));
            obj.put("gender", (String) session.getAttribute("GENDER"));
            obj.put("phone", (String) session.getAttribute("PHONE"));
            obj.put("age", (String) session.getAttribute("AGE"));
            // Добавление в анкету информации, полученной из формы
            obj.put("title", title);
            obj.put("topic", topic);
            obj.put("content", content);
            obj.put("key_words", key_words);
            obj.put("quote", quote);
            obj.put("author", author);
            obj.put("link", link);
            // Добавляем в json-массив json-объект с данными пользователя
            output.add(obj);
            // Запись в файл
            try {
                Writer writer = new FileWriter(file);
                writer.write(output.toJSONString());
                writer.flush();
                writer.close();
            } catch (IOException ex) {
            }
            String url = "/show_your_posts/";    // Формирование ссылки для редиректа в ЛК
            url += session.getAttribute("LOGIN");    // Формирование ссылки для редиректа в ЛК
            resp.sendRedirect(url); // Редирект в ЛК
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}

