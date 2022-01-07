package Chap02.sec04.main01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamSortMain {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Americano");
        list.add("Green Tea Latte");
        list.add("Cafe Latte");
        System.out.println(list);
        Collections.sort(list, Comparator.naturalOrder());
        System.out.println(list);
        for (String obj: list){
            System.out.println(obj);
        }
        System.out.println("==============");
        list.stream().sorted().forEach(System.out::println);
    }

}
