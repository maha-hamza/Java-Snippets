package Codility;

public class FrogRiverOne {
	public static void main(String[] args) {
		int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 };
		int X = 5;
		System.out.println(solution(A, X));
	}

	public static int solution(int[] A, int X) {

		if (X > A.length) {
			return -1;
		}

		int[] isFilled = new int[X];
		int position = 0;
		for (int i = 0; i < A.length; i++) {
			int x = A[i];
			if (x <= X) {
				if (isFilled[x - 1] == 0) {
					isFilled[x - 1] = 1;
					position += 1;
					if (position == X) {
						return i;
					}
				}
			}
		}

		return -1;
	}
}
