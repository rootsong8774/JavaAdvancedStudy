package Chap01.sec07.main01;

import java.lang.reflect.Field;

public class TestMain {

    public static void main(String[] args) {

        try {
            Class clazz = ProductVo.class;
            Field field = clazz.getDeclaredField("productName");
            Grid anno = field.getAnnotation(Grid.class);
            System.out.println("name : "+ anno.name());
            System.out.println("width : "+ anno.width());
            System.out.println("order : "+ anno.order());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }
}
