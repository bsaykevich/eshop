package net.golovach.eshop.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class DemoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello from DemoController!");

        HttpSession session = request.getSession(true);

        Enumeration<String> mockCtrlParameters = getServletConfig().getInitParameterNames();

        while (mockCtrlParameters.hasMoreElements()){
            String servletParamName = mockCtrlParameters.nextElement();
            String servletParamValue = getInitParameter(servletParamName);
            session.setAttribute(servletParamName, servletParamValue);
        }

        Enumeration<String> ctxParameters = getServletContext().getInitParameterNames();

        while (ctxParameters.hasMoreElements()){
            String ctxParamName = ctxParameters.nextElement();
            String ctxParamValue = getServletContext().getInitParameter(ctxParamName);
            session.setAttribute(ctxParamName, ctxParamValue);
        }




    }

}
