package Chap01.sec04.main02;

public enum Gender {

    MAN(1, "MAN"), WOMAN(2, "WOMAN");
    private int value;
    private String name;

    Gender(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
