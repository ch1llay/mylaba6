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
import java.io.*;
import java.util.Objects;

/**
 * Class for changing the user role
 */
@WebServlet("/role")
public class SetRole extends HttpServlet {
    /**
     * @param req User request (to server) variable
     * @param resp Server response variable
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringWriter writer = new StringWriter();
        String login = req.getParameter("login");
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
        if(users.users.containsKey(login)){
            users.users.get(login).role = (users.users.get(login).role.equals("admin") ? "user":"admin");
            writer = new StringWriter();
            mapper.writeValue(writer, users);
            RW.write(writer.toString(), path);
        }


    }
}