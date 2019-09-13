package Codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Find all pairs in an array of integers that sum up to a given number
 */
public class SumOfOdds {

    private static void sumOfOdd(List<Integer> listOfSum) {

        var sum = listOfSum.stream()
                .filter(i -> Collections.frequency(listOfSum, i) % 2 != 0)
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);


    }

    public static void main(String[] args) {
        sumOfOdd(List.of(1, 1, 2, 2, 3, 3, 3));
        System.out.println("------------------");
        sumOfOdd(List.of(10, 20, 30, 40, 40));
        System.out.println("------------------");


    }

}
