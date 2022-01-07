package Chap02.sec01.main02;

import java.util.ArrayList;

public class TestMain {

    public static void main(String[] args) {

        ArrayList<Member> list1 = new ArrayList<>();
        list1.add(new Member("A001","홍길동"));
        list1.add(new Member("A002","박명수"));
        System.out.println(list1);

        ArrayList<Member> list2 = (ArrayList<Member>) list1.clone();
        System.out.println(list2);

        list2.get(0).setMemberId("A003");
        System.out.println(list1);
        System.out.println(list2);
    }

}
