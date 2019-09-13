package Codility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Find all pairs in an array of integers that sum up to a given number
 */
public class PairsEqualToSum {

    static class Pairs {
        private int x;
        private int y;

        public Pairs(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" + x + "," + y + "}";
        }
    }

    private static List<Pairs> findPairs(int sum, List<Integer> listOfSum) {
        List<Pairs> pairs = new ArrayList<>();

        IntStream.range(0, listOfSum.size())
                .forEach(i -> IntStream.range(i, listOfSum.size())
                        .filter(j -> i != j && listOfSum.get(i) + listOfSum.get(j) == sum)
                        .forEach(j -> pairs.add(new Pairs(listOfSum.get(i), listOfSum.get(j))))
                );

        return pairs;
    }

    private static void print(List<Pairs> pairs) {
        pairs.forEach(System.out::println);
        System.out.println(" # of pairs: " + pairs.size());
    }

    public static void main(String[] args) {
        print(findPairs(6, List.of(1, 5, 7, -1)));
        System.out.println("------------------");

        print(findPairs(6, List.of(1, 5, 7, -1, 5)));
        System.out.println("------------------");

        print(findPairs(2, List.of(1, 1, 1, 1)));
        System.out.println("------------------");

        print(findPairs(11, List.of(10, 12, 10, 15, -1, 7, 6,
                5, 4, 2, 1, 1, 1)));
        System.out.println("------------------");
    }

}
