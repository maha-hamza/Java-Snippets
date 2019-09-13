package Codility;

import java.util.Arrays;

public class PermCheck {
	public static void main(String[] args) {
		int[] A = new int[] { 4, 1, 3 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {
			if (i > 0 && !(A[i] == A[i - 1] + 1)) {
				return 0;
			}
		}

		return 1;
	}
}
