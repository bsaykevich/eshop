package net.golovach.eshop.customSession;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CustomHttpSessionOnClientRepository {

    public static final String ATTRIBUTE_SESSIONS_ON_COOKIES = "sessionRepository";

    public CustomHttpSession getSession(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        return null;
    }
}
