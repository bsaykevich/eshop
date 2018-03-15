package net.golovach.eshop.customSession;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class CustomHttpSession {

    private final Map<String, Object> customSession = new ConcurrentHashMap<>();
    private final String id;
    private Date lastAccessedTime;

    public CustomHttpSession(String id) {
        this.id = id;
        lastAccessedTime = new Date();
    }

    public void putAttribute(String key, Object value) {
        modifyLastAccessedTime();
        customSession.put(key, value);
    }

    public String getId() {
        modifyLastAccessedTime();
        return id;
    }

    public long getLastAccessedTime() {
        return lastAccessedTime.getTime();
    }

    public void modifyLastAccessedTime() {
        this.lastAccessedTime = new Date();
    }

    public Object getAttribute(String key) {
        modifyLastAccessedTime();
        return customSession.get(key);
    }

    public Iterator<String> getAttributeNames() {
        modifyLastAccessedTime();
        return customSession.keySet().iterator();
    }

    public void setAttribute(String name, Object value) {
        modifyLastAccessedTime();
        customSession.put(name, value);
    }

    public void removeAttribute(String name) {
        modifyLastAccessedTime();
        customSession.remove(name);
    }
}
