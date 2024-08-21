package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * - https://leetcode.com/problems/longest-increasing-subsequence/description/
 * - 이진 탐색 문제
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        System.out.println(l.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        System.out.println(l.lengthOfLIS(new int[] {0,1,0,3,2,3}));
        System.out.println(l.lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
    }

    public int lengthOfLIS(int[] nums) {
        // 정렬된 결과 리스트를 대상으로 이진 탐색을 하는 전략이다.
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (list.isEmpty() || list.get(list.size()-1) < num) {
                list.add(num);
            } else {
                int idx = binarySearch(list, num);
                list.set(idx, num);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size()-1;

        while (left <= right) {
            int mid = (left+right) / 2;
            if (list.get(mid) == target) {
                return mid; // 기존 요소에 덮어쓰기
            } else if (list.get(mid) > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left; // list의 가장 마지막 인덱스값 반환됨. 결국 최대값이 교체되는 경우이다.
    }
}
