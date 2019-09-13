package Codility;

public class TieRope {
	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 4, 1, 1, 3 };
		int K = 4;

		System.out.println(solution(A, K));
	}

	public static int solution(int[] A, int K) {
		int numOfRopes = 0;
		int ropeLengthCounter = 0;
		for (Integer a : A) {
			ropeLengthCounter += a;
			if (ropeLengthCounter >= K) {
				numOfRopes++;
				ropeLengthCounter = 0;
			}
		}
		System.out.println();
		return numOfRopes;
	}
}
