package net.golovach.eshop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class RequestInfoFilter implements  Filter {

    FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        //this.filterConfig = filterConfig;
        System.out.println("RequestInfoFilter initialized");
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        System.out.println("Method: " + req.getMethod() + ", QueryString: " + req.getQueryString());
        //System.out.println("RemoteAddress: " + req.getRemoteAddr());
        //System.out.println("QueryString: " + req.getQueryString());
        //System.out.println("Protocol: " + req.getProtocol());
        //System.out.println();

        chain.doFilter(req, res);
    }


    public void destroy() {

    }
}
