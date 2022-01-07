package Chap01.sec01.main02;

public class TestMain {

    public static void main(String[] args) {
        SingleTonType type1 = SingleTonType.getInstance();
        SingleTonType type2 = SingleTonType.getInstance();
        if(type1 == type2) {
            System.out.println("SingleTon is Unique");
        }
    }

}
