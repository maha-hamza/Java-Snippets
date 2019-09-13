package Codility;

import java.util.HashSet;

public class OddOccurrencesInArray {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 9, 3, 9, 3, 9, 7, 9, 7, 7, 1, 1, 4 }));

	}

	public static int solution(int[] A) {

		HashSet<Integer> set = new HashSet<Integer>(A.length / 2);

		for (int i = 0; i < A.length; i++) {
			if (set.contains(A[i])) {
				set.remove(A[i]);
			} else {
				set.add(A[i]);
			}
		}

		return (int) set.toArray()[0];
	}

}
