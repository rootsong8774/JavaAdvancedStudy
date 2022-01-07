package Chap01.sec05.main01;

public class TypeB {

    public <T> T method1(T t){
        return t;
    }

    public static <T> T method2(T t){
        return t;
    }

    public <T> T methods(TypeA<T> a){
        return a.getT();
    }

    public static <T> T method4(TypeA<T> a){
        return a.getT();
    }

}
