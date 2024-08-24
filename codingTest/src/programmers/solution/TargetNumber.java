package programmers.solution;

import java.util.Arrays;

/**
 * - https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */

// 첫번째 풀이
//public class TargetNumber {
//    private static int answer = 0;
//
//    public static void main(String[] args) {
//        TargetNumber t = new TargetNumber();
//        System.out.println(t.solution(new int[] {1,1,1,1,1}, 3));
////        System.out.println(t.solution(new int[] {4, 1, 2, 1}, 4));
//    }
//
//    public int solution(int[] numbers, int target) {
//        dfs(numbers, target, 0);
//        return answer;
//    }
//
//    private void dfs(int[] numbers, int target, int start) {
//        if (numbers.length == start) {
//            if (Arrays.stream(numbers).sum() == target) {
//                answer++;
//            }
//            return;
//        }
//
//        dfs(numbers, target, start+1);
//        numbers[start] *= -1;
//        dfs(numbers, target, start+1);
//    }
//}

// 두번째 풀이
public class TargetNumber {
    public static void main(String[] args) {
        TargetNumber t = new TargetNumber();
        System.out.println(t.solution(new int[] {1,1,1,1,1}, 3));
        System.out.println(t.solution(new int[] {4,1,2,1}, 4));
    }

    public int solution(int[] numbers, int target) {
        int[] answer = new int[] {0};
        dfs(numbers, 0, 0, target, answer);
        return answer[0];
    }
    private void dfs(int[] numbers, int idx, int sum, int target, int[] answer) {
        if (numbers.length <= idx) {
            if (sum == target) {
                answer[0]++;
            }
            return;
        }
        dfs(numbers, idx+1, sum+numbers[idx], target, answer);
        dfs(numbers, idx+1, sum-numbers[idx], target, answer);
    }
}
