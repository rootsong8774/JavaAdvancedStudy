package Chap03.sec02.lambda03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambdas {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(80, Color.GREEN));
        inventory.add(new Apple(155, Color.RED));
        inventory.add(new Apple(120, Color.YELLOW));

        Runnable runnable = () -> System.out.println("Hello!");
        runnable.run();

        System.out.println(filter(inventory, a->a.getColor()==Color.RED ));
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate {
        boolean test(Apple a);
    }
}
