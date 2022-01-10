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
 * Class for displaying a list of users
 */
@WebServlet("/show_users")
public class ShowAllForAdmin extends HttpServlet {
    /**
     * @param req User request (to server) variable
     * @param resp Server response variable
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Лист с полльзователями
        List list = new Vector();

        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("users.json");

        try {
            JSONArray users = (JSONArray) parser.parse(reader);
            for(int i = 0; i < users.size(); i++) {
                JSONObject user = (JSONObject) users.get(i);
                Map<String, String> jsonObg = new HashMap<>(); // Map с информацие о пользователе
                jsonObg.put("id", Objects.toString(user.get("id"), null));
                jsonObg.put("login", (String) user.get("login"));
                jsonObg.put("FirstName", (String) user.get("FirstName"));
                jsonObg.put("LastName", (String) user.get("LastName"));
                jsonObg.put("password", (String) user.get("password"));
                jsonObg.put("gender", (String) user.get("gender"));
                jsonObg.put("phone", (String) user.get("phone"));
                jsonObg.put("age", (String) user.get("age"));
                jsonObg.put("role", (String) user.get("role"));
                list.add(jsonObg); // добавление mapа в лист
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        req.setAttribute("users", list);
        req.getRequestDispatcher("/admin_lk.jsp").forward(req,resp); // Редирект в админку
    }

}
