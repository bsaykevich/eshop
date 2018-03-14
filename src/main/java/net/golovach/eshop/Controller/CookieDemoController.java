package net.golovach.eshop.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieDemoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        Cookie fromClient = null;

        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if ("counter".equals(cookie.getName())) {
                    fromClient = cookie;
                    break;
                }
            }
        }

        if(fromClient == null){
            resp.addCookie(new Cookie("counter", "1"));
            resp.getWriter().write("you visit this page: " + 1 + " time");
        }
        else {
            Integer count = Integer.valueOf(fromClient.getValue());
            resp.addCookie(new Cookie("counter", (++count).toString()));
            resp.getWriter().write("Cookie controller: you visit this page: " + count + " times");
        }

        System.out.println("cookie version: " + fromClient.getVersion());
    }
}

