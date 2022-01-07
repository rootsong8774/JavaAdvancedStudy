package Chap01.sec06.main01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestMain2 {

    public static void main(String[] args) throws Exception {

        Class forName = Class.forName("Chap01.sec06.main01.TypeA");
        Object a1 = forName.newInstance();

        Method method1 = forName.getDeclaredMethod("getName");
        Object name1 = method1.invoke(a1);
        System.out.println("a1 name = " + name1);

        Method method2 = forName.getDeclaredMethod("setName", String.class);
        method2.invoke(a1, "name2");

        Object name2 = method1.invoke(a1);
        System.out.println("a1 name = "+name2);

        Constructor constructor = forName.getConstructor(String.class);
        Object a2 = constructor.newInstance("name3");

        Object name3 = method1.invoke(a2);
        System.out.println("a1 name = "+name3);

        Method method3 = forName.getDeclaredMethod("method1");
        method3.invoke(null);
    }

}
