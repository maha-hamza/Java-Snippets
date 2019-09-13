package Codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
