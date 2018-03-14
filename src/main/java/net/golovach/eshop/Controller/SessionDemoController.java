package net.golovach.eshop.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class SessionDemoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        AtomicInteger count = (AtomicInteger) session.getAttribute("count");

        if(count == null){
            count = new AtomicInteger(1);
            session.setAttribute("count", count);
        }

        int numberOfVisit = count.getAndIncrement();
        resp.getWriter().write("Session controller: you visited this page: " + numberOfVisit + " times");
    }
}
