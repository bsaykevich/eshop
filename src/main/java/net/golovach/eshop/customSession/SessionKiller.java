package net.golovach.eshop.customSession;

import java.util.Date;
import java.util.Iterator;

public class SessionKiller implements Runnable {

    Long currentTime = new Date().getTime();
    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            currentTime = new Date().getTime();

            Iterator<String> sessions = CustomHttpSessionOnServerRepository.getSessions();
            while (sessions.hasNext()) {
                String sessionID = sessions.next();
                CustomHttpSession session = CustomHttpSessionOnServerRepository.getSession(sessionID, false);
                if ((currentTime - session.getLastAccessedTime()) > 240 * 60 * 1000) {
                    CustomHttpSessionOnServerRepository.removeSession(sessionID);
                }
            }
        }

    }
}
