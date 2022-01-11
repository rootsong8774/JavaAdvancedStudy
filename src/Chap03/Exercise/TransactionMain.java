package Chap03.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TransactionMain {


    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950));

        System.out.println("=====================Q1=============================");
        transactionList.stream().filter(transaction -> transaction.year() == 2011)
            .sorted(Comparator.comparingInt(Transaction::value)).forEach(
                System.out::println);

        System.out.println("=====================Q2=============================");
        transactionList.stream().map(transaction -> transaction.trader().city()).distinct().forEach(
            System.out::println);

        System.out.println("=====================Q3=============================");
        transactionList.stream().filter(transaction -> transaction.trader().city()
                .equals("Cambridge"))
            .map(transaction -> transaction.trader().name()).distinct()
            .sorted(Comparator.naturalOrder()).forEach(
                System.out::println);

        System.out.println("=====================Q4============================");
        transactionList.stream().map(transaction -> transaction.trader().name())
            .sorted(Comparator.naturalOrder()).distinct().forEach(
                System.out::println);


        System.out.println("=====================Q5============================");
        boolean isThereMilan = transactionList.stream()
            .anyMatch(transaction -> transaction.trader().city().equals("Milan"));
        if (isThereMilan) {
            System.out.println("There is a trader in Milan.");
        } else {
            System.out.println("There is no trader in Milan.");
        }


        System.out.println("=====================Q6=============================");
        transactionList.stream().filter(transaction -> transaction.trader().city()
                .equals("Cambridge"))
            .map(Transaction::value).forEach(
                System.out::println);


        System.out.println("=====================Q7, Q8=========================");
        Optional<Integer> transactionMax = transactionList.stream().map(Transaction::value)
            .reduce(Integer::max);
        Optional<Integer> transactionMin = transactionList.stream().map(Transaction::value)
            .reduce(Integer::min);
        System.out.println("Maximum transaction : " + transactionMax.get() + ", Minimum transaction : "
            + transactionMin.get());

    }
}
