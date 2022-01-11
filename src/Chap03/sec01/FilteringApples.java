package Chap03.sec01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(80, "Green"));
        inventory.add(new Apple(115, "Green"));
        inventory.add(new Apple(120, "red"));

        System.out.println(filterApplesWeight(inventory, 80));
        System.out.println(filterApplesColor(inventory));
    }

    public static Predicate<Apple> weightCompare(int weight) {
        return apple -> apple.getWeight() > weight;
    }

    public static List<Apple> filterApplesWeight(List<Apple> inventory, int weight) {
        return inventory.stream().filter(FilteringApples.weightCompare(weight))
            .toList();
    }

    public static List<Apple> filterApplesColor(List<Apple> inventory) {
        return inventory.stream().filter(FilteringApples::isGreenApple)
            .toList();
    }

    public static boolean isGreenApple(Apple apple) {
        return apple.getColor().equals("Green");
    }

}
