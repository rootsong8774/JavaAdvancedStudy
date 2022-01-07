package Chap02.sec04.main02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.asList(array);

        Stream<String> stream = list.stream();
        stream.forEach(item -> System.out.print(item + " "));
        System.out.println("\n==================");

        Stream<String> stream2 = Arrays.stream(array);
        stream2.forEach(item -> System.out.print(item + " "));
        System.out.println("\n==================");

        Stream<String> stream3 = Arrays.stream(array, 0, 3);
        stream3.forEach(item -> System.out.print(item + " "));
        System.out.println("\n==================");

        Stream<String> stream4 = Stream.of("a", "b", "c", "d", "e");
        stream4.forEach(item -> System.out.print(item + " "));
        System.out.println("\n==================");

        Stream<String> stream5 = Stream.empty();
        stream5.forEach(item -> System.out.print(item + " "));
        System.out.println("\n==================");

        IntStream stream6 = IntStream.range(5, 13);
        stream6.forEach(item -> System.out.print(item + " "));
        System.out.println("\n==================");

        IntStream stream7 = IntStream.rangeClosed(5, 12);
        stream7.forEach(item -> System.out.print(item + " "));
        System.out.println("\n==================");

        IntStream stream8 = new Random().ints(4);
        stream8.forEach(item -> System.out.print(item + " "));
        System.out.println("\n==================");

        Stream<String> stream9 = Stream.generate(() -> "generate").limit(5);
        stream9.forEach(item -> System.out.print(item + " "));
        System.out.println("\n==================");

        Stream<Double> stream10 = Stream.generate(Math::random).limit(5);
        stream10.forEach(item -> System.out.print(item + " "));
        System.out.println("\n==================");

        Stream<Integer> stream11 = Stream.iterate(1, n -> n + 2).limit(5);
        stream11.forEach(item -> System.out.print(item + " "));
        System.out.println("\n==================");


    }

}
