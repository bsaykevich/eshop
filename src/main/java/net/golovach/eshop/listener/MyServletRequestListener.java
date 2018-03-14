package net.golovach.eshop.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

    // реагирует на вход request-a в контейнер и выход из него
    // (можно реализовывать processingTime-функционал через этот листенер?



    public void requestDestroyed(ServletRequestEvent sre) {
        sre.getServletRequest().setAttribute("processingTimeStart", System.nanoTime());
    }

    public void requestInitialized(ServletRequestEvent sre) {
        Long processingTimeStart = (Long) sre.getServletRequest().getAttribute("processingTimeStart");
        System.out.println(System.nanoTime() - processingTimeStart);
    }
}
