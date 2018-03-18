package net.golovach.eshop.inject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

import static java.util.Arrays.asList;

public class FieldReflector {


    public static List<Field> collectUpTo (Class<?> clazz, Class<?> upperBound){
        ArrayList<Field> result = new ArrayList<>();
        Class<?> current = clazz;

        while (current != upperBound){
            result.addAll(asList(current.getDeclaredFields()));
            current = current.getSuperclass();
        }

        return result;
    }

    public static List<Field> filterInject (List<Field> allFields){
            List<Field> markedFields = new LinkedList<>();

        Iterator<Field> iterator = allFields.iterator();
        while (iterator.hasNext()){

            Field next = iterator.next();
            Annotation[] annotations = next.getAnnotations();

            for(Annotation ann : annotations){
                if(ann.getClass().equals(Inject.class)){
                    markedFields.add(next);
                }
            }

        }
        return markedFields;
    }
}
