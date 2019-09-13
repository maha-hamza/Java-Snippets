package Codility;

import java.util.stream.IntStream;

public class AbsDistinct {

	public static void main(String[] args) {
		int[] A = { -5, -3, -1, 0, 3, 6 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {

		return (int) IntStream.of(A).map(e -> Math.abs(e)).distinct().count();
	}
}
