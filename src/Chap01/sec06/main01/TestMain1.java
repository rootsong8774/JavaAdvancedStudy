package Chap01.sec06.main01;

public class TestMain1 {

    public static void main(String[] args) {

        TypeA a1 = new TypeA();

        String name1 = a1.getName();
        System.out.println("a1 name = "+name1);

        a1.setName("name2");

        String name2 = a1.getName();
        System.out.println("a1 name = "+name2);

        TypeA a2 = new TypeA("name3");

        String name3 = a2.getName();
        System.out.println("a2 name = " + name3);

        TypeA.method1();
    }
}
