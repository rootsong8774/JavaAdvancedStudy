package Chap03.sec04;

import Chap03.sec04.Dish.Type;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringMain {

    public static void main(String[] args) {
        List<Dish> vegetarianMenu;
        vegetarianMenu = Dish.menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(vegetarianMenu);

        System.out.println("===========================================================");
        System.out.println("Filtering unique elements");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 5, 6, 1, 3, 2);
        numbers.stream().distinct().filter(integer -> integer % 2 == 0)
            .forEach(a -> System.out.print(a + " "));

        System.out.println("\n===========================================================");

        List<Dish> specialMenu = Arrays.asList(
            new Dish("season fruit", true, 120, Type.OTHER),
            new Dish("prawns", false, 400, Type.FISH),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 530, Type.OTHER));

        List<Dish> filteredMenu = specialMenu.stream().filter(dish -> dish.getCalories() < 320)
            .toList();
        filteredMenu.forEach(System.out::println);
        List<Dish> slicedMenu1 = specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320)
            .toList();
        slicedMenu1.forEach(System.out::println);

        System.out.println("===========================================================");
        List<Dish> slicedMenu2 = specialMenu.stream().dropWhile(dish -> dish.getCalories() < 320)
            .toList();
        slicedMenu2.forEach(System.out::println);

        System.out.println("===========================================================");
        List<Dish> dishesLimit3 = Dish.menu.stream().filter(dish -> dish.getCalories() > 300)
            .sorted(
                Comparator.comparingInt(Dish::getCalories))
            .limit(3).toList();
        dishesLimit3.forEach(System.out::println);

        System.out.println("===========================================================");
        List<Dish> dishesSkip2 = Dish.menu.stream().filter(dish -> dish.getCalories() > 300).skip(2)
            .toList();
        dishesSkip2.forEach(System.out::println);

    }

}
