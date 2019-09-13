package Codility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Find all pairs in an array of integers that product of a given number
 */
public class PairsEqualToProduct {

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
                        .filter(j -> i != j && listOfSum.get(i) * listOfSum.get(j) == sum)
                        .forEach(j -> pairs.add(new Pairs(listOfSum.get(i), listOfSum.get(j))))
                );

        return pairs;
    }

    private static void print(List<Pairs> pairs) {
        pairs.forEach(System.out::println);
        System.out.println(" # of pairs: " + pairs.size());
    }

    public static void main(String[] args) {
        print(findPairs(400, List.of(10, 20, 9, 40)));
        System.out.println("------------------");

        print(findPairs(1906, List.of(10, 20, 9, 40)));
        System.out.println("------------------");

        print(findPairs(400, List.of(-10, 20, 9, -40)));
        System.out.println("------------------");

        print(findPairs(-400, List.of(-10, 20, 9, 40,-10)));
        System.out.println("------------------");
    }

}
