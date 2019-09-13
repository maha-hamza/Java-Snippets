package Codility;

public class FrogJump {

	public static void main(String[] args) throws Exception {
		int A = 10;
		int B = 85;
		int D = 30;
		System.out.println(solution(A, B, D));
	}

	private static int solution(int a, int b, int d) throws Exception {
		if (b < a) {
			throw new Exception("b can't be less than a");
		}

		return (int) Math.ceil(((double) b - a) / d);
	}
}
