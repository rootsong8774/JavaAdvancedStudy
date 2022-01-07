package Chap01.sec05.main01;

public class TestMain {

    public static void main(String[] args) {

        TypeB typeB = new TypeB();
        String method1 = typeB.method1("Test");
        String method2 = TypeB.method2("Test2");

        System.out.println(method1);
        System.out.println(method2);

        TypeA<String> a1 = new TypeA<>("1");
        String t1 = a1.getT();
        String method3 = typeB.methods(a1);
        String method4 = TypeB.method4(a1);

        System.out.println(t1);
        System.out.println(method3);
        System.out.println(method4);

        TypeA a2 = new TypeA("2");
        Object t2 = a2.getT();
        Object method5 = typeB.methods(a2);
        Object method6 = TypeB.method4(a2);
        System.out.println(method5);
        System.out.println(method6);
    }



}
