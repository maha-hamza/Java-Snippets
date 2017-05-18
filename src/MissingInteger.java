import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 3, 6, 4, 1, 2, 5, 9 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		// sort and remove duplication
		int[] AN = Arrays.stream(A).distinct().sorted().toArray();

		for (int i = 0; i < AN.length; i++) {
			if (i > 0 && !(AN[i] == AN[i - 1] + 1)) {
				return (AN[i] + AN[i - 1]) / 2;
			}
		}

		return -1;
	}
}
