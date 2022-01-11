package Chap03.sec03;

import java.util.List;
import java.util.stream.Collectors;

public class HighCaloriesMenu {

    public static void main(String[] args) {
        List<String> names = Dish.menu.stream().filter(dish -> {
            System.out.println("filtering : " + dish.getName());
            return dish.getCalories() > 500;
        }).map(dish -> {
            System.out.println("mapping : " + dish.getName());
            return dish.getName();
        }).collect(Collectors.toList());

        System.out.println(names);
    }

}
