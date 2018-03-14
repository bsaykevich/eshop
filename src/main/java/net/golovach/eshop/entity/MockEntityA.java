package net.golovach.eshop.entity;

import java.util.*;

public class MockEntityA {

    private String name;
    private List<String> listOfElements;
    private Map<String, String> map;
    private MockEntityB mockEntityB;

    public MockEntityA(){
        name = "littleSpider";
        listOfElements = Arrays.asList("leg1", "leg2", "leg3", "leg4");
        map = new HashMap<String, String>() {{put("key-0", "value-0");}};
        mockEntityB = new MockEntityB();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getListOfElements() {
        return listOfElements;
    }

    public void setListOfElements(List<String> listOfElements) {
        this.listOfElements = listOfElements;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public MockEntityB getMockEntityB() {
        return mockEntityB;
    }

    public void setMockEntityB(MockEntityB mockEntityB) {
        this.mockEntityB = mockEntityB;
    }


}
