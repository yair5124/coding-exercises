package ineed.to.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambdas {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(sortByLength(new String[]{"Aab", "a", "Aa", "Aaa","abcd"})));
        System.out.println(Arrays.asList(sortByLengthDesc(new String[]{"Aab", "a", "Aa", "Aaa","abcd"})));
        System.out.println(Arrays.asList(sortByFirstChar(new String[]{"eab", "c", "ba", "gaa","abcd"})));
        System.out.println(Arrays.asList(sortByE(new String[]{"eab", "c", "ba", "gaa","abcde"})));
        System.out.println(Arrays.asList(sortByEUtil(new String[]{"eab", "c", "ba", "gaa","abcde"})));
        System.out.println(Arrays.asList(sortByEUtil2(new String[]{"eab", "c", "ba", "gaa","abcde"})));

        List<String> words = Arrays.asList("eab", "c", "ba", "gaa","abcde");
        System.out.println(Lambdas.allMatches(words, s -> s.length() < 4));
        System.out.println(Lambdas.allMatches(words, s -> s.contains("b")));
        System.out.println(Lambdas.allMatches(words, s -> (s.length() % 2) == 0));

        System.out.println(Lambdas.allMatchesTmpl(words, s -> s.length() < 4));
        System.out.println(Lambdas.allMatchesTmpl(words, s -> s.contains("b")));
        System.out.println(Lambdas.allMatchesTmpl(words, s -> (s.length() % 2) == 0));
        List<Integer> numbers = Arrays.asList(3, 5, 2, 55, 77, 5764, 325);
        System.out.println(Lambdas.allMatchesTmpl(numbers, n -> (10 > n/10 && n/10 > 1)));
        System.out.println(Lambdas.allMatchesTmpl(numbers, n -> String.valueOf(n).indexOf('5') >= 0));
        System.out.println(Lambdas.allMatchesTmpl(numbers, n -> n % 2 == 0));

        System.out.println(Lambdas.transformedList(words, s -> s + "!"));
        System.out.println(Lambdas.transformedList(words, s -> s.replaceAll("a", "hey")));
        System.out.println(Lambdas.transformedList(words, String::toUpperCase));

        System.out.println(Lambdas.transformedListTmpl(words, s -> s + "!"));
        System.out.println(Lambdas.transformedListTmpl(words, s -> s.replaceAll("a", "hey")));
        System.out.println(Lambdas.transformedListTmpl(words, String::toUpperCase));
        System.out.println(Lambdas.transformedListTmpl(numbers, n -> Math.pow(n, 2)));
    }

    private static String[] sortByLength(String[] strings) {
        Arrays.sort(strings, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
        return strings;
    }

    private static String[] sortByLengthDesc(String[] strings) {
        Arrays.sort(strings, (str1, str2) -> Integer.compare(str2.length(), str1.length()));
        return strings;
    }

    private static String[] sortByFirstChar(String[] strings) {
        Arrays.sort(strings, (str1, str2) -> Character.compare(str1.charAt(0), str2.charAt(0)));
        return strings;
    }

    private static String[] sortByE(String[] strings) {
        Arrays.sort(strings, (str1, str2) -> {
            int idx1 = str1.indexOf('e');
            int idx2 = str2.indexOf('e');
            if (idx1 < 0 && idx2 < 0) return 0;
            if (idx1 >= 0 && idx2 >= 0) return 0;
            if (idx1 < 0) return 1;
            return -1;
        });
        return strings;
    }

    private static String[] sortByEUtil(String[] strings) {
        Arrays.sort(strings, (str1, str2) -> Lambdas.compareByE(str1, str2));
        return strings;
    }

    private static String[] sortByEUtil2(String[] strings) {
        Arrays.sort(strings, Lambdas::compareByE);
        return strings;
    }

    private static int compareByE(String str1, String str2) {
        int idx1 = str1.indexOf('e');
        int idx2 = str2.indexOf('e');
        if (idx1 < 0 && idx2 < 0) return 0;
        if (idx1 >= 0 && idx2 >= 0) return 0;
        if (idx1 < 0) return 1;
        return -1;
    }

    private static List<String> allMatches(List<String> input, Predicate<String> predicate) {
        List<String> result = new ArrayList<String>();
        for (String str: input) {
            if (predicate.test(str)) result.add(str);
        }
        return result;
    }

    private static <T> List<T> allMatchesTmpl(List<T> input, Predicate<T> predicate) {
        List<T> result = new ArrayList<T>();
        for (T obj: input) {
            if (predicate.test(obj)) result.add(obj);
        }
        return result;
    }

    private static List<String> transformedList(List<String> input, Function<String, String> func) {
        List<String> result = new ArrayList<String>();
        for (String str: input) {
            result.add(func.apply(str));
        }
        return result;
    }

    private static <T,R> List<R> transformedListTmpl(List<T> input, Function<T, R> func) {
        List<R> result = new ArrayList<R>();
        for (T obj: input) {
            result.add(func.apply(obj));
        }
        return result;
    }
}
