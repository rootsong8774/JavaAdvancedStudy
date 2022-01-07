package Chap01.sec05.main01;

public class TypeA<T> {

    private T t;
    public TypeA(T t){
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
