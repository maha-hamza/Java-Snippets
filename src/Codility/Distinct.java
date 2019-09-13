package Codility;

import java.util.Arrays;

public class Distinct {
	public static void main(String[] args) {
		int[] A = new int[] { 2, 1, 1, 2, 3, 1 ,4,4,7};
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		return (int) Arrays.stream(A).distinct().count();
	}
}
