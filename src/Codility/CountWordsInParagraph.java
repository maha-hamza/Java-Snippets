package Codility;

import java.util.stream.Stream;

public class CountWordsInParagraph {

    public static void main(String[] args) {
        String s = "Hello People," +
                " i'm just counting." +
                " Do you want to \" join";
        System.out.println(countWords(s));
    }

    private static long countWords(String paragraph) {
        paragraph = paragraph.replaceAll("[^0-9a-zA-Z' ]+", "");
        return Stream.of(paragraph.split(" ")).filter( world -> world.length()>0).count();
    }
}
