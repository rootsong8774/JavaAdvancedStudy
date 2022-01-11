package Chap03.sec02.lambda02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingMain {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(80, "Green"));
        inventory.add(new Apple(120, "red"));
        inventory.add(new Apple(115, "Blue"));

        System.out.println(inventory);
        inventory.sort(Comparator.comparingInt(Apple::getWeight));
        System.out.println(inventory);
        inventory.sort(Comparator.comparing(Apple::getColor));
        System.out.println(inventory);


    }
}
