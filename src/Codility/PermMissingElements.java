package Codility;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PermMissingElements {
	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 0, 4, 5 };
		System.out.println(solution(A));
		System.out.println(solution2(A));
	}

	public static int solution(int[] A) {
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > 0 && !(A[i] == A[i - 1] + 1)) {
				res = A[i - 1] + 1;
				break;
			}
		}
		return res;
	}

	public static int solution2(int[] A) {

		int min = Arrays.stream(A).min().getAsInt();
		int max = Arrays.stream(A).max().getAsInt();

		int expectedSum = IntStream.range(min, max).sum() + min + max;
		int currentSum = Arrays.stream(A).sum();

		return Math.abs(expectedSum - currentSum);

	}

}
