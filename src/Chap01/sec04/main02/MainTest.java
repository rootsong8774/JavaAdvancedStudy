package Chap01.sec04.main02;

public class MainTest {

    public static void main(String[] args) {
        Gender gender =Gender.MAN;
        int value = gender.getValue();
        String name = gender.getName();

        System.out.println(value + " : "+ name);
        Gender gender1 = Gender.WOMAN;
        System.out.println(gender1.getValue() + " : "+ gender1.getName());
    }

}
