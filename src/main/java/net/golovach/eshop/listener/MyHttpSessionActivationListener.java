package net.golovach.eshop.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MyHttpSessionActivationListener implements HttpSessionActivationListener {

    // interface HttpSessionActivationListener extends EventListener

    // если мой объект имплементит HttpSessionActivationListener (то есть является моим листенером)
    // и его кладут в атрибуты сессии И его перемещают между виртуальными машинами (или persist sessions - выгрузка из ОЗУ
    // на постоянный носитель [жесткий диск]), при кластеризации или пересылке сессии по интернету
    // (при этом его деактивируют-активируют) - контейнер при этом должен меня notify (как? - генерирует соответствующий event
    // и вызывает соответствующие методы всех насделников HttpSessionActivationListener)

    public void sessionWillPassivate(HttpSessionEvent se) {
        //throw new RuntimeException();
        System.out.println("Session is passivated.");
    }

    public void sessionDidActivate(HttpSessionEvent se) {
        //throw new RuntimeException();
        System.out.println("Session has been activated.");
    }
}
