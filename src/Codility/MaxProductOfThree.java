package Codility;

import java.util.Arrays;

/**
A non-empty zero-indexed array A consisting of N integers is given.

The problem is to find the maximum product of 3 elements from given array.

The length of the array is between 3 and 100,000

each element of array A is an integer within the range [−1,000..1,000]

    expected worst-case time complexity is O(N*log(N));

    expected worst-case space complexity is O(1), 
beyond input storage (not counting the storage required for input arguments). Example:

  a[0] = -3;
  a[1] = 7;
  a[2] = 2;
  a[3] = 1;
  a[4] = 5;
  a[5] = 7;
the max product is a[1]*a[4]*a[5] = 245
*/
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
