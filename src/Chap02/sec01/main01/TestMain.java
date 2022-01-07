package Chap02.sec01.main01;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        System.out.println("Create Object"+list1);

        System.out.println("Add the data : add()");
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        System.out.println("result : "+list1);

        System.out.println("update data set()");
        list1.set(0,"A");
        list1.set(1,"B");
        System.out.println("result : "+list1);

        System.out.println("delete data remove()");
        list1.remove(0);
        System.out.println("result : "+list1);

        list1.remove("c");
        System.out.println("delete data 'c' result : "+list1);

        System.out.println("Contains the data contains()");
        boolean contains = list1.contains("B");
        System.out.println("result : "+contains);


    }

}
