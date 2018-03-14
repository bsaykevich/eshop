package net.golovach.eshop.custom_view_framework;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.xml.soap.SAAJResult;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HttpSessionImpl implements HttpSession {

    private final Map<String, Object> sessionMap = new ConcurrentHashMap<>();

    private String JSESSIONID;
    private final long creationTime;
    private int maxInactiveInterval;

    private ServletContext servletContext;

    public HttpSessionImpl(String JSESSIONID, ServletContext servletContext) {
        creationTime = new Date().getTime();
        this.JSESSIONID = JSESSIONID;
        this.servletContext = servletContext;
        maxInactiveInterval = 30 * 60;
    }

    @Override
    public long getCreationTime() {
        return creationTime;
    }

    @Override
    public String getId() {
        return JSESSIONID;
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return servletContext;
    }

    @Override
    public void setMaxInactiveInterval(int interval) {
        maxInactiveInterval = interval;
    }

    @Override
    public int getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    @Deprecated
    @Override
    public HttpSessionContext getSessionContext() {
        return null;
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Deprecated
    @Override
    public Object getValue(String name) {
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        //return new org.apache.commons.collections4.iterators.IteratorEnumeration<String>(sessionMap.keySet().iterator());
        Iterator<String> iterator = sessionMap.keySet().iterator();

        return new Enumeration<String>() {
            @Override
            public boolean hasMoreElements() {
                return iterator.hasNext();
            }

            @Override
            public String nextElement() {
                return iterator.next();
            }
        };
    }

    @Deprecated
    @Override
    public String[] getValueNames() {
        return new String[0];
    }

    @Override
    public void setAttribute(String name, Object value) {

    }

    @Deprecated
    @Override
    public void putValue(String name, Object value) {

    }

    @Override
    public void removeAttribute(String name) {
        sessionMap.remove(name);
    }

    @Deprecated
    @Override
    public void removeValue(String name) {

    }

    @Override
    public void invalidate() {

    }

    @Override
    public boolean isNew() {
        return false;
    }
}
