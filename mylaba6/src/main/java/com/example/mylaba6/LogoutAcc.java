package com.example.mylaba6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class for logging out of an account
 */
@WebServlet("/logout")
public class LogoutAcc extends HttpServlet {
    /**
     * @param req User request (to server) variable
     * @param resp Server response variable
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Получение сессии
        HttpSession session = req.getSession();
        // Очистка всех атрибутов сессии
        session.setAttribute("AUTH", "FALSE");
        session.setAttribute("LOGIN", null);
        session.setAttribute("STATUS", null);
        session.setAttribute("NICKNAME", null);
        // Редирект в index.jsp файл
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
