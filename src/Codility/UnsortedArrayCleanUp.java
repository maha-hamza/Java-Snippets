package Codility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Remove duplicates from unsorted array
 */
public class UnsortedArrayCleanUp {

    private static void cleanArray(List<Integer> listOfSum) {

       listOfSum.stream().distinct().forEach(e-> System.out.format("%d ",e));
    }

    private static void cleanArray2(List<Integer> listOfSum) {
        new HashSet<>(listOfSum)
                .forEach(e-> System.out.format("%d ",e));
    }

    public static void main(String[] args) {
        cleanArray(List.of(1, 2, 5, 1, 7, 2, 4, 2));
        System.out.println();
        cleanArray2(List.of(1, 2, 5, 1, 7, 2, 4, 2));

    }

}
