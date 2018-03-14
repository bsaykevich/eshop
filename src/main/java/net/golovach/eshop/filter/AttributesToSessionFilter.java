package net.golovach.eshop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class AttributesToSessionFilter implements Filter {

    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        System.out.println("AttributesToSessionFilter initialized.");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();

        while(initParameterNames.hasMoreElements()){
            String parameterName = initParameterNames.nextElement();
            String initParameter = filterConfig.getInitParameter(parameterName);
            session.setAttribute(parameterName, initParameter);
            System.out.println(parameterName + " added to session");
        }

        chain.doFilter(req, res);
    }

    public void destroy() {

    }
}
