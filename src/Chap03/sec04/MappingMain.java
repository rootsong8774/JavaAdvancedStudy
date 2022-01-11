package Chap03.sec04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MappingMain {

    public static void main(String[] args) {
        List<String> names = Dish.menu.stream().map(Dish::getName).collect(
            Collectors.toList());
        System.out.println(names);
        System.out.println("==============================================");

        List<Integer> namesLength = Dish.menu.stream().map(Dish::getName).map(String::length)
            .collect(
                Collectors.toList());
        System.out.println(namesLength);
        System.out.println("==============================================");

        List<String> words = Arrays.asList("Hello", "World");
        words.stream().map(word -> word.split("")).distinct().toList().forEach(
            System.out::println);
        System.out.println("==============================================");

        words.stream().map(word -> word.split("")).map(Arrays::stream).distinct().toList()
            .forEach(System.out::println);
        System.out.println("==============================================");

        List<String> uniqueCharacters = words.stream().map(word -> word.split(""))
            .flatMap(Arrays::stream).distinct().collect(
                Collectors.toList());
        System.out.println(uniqueCharacters);
        System.out.println("==============================================");

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(3, 4, 5);
        numbers1.stream()
            .flatMap(i -> numbers2.stream().map(j -> new Integer[]{i, j})).toList()
            .forEach(pair -> System.out.print("(" + pair[0] + ", " + pair[1] + ")\t"));
        System.out.println("==============================================");


    }
}
