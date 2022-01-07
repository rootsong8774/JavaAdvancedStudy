package Chap01.sec06.main02;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestMain {

    public static void main(String[] args) throws Exception {
        var clazz = Class.forName("Chap01.sec06.main02.ProductVo");
        var constructor = clazz.getDeclaredConstructor(String.class, int.class);

        Object obj = constructor.newInstance("Test2", 2);
        System.out.println("Object Info : " + obj);

        Field field = clazz.getDeclaredField("productName");

        boolean isAccessible = field.isAccessible();

        field.setAccessible(true);

        Object nameFieldValue = field.get(obj);
        System.out.println("productName Value :::" + nameFieldValue);

        field.set(obj, "Test3");
        System.out.println("productName Value :::" + field.get(obj));

        field.setAccessible(isAccessible);

        Method method = clazz.getDeclaredMethod("getPrice");
        Object returnVal1 = method.invoke(obj);
        System.out.println("getPrice() result :::" + returnVal1);

        Method method2 = clazz.getDeclaredMethod("setPrice", int.class);
        Object returnVal2 = method2.invoke(obj, 3);
        System.out.println("setPrice() result:::" + returnVal2);
        System.out.println("Object Info:::" + obj);
    }

}
