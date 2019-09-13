package Codility;

import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {
		int[] A = new int[] { 1,1,4,2,3,5,9 };
		int[] B = new int[] { 1,2,3 };
		int[] C = new int[] { -1,-3 };
		int[] D = new int[] { 10021,58541,99999 };
		System.out.println(solution(A)); // expected 6
		System.out.println(solution(B)); // expected 4
		System.out.println(solution(C)); // expected 1
		System.out.println(solution(D)); // expected 1
	}

	public static int solution(int[] A) {
		// sort and remove duplication
		int[] AN = Arrays.stream(A).filter(n -> n > 0).distinct().sorted().toArray();
        	int N = AN.length;
        	int MIN = 1;
        
		for (int i = 0; i < N; i++) {
		    MIN = i+1;
		    if (AN[i] != MIN) {
		        return MIN;
		    } 
		    else if (MIN == N) {
		        return ++MIN;
		    }
		}
		return MIN;
	}
}
