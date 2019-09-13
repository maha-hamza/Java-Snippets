package Codility;

public class PassingCars {
	public static void main(String[] args) {
		int[] A = new int[] { 0, 1, 0, 1, 1 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int res = 0;
		int ones = 0;

		for (int i = A.length - 1; i >= 0; i--) {

			if (A[i] == 1)
				ones++;
			else {
				res += ones;
			}

			if (res > 1000000000)
				return -1;
		}
		return res;
	}
}
