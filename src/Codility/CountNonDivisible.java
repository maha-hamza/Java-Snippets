package Codility;

import java.util.Arrays;

public class CountNonDivisible {

	public static void main(String[] args) {
		int[] A = { 3, 1, 2, 3, 6 };
		System.out.println(Arrays.toString(solution(A)));
	}

	public static int[] solution(int[] A) {
		int[] nonDiv = new int[A.length];
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			count = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[i] % A[j] != 0) {
					count++;
				}
			}
			nonDiv[i] = count;
		}

		return nonDiv;
	}
}
