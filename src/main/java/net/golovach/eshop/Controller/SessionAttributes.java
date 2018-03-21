package net.golovach.eshop.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Properties;
import java.util.Set;

public class SessionAttributes {

    public static final String PRODUCTS_IN_BUCKET = "productsInBucket";

    private SessionAttributes() {

    }

    /*//Spring EL example
    ExpressionParser parser = new SpelExpressionParser();
    Expression exp1 = parser.parseExpression("'Hello World'.concat('!')");
    Expression exp2 = parser.parseExpression("'Hello World'.bytes.length");
    String message = (String) exp1.getValue();
    int length = (Integer) exp2.getValue();*/


    /*public static void main(String[] args) {
        Properties properties = System.getProperties();
        Set<Object> objects = properties.keySet();
        for(Object obj : objects){
            System.out.println(obj + " - " + System.getProperty(obj.toString()));
        }
    }*/
}

class Test {
    @Value("#{ systemProperties[user.region] }")
    private String defaultLocale;
}