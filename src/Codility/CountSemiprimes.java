package Codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
/**
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
 * You are given two non-empty zero-indexed arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.
 * Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
 * For example, consider an integer N = 26 and arrays P, Q such that:
 *     P[0] = 1    Q[0] = 26
 *     P[1] = 4    Q[1] = 10
 *     P[2] = 16   Q[2] = 20
 * The number of semiprimes within each of these ranges is as follows:
 * (1, 26) is 10,
 * (4, 10) is 4,
 * (16, 20) is 0.
 * Write a function:
 * class Solution { public int[] solution(int N, int[] P, int[] Q); }
 * that, given an integer N and two non-empty zero-indexed arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.
 * For example, given an integer N = 26 and arrays P, Q such that:
 *     P[0] = 1    Q[0] = 26
 *     P[1] = 4    Q[1] = 10
 *     P[2] = 16   Q[2] = 20
 * the function should return the values [10, 4, 0], as explained above.
 * Assume that:
 * N is an integer within the range [1..50,000];
 * M is an integer within the range [1..30,000];
 * each element of arrays P, Q is an integer within the range [1..N];
 * P[i] ≤ Q[i].
 * Complexity:
 * expected worst-case time complexity is O(N*log(log(N))+M);
 * expected worst-case space complexity is O(N+M), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
*/
public class CountSemiprimes {
	public static void main(String[] args) {
		int[] A = new int[] { 1, 4, 16 };
		int[] B = new int[] { 26, 10, 20 };
		int N = 26;
		System.out.println(Arrays.toString(solution(A, B, N)));

	}

	public static int[] solution(int[] A, int[] B, int N) {
		int[] semiPrimesCount = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			int el1 = A[i];
			int el2 = B[i];
			semiPrimesCount[i] = findSemiPrimInRange(el1, el2, N);
		}

		return semiPrimesCount;
	}

	public static int findSemiPrimInRange(int A, int B, int N) {

		int semi = 0;

		for (int i = A; i <= B; i++) {
			if (isSemiPrime(i, N))
				semi++;
		}

		return semi;
	}

	public static boolean isSemiPrime(int num, int N) {

		List<Integer> semi = getSemiPrimes(N);

		return semi.contains(num);
	}

	public static List<Integer> getSemiPrimes(int N) {
		List<Integer> semiPrimes = new ArrayList<>();

		List<Integer> primes = getPrimes(N);

		for (Integer integer : primes) {
			for (Integer integer2 : primes) {
				semiPrimes.add(integer2 * integer);
			}
		}

		return semiPrimes;
	}

	public static List<Integer> getPrimes(int N) {
		return IntStream.rangeClosed(2, N).parallel()
				.map(i -> IntStream.rangeClosed(2, (int) (Math.sqrt(i))).filter(j -> i / j * j == i).map(j -> 0)
						.findAny().orElse(i))
				.filter(i -> i != 0).mapToObj(i -> Integer.valueOf(i)).collect(Collectors.toList());
	}
}
