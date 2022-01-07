package Chap01.sec04.main01;

import Chap01.sec04.main01.TypeA.GenderType;

public class TestMain {

    public static void main(String[] args) {
        TypeA a = new TypeA();
        a.setGenderType(GenderType.MAN);
        if (a.getGenderType() == GenderType.MAN) {
            System.out.println("Compare the Object = Man");
        } else if (a.getGenderType() == GenderType.WOMAN) {
            System.out.println("Compare the Object = Woman");
        } else {
            System.out.println("Cannot Compare");
        }
    }

}
