package Chap01.sec06.main01;

public class TypeA {

    private String name ="name property";

    public TypeA(String name) {
        this.name = name;
    }

    public TypeA() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void method1(){
        System.out.println("TypeA.method1() - static method1");
    }
}
