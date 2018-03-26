package ineed.to.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        System.out.println(search(1, new Integer[]{4, 7, 2, 5, 1, 1, 3}));
        System.out.println(search(4, new Integer[]{4, 7, 2, 5, 1, 1, 3}));
        System.out.println(search(3, new Integer[]{4, 7, 2, 5, 1, 1, 3}));
        System.out.println(search(6, new Integer[]{4, 7, 2, 5, 1, 1, 3}));

        List<String> words = Arrays.asList("eab", "c", "ba", "gaa","abcde", "whr");
        words.stream().forEach(s -> System.out.println("  " + s));
        words.stream().forEach(System.out::println);

        System.out.println(words.stream().map(s -> s + "!").collect(Collectors.toList()));
        System.out.println(words.stream().map(s -> s.replaceAll("a", "hey")).collect(Collectors.toList()));
        System.out.println(words.stream().map(String::toUpperCase).collect(Collectors.toList()));

        System.out.println(words.stream().filter(s -> s.length() < 4).collect(Collectors.toList()));
        System.out.println(words.stream().filter(s -> s.contains("b")).collect(Collectors.toList()));
        System.out.println(words.stream().filter(s -> (s.length() % 2) == 0).collect(Collectors.toList()));
        System.out.println(Arrays.asList(words.stream().filter(s -> (s.length() % 2) == 0).toArray()));

        System.out.println(getFirstMatch(words, "E"));
        System.out.println(getFirstMatch(words, "Q"));

        System.out.println(words.stream().reduce("", (s1, s2) -> s1.toUpperCase() + s2.toUpperCase()));
        System.out.println(words.stream().map(String::toUpperCase).reduce("", String::concat));
        System.out.println(words.stream().reduce((s1, s2) -> s1 + "," + s2).get());

        System.out.println(words.stream().mapToInt(String::length).sum());
        System.out.println(words.stream().filter(s -> s.contains("h")).count());

        int size = 100000;
        double[] randos = new Random().doubles(size).toArray();

        Op.timeOp(() -> System.out.println(DoubleStream.of(randos).map(Math::sqrt).sum()));
        Op.timeOp(() -> System.out.println(DoubleStream.of(randos).parallel().map(Math::sqrt).sum()));

        Supplier<Double> randGen = (() -> 10 * Math.random());
        Stream.generate(randGen).limit(5).forEach(System.out::println);
        List<Double> doubles = Stream.generate(randGen).limit(10).collect(Collectors.toList());
        System.out.println(doubles);
        Double[] doublesArr = Stream.generate(randGen).limit(20).toArray(Double[]::new);
        System.out.println(Arrays.asList(doublesArr));
    }

    private static String getFirstMatch(List<String> words, String str) {
        return words.stream()
                .map(s -> {
                    System.out.println("Uppercasing " + s);
                    return s.toUpperCase();
                })
                .filter(s -> s.length() < 4)
                .filter(s -> s.indexOf(str) >= 0)
                .findFirst().orElse(null);
    }

    public static int search(Integer n, Integer[] list) {
        int[] indices = IntStream.range(0, list.length).filter(index -> list[index] == n).toArray();
        return (indices == null || indices.length == 0) ? -1 : indices[0];
    }
}