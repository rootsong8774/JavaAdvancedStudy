package Chap02.sec04.main03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamProductSortMain {

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("A001", "Americano",3000));
        list.add(new Product("A002","Hot Chocolate", 5000));
        list.add(new Product("A003", "CafeLatte",4000));
        list.add(new Product("A004", "Orange Juice", 3000));
        System.out.println(list);

        list.stream().sorted(Comparator.comparing(Product::getProductName)).forEach(
            System.out::println);
        System.out.println("====================");
        list.stream().sorted(Comparator.comparingInt(Product::getPrice)).forEach(
            System.out::println);
        System.out.println("====================");
        List<Product> sortedList =  list.stream().sorted(Comparator.comparingInt(Product::getPrice)).collect(
            Collectors.toList());
        System.out.println(sortedList);
    }

}
