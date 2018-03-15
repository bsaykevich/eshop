package net.golovach.eshop.customSession;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class CustomHttpSessionOnServerRepository {

    public static Map<String,CustomHttpSession> sessions = new ConcurrentHashMap<>();

    static {
        Thread sessionKillerThread = new Thread(new SessionKiller());
        sessionKillerThread.start();
    }

    public static CustomHttpSession getSession(String sessionID) {
        return getSession(sessionID, true);
    }
    public static CustomHttpSession getSession(String sessionID, boolean canCreate){
        CustomHttpSession requiredSession = sessions.get(sessionID);

        /**
         * if requiredSession == null && we have a permission -> create new session
         * otherwise return null
         */
        if(requiredSession == null && canCreate){
            String newSessionID = new Long(new Random().nextLong()).toString();
            sessions.put(newSessionID, new CustomHttpSession(newSessionID));
            requiredSession = sessions.get(newSessionID);

        /*
        // not create new sessionID
        requiredSession = new CustomHttpSession();
        sessions.put(sessionID, requiredSession);
         */
        }

        return requiredSession;
    }

    public static Iterator<String> getSessions() {
        return sessions.keySet().iterator();
    }

    public static void removeSession (String sessionID){
        sessions.remove(sessionID);
    }
}

