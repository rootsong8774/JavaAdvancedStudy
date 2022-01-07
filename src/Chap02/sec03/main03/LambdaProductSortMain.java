package Chap02.sec03.main03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaProductSortMain {

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("A001", "Americano",3000));
        list.add(new Product("A002", "CafeLatte",4000));
        list.add(new Product("A003","Hot Chocolate", 5000));
        list.add(new Product("A004", "Orange Juice", 3000));
        System.out.println(list);
        Collections.sort(list, Comparator.comparingInt(Product::getPrice));
        System.out.println(list);
        Collections.sort(list, (p1,p2)-> p1.getPrice()-p2.getPrice());
        System.out.println(list);
    }

}
