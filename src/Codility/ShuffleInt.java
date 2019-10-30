package Codility;

import java.util.Random;

public class ShuffleInt {

    public static void main(String[] args) {
        System.out.println(shuffleInt(8745));
    }

    private static int shuffleInt(int number) {
        char[] stringVersion = String.valueOf(number).toCharArray();
        int length = stringVersion.length;
        String result = "";
        do {
            int randomNumberWithinRange = (int) (Math.random() * (length));
            if (!result.contains("" + stringVersion[randomNumberWithinRange])) {
                result = result.concat("" + stringVersion[randomNumberWithinRange]);
                if (result.length() == length)
                    length = -1;
            }
        } while (length != -1);


        return Integer.parseInt(result);
    }
}
