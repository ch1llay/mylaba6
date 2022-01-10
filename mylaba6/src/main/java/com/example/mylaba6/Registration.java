package com.example.mylaba6;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

@JsonAutoDetect
class User{
    public String nickname;
    public String userLogin;
    public String password;
    public User(){

    }
}
@JsonAutoDetect
class Users{
    public ArrayList<User> users;
    public Users(){

    }
}

/**
 * Class for user registration
 */
@WebServlet("/reg")
public class Registration extends HttpServlet {
    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
    private static void Write(String s, String path){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(path))) {
                writter.write(s);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param req User request (to server) variable
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

        ArrayList<User> users = new ArrayList<>();
        for(Integer i =0; i < 5; i++){
            User user = new User();
            user.userLogin = i.toString();
            user.password = i.toString();
            user.nickname = i.toString();
            users.add(user);
        }
        String path = "users.json";
        String data = "";
        if(new File(path).exists()) {
            data = readUsingFiles(path);
        }

            StringWriter writer = new StringWriter();

            //это объект Jackson, который выполняет сериализацию
            ObjectMapper mapper = new ObjectMapper();

            Users usersForWrite = new Users();
            usersForWrite.users = users;
            // сама сериализация: 1-куда, 2-что
            mapper.writeValue(writer, usersForWrite);
            final String dir = System.getProperty("user.dir");
            Write(writer.toString(), path);

            Users readerUsers = mapper.readValue(readUsingFiles(path), Users.class);



    }
}



