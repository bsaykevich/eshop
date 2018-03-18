package net.golovach.eshop.inject;


import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
    /**
     * value - default name for @annotation member: @Inject("productDao")
     * if we use another name: @Inject(myName = "productDao")
     */
    public String value();
}
