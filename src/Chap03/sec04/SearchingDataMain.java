package Chap03.sec04;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchingDataMain {

    public static void main(String[] args) {

        if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!");
        }
        System.out.println("===============================================");

        boolean isHealthy = Dish.menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);
        System.out.println("===============================================");

        boolean isHealthy2 = Dish.menu.stream().noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println(isHealthy2);
        System.out.println("===============================================");

        Optional<Dish> vegetarianDish = Dish.menu.stream().filter(dish -> dish.getCalories() > 1000)
            .findAny();
        System.out.println(vegetarianDish);
        System.out.println("===============================================");

        Dish.menu.stream().filter(dish -> dish.getCalories() < 1000)
            .findAny().ifPresent(dish -> System.out.println(dish.getName()));
        System.out.println("===============================================");

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream().map(n -> n * n)
            .filter(n -> n % 3 == 0).findFirst();
        System.out.println(firstSquareDivisibleByThree.get());
        System.out.println("===============================================");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        int product = numbers.stream().reduce(1,(a,b)->a*b);
        System.out.println(product);

        Optional<Integer> optionalSum = numbers.stream().reduce(Integer::sum);
        System.out.println(optionalSum);
        System.out.println("===============================================");

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("Max Value : " + max.get() + ", Min Value : "+ min.get());
        System.out.println("===============================================");

        int count = Dish.menu.stream().map(d->1).reduce(0,Integer::sum);
        System.out.println(count); //Map-Reducing pattern



    }

}
