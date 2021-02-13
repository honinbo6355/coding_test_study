package programmers.answer;

import java.util.Arrays;

// 풀이 출처
// https://doodreamcode.tistory.com/134

public class BrokenBulloons_Answer {
	public int solution(int[] a) {
        int count = 0;

        // 가장 작은 값 초기화
        int minValue = Integer.MAX_VALUE;
        // 선택된 풍선이 i 번째 일때 해당 풍선의 왼쪽의 그룹의 에서의 최솟값은 leftMin[i]
        int[] leftMin = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (minValue > a[i]) {
            		minValue = a[i];
            }
            leftMin[i] = minValue;
        }
        
        System.out.println("leftMin : " + Arrays.toString(leftMin));

        // 선택된 풍선이 i 번째 일때 해당 풍선의 오른쪽의 그룹의 에서의 최솟값은 rightMin[i]
        minValue = Integer.MAX_VALUE;
        int[] rightMin = new int[a.length];
        for (int j = a.length - 1; j >= 0 ; j--) {
            if (minValue > a[j]) {
            		minValue = a[j];
            }
            rightMin[j] = minValue;
        }
        
        System.out.println("rightMin : " + Arrays.toString(rightMin));

        System.out.println("a : " + Arrays.toString(a));
        
        for (int i = 0; i < a.length; i++) {
            // 왼쪽과 오른쪽 그룹의 최솟값 보다 크다면 넘어간다. // 최후 까지 남겨지지 못함
            if(a[i] > rightMin[i] && a[i] > leftMin[i])  {
            		continue;
            }
            // 나머지는 추가
            else {
            		count++;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		BrokenBulloons_Answer b = new BrokenBulloons_Answer();
		int[] a = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};
        System.out.println(b.solution(a));
	}
}
