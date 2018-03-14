package net.golovach.eshop.Controller;

import net.golovach.eshop.entity.MockEntityA;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * set attributes to different context levels
 */

public class MVCDemoController extends HttpServlet {

    private final String MVC_MOCK_VIEW = "MVCMock.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //set attribute to request
        req.setAttribute("reqAttrName", new MockEntityA());
        //set Attribute to session
        HttpSession session = req.getSession();
        session.setAttribute("sessionAttrName", new MockEntityA());
        //set attribute to context
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("contextAttrName", new MockEntityA());

        //set attr with same names
        req.setAttribute("test", "reqAttr");
        session.setAttribute("test", "sessionAttr");
        servletContext.setAttribute("test", "contextAttr");

        req.getRequestDispatcher(MVC_MOCK_VIEW).forward(req, resp);
    }
}
