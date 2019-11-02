package Codility;

//light bulb
public class LightBulbs {
    public static void main(String[] args) {
        int[] A = {2, 1, 3, 5, 4};
        int count = 0;
        int numComparison = 0;
        for (int i = 0; i < A.length; i++) {
            numComparison = Math.max(numComparison, A[i]);
            if (numComparison == i + 1) {
                count++;
            }
        }
        System.out.println(count);

    }
}
