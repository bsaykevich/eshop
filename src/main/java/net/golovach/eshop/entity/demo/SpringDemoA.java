package net.golovach.eshop.entity.demo;

import java.util.Map;

public class SpringDemoA {

    private int[] array;
    private Map<String, SpringDemoB> map;

    public SpringDemoA() {
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setMap(Map<String, SpringDemoB> map) {
        this.map = map;
    }
}
