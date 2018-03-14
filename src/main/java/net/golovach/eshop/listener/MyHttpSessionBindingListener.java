package net.golovach.eshop.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MyHttpSessionBindingListener implements HttpSessionBindingListener {

    //сообщает, если меня прикручивают/откручивают к сессии (кладут в атрибуты сессии)? (когда сессия invalidated/timeout?)

    public void valueBound(HttpSessionBindingEvent event) {
        String objName = event.getName();
    }

    public void valueUnbound(HttpSessionBindingEvent event) {

    }


}
