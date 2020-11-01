package baekjoon.solution;

import java.util.Scanner;

public class ReverseNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		// 1 => 0 으로 뒤집었을 때 갯수, 0 => 1 으로 뒤집었을 때 갯수
		int oneToZeroCnt = 0, zeroToOneCnt = 0;
		
		if (str.charAt(0) == '0') {
			zeroToOneCnt++;
		} else {
			oneToZeroCnt++;
		}
		
		for (int i=1; i<str.length(); i++) {
			// 두 방법의 횟수를 각각 count
			if (str.charAt(i-1) != str.charAt(i)) {
				if (str.charAt(i) == '0') {
					zeroToOneCnt++;
				} else {
					oneToZeroCnt++;
				}
			}
		}
		
		// 두 방법 중 최소 횟수 구하기
		System.out.println(Math.min(oneToZeroCnt, zeroToOneCnt));
	}
}
