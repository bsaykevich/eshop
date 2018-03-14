package net.golovach.eshop.custom_view_framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomHttpSessionOnServerRepository {
    public static Map<String,CustomHttpSession> sessions = new ConcurrentHashMap<>();

    // sessionID get from request -> cookies
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
            String newSessionID = new Integer(new Double((Math.random()*1000_000_000)).intValue()).toString();
            sessions.put(newSessionID, new CustomHttpSession());
            requiredSession = sessions.get(newSessionID);

            /*
            // not create new sessionID

            requiredSession = new CustomHttpSession();
            sessions.put(sessionID, requiredSession);

             */
        }

        return requiredSession;
    }

    public static Map<String, CustomHttpSession> getSessions() {
        return sessions;
    }
}
