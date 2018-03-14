package net.golovach.eshop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class ProcessingTimeFilter implements Filter {

    FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        System.out.println("ProcessingTimeFilter initialized.");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpServletRequest.getSession(true);

        filterConfig.getServletContext().log("Hello from ServletContext log!");

       /* Enumeration<String> fltrParameters = filterConfig.getInitParameterNames();

        while(fltrParameters.hasMoreElements()){
            String fltrParamName = fltrParameters.nextElement();
            String fltrParamValue = filterConfig.getInitParameter(fltrParamName);
            session.setAttribute(fltrParamName, fltrParamValue);
        }*/

       long inTime = System.nanoTime();
       filterChain.doFilter(httpServletRequest, httpServletResponse);
       long outTime = System.nanoTime();
        System.out.println("Processing time is: " + (outTime - inTime)/1000.0 + " ms");
        System.out.println();


    }

    public void destroy() {    }
}
