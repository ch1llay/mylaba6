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
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * Сlass for demonstrating user questionnaires
 */
@WebServlet("/show_posts")
public class ShowAllPosts extends HttpServlet {
    /**
     * @param req User request (to server) variable
     * @param resp Server response variable
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Вектор выводимых анкет
        List vec = new Vector();

        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("posts.json");

        try {
            JSONArray questionnaires = (JSONArray) parser.parse(reader);
            for(int i = 0; i < questionnaires.size(); i++) {
                JSONObject questionnaire = (JSONObject) questionnaires.get(i);
                HttpSession session = req.getSession();
                if (!Objects.equals((String) session.getAttribute("LOGIN"), (String) questionnaire.get("login"))) {
                    Map<String, String> jsonObg = new HashMap<>(); // map с анкетой для демонстрации
                    jsonObg.put("FirstName", (String) questionnaire.get("FirstName"));
                    jsonObg.put("LastName", (String) questionnaire.get("LastName"));
                    jsonObg.put("gender", (String) questionnaire.get("gender"));
                    jsonObg.put("phone", (String) questionnaire.get("phone"));
                    jsonObg.put("age", (String) questionnaire.get("age"));
                    jsonObg.put("login", (String) questionnaire.get("login"));
                    jsonObg.put("title", (String) questionnaire.get("title"));
                    jsonObg.put("topic", (String) questionnaire.get("topic"));
                    jsonObg.put("content", (String) questionnaire.get("content"));
                    jsonObg.put("key_words", (String) questionnaire.get("key_words"));
                    jsonObg.put("quote", (String) questionnaire.get("quote"));
                    jsonObg.put("author", (String) questionnaire.get("author"));
                    jsonObg.put("link", (String) questionnaire.get("link"));
                    vec.add(jsonObg); // Добавление анкеты в вектор
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
       req.setAttribute("allPosts", vec);
        req.getRequestDispatcher("/show_posts.jsp").forward(req,resp); // Ссылка на страницу с лентой
    }
}
