package Chap02.sec03.main02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaSortMain {

    public static void main(String[] args) {
        List<String> names1 = new ArrayList<>();
        names1.add("b");
        names1.add("c");
        names1.add("G");
        names1.add("3");
        names1.add("Q");
        List<String> names2 = new ArrayList<>();
        names2.add("b");
        names2.add("c");
        names2.add("G");
        names2.add("3");
        names2.add("Q");
        System.out.println(names1);
        sort1(names1);
        System.out.println(names1);
    }

    static void sort1(List<String> names) {
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
    }

}
