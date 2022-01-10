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
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * Class to demonstrate your questionnaires
 */
@WebServlet("/show_your_posts/*")
public class ShowYourPosts extends HttpServlet {
    /**
     * @param req User request (to server) variable
     * @param resp Server response variable
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] pathInfo = req.getPathInfo().split("/");
        String user_login = pathInfo[1]; // Получение логина, как парметра из URL
        // Вектор с выводимыми анкетами
        List vec = new Vector();

        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("posts.json");

        try {
            // Получение массива всех существующих анкет
            JSONArray posts = (JSONArray) parser.parse(reader);
            boolean found = false;
            // Map с данными из анкеты
            Map<String, String> postsOut = new HashMap<>();
            for(int i = 0; i < posts.size(); i++) {
                JSONObject post = (JSONObject) posts.get(i); // Текщая i-тая анкета
                // Если логин текущего пользователя совпал с логином автора анкеты (у тебя поста), добавляем данные из анкеты
                if (Objects.equals((String) user_login, (String) post.get("login"))) {
                    found = true;
                    postsOut = new HashMap<>(); // Обнуление Mapа
                    // Запись данных анкеты в Map
                    postsOut.put("FirstName", (String) post.get("FirstName"));
                    postsOut.put("LastName", (String) post.get("LastName"));
                    postsOut.put("gender", (String) post.get("gender"));
                    postsOut.put("phone", (String) post.get("phone"));
                    postsOut.put("age", (String) post.get("age"));
                    postsOut.put("login", (String) post.get("login"));
                    postsOut.put("title", (String) post.get("title"));
                    postsOut.put("topic", (String) post.get("topic"));
                    postsOut.put("content", (String) post.get("content"));
                    postsOut.put("key_words", (String) post.get("key_words"));
                    postsOut.put("quote", (String) post.get("quote"));
                    postsOut.put("author", (String) post.get("author"));
                    postsOut.put("link", (String) post.get("link"));
                    postsOut.put("flag", "true");
                    vec.add(postsOut); // Добавление mapa с анкетой в вектор
                }
            }
            if(!found) {
                // Если анкеты не найдены, возвращаем логин и значение флага - false
                postsOut.put("login", user_login);
                postsOut.put("flag", "false");
                vec.add(postsOut);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        req.setAttribute("myPosts", vec);
        req.getRequestDispatcher("/user_lk.jsp").forward(req,resp); // Редирект на страницу пользователя
    }
}
