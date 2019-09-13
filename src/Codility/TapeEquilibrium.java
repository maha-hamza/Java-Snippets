package Codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TapeEquilibrium {

	public static int solution(int[] array) {
		List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
		int leftSum = 0;
		int rightSum = 0;
		List<Integer> ints = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				leftSum = list.get(0);
				rightSum = Arrays.stream(Arrays.copyOfRange(array, 1, list.size())).sum();
			} else if (i != array.length - 1) {
				leftSum = Arrays.stream(Arrays.copyOfRange(array, 0, i + 1)).sum();
				rightSum = Arrays.stream(Arrays.copyOfRange(array, i + 1, list.size())).sum();
			}
			if (i != array.length - 1 || i == 0)
				ints.add(Math.abs(leftSum - rightSum));

		}

		Collections.sort(ints);
		return ints.get(0);
	}

	public static int solution2(int[] A) {
		int expectedMinimum = Integer.MAX_VALUE;
		int tmp = 0;
		int sum = 0;

		sum = Arrays.stream(A, 0, A.length).sum();

		for (int i = 0; i < A.length - 1; i++) {
			tmp += A[i];
			expectedMinimum = Math.min(expectedMinimum, Math.abs(tmp - (sum - tmp)));
		}
		return expectedMinimum;
	}

	public static void main(String[] args) {
		int[] array = { 3, 1, 2, 4, 3 };
		System.out.println(solution(array));
		System.out.println(solution2(array));

	}
}
