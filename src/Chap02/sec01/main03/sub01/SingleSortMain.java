package Chap02.sec01.main03.sub01;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class SingleSortMain {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(3);
        list1.add(4);
        list1.add(1);
        list1.add(2);
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("A");
        list2.add("E");
        list2.add("C");
        list2.add("k");
        list2.add("d");
        list2.add("2");
        list2.add("9");
        System.out.println(list2);
        Collections.sort(list2,Collections.reverseOrder());
        System.out.println(list2);
    }

}
