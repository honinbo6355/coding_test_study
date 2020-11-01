package baekjoon.answer;

import java.util.Scanner;

public class ReverseNumber_Answer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strArr = str.split("");

		// 1 => 0 으로 뒤집었을 때 갯수, 0 => 1 으로 뒤집었을 때 갯수
		int oneToZeroCnt = 0, zeroToOneCnt = 0;
		
		if (strArr[0].equals("0")) {
			zeroToOneCnt++;
		} else {
			oneToZeroCnt++;
		}
		
		for (int i=1; i<strArr.length; i++) {
			// 두 방법의 횟수를 각각 count
			if (!strArr[i-1].equals(strArr[i])) {
				if (strArr[i].equals("0")) {
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
