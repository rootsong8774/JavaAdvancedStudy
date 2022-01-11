package Chap03.sec03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamBasic {

    public static void main(String[] args) {
        /*Dish.menu.forEach(System.out::println);
        System.out.println("=============================");*/
        List<Dish> lowCaloriesMenu = Dish.menu.stream().filter(x -> x.getCalories() < 400)
            .sorted(Comparator.comparingInt(Dish::getCalories).reversed()).collect(Collectors.toList());
        System.out.println(lowCaloriesMenu);
        System.out.println("=============================");
        System.out.println(getFilter(Dish.menu, dish -> dish.getCalories() < 400));
        System.out.println("=============================");

        List<Integer> lowCaloriesMenu2 = Dish.menu.stream().filter(x -> x.getCalories() < 400)
            .sorted(Comparator.comparingInt(Dish::getCalories).reversed()).map(Dish::getCalories).toList();
        System.out.println(lowCaloriesMenu2);


    }

    public static List<Dish> getFilter(List<Dish> menu, Predicate<Dish> predicate) {
        List<Dish> result = new ArrayList<>();
        for (Dish d : menu) {
            if (predicate.test(d)) {
                result.add(d);
            }
        }
        result.sort(Comparator.comparingInt(Dish::getCalories).reversed());
        return result;
    }

}
