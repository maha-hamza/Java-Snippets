package Codility;

import java.util.Arrays;

public class MaxProductOfThree {
	public static void main(String[] args) {
		int[] A = new int[] { -9, -6, 3, 2, 5, 7 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int[] array = Arrays.stream(A).distinct().sorted().toArray();
		int sum1 = 1;
		int sum2 = 1;

		for (int i = array.length - 3; i < array.length; i++) {
			sum1 = Math.multiplyExact(sum1, array[i]);
		}

		for (int i = 0; i < 2; i++) {
			sum2 = Math.multiplyExact(sum2, array[i]);
		}
		sum2 = Math.multiplyExact(sum2, array[array.length - 1]);

		return Math.max(sum1, sum2);

	}
}
