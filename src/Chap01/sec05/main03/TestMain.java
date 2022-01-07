package Chap01.sec05.main03;

public class TestMain {

    public static void main(String[] args) {

        TypeB<TypeA<String>> typeB = new TypeB<>();

        TypeC<TypeA<Object>> typeC = new TypeC<>();

        TypeD<TypeA<String>> typeD =new TypeD<>();
    }
}
