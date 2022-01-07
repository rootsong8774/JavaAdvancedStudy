package Chap01.sec01.main02;

public class SingleTonType {

    private static SingleTonType type = null;
    private SingleTonType() {}
    public static SingleTonType getInstance(){
        if (type == null)
            type = new SingleTonType();
        return type;
    }

}
