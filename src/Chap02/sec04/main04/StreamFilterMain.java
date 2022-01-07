package Chap02.sec04.main04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterMain {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "z", "f", "e", "", "f");
        List<Integer> numbers = Arrays.asList(2, 6, 1, 23, 67, 10);
        Stream<String> filter = strings.stream().filter(s -> !s.isEmpty())
            .sorted(Comparator.naturalOrder());
        List<String> list = filter.collect(Collectors.toList());
        System.out.println(list);
        System.out.println("====================");
        Stream<Integer> numberFilter = numbers.stream().filter(x -> x > 9)
            .sorted(Comparator.naturalOrder());
        List<Integer> list2 = numberFilter.collect(Collectors.toList());
        System.out.println(list2);
        System.out.println("====================");
        strings.stream().distinct().filter(s -> !s.isEmpty()).sorted(Comparator.naturalOrder())
            .forEach(e -> System.out.print(e + " "));

        System.out.println("\n====================");
        strings.stream().distinct().filter(s -> !s.isEmpty()).sorted(Comparator.naturalOrder())
            .skip(2).forEach(i -> System.out.print(i + " "));
        System.out.println("\n====================");
        Stream<String> concat = Stream.concat(
            strings.stream().filter(s -> !s.isEmpty()).sorted(Comparator.naturalOrder()),
            Arrays.asList("A", "B").stream());
        // concat.forEach(i -> System.out.print(i + " "));
        List<String> concatList = concat.collect(Collectors.toList());
        System.out.println(concatList);
        System.out.println("====================");

        strings.stream().distinct().filter(s->s.length()>0).sorted(Comparator.naturalOrder()).map(s->s.concat("##")).forEach(i-> System.out.print(i+" "));



    }

}
