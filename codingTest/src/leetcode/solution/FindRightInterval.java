package leetcode.solution;

import java.util.*;

/**
 * - https://leetcode.com/problems/find-right-interval/description/
 * - 이진 탐색 문제
 */
public class FindRightInterval {
    public static void main(String[] args) {
        FindRightInterval f = new FindRightInterval();
        System.out.println(Arrays.toString(f.findRightInterval(new int[][] {{1,2}})));
        System.out.println(Arrays.toString(f.findRightInterval(new int[][] {{3,4},{2,3},{1,2}})));
        System.out.println(Arrays.toString(f.findRightInterval(new int[][] {{1,4},{2,3},{3,4}})));
        System.out.println(Arrays.toString(f.findRightInterval(new int[][] {{4,5},{2,3},{1,2}})));
    }

    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByKey());

        int[] answer = new int[intervals.length];

        for (int i=0; i<intervals.length; i++) {
            int targetVal = intervals[i][1];
            int idx = binarySearch(entryList, targetVal);
            answer[i] = idx;
        }
        return answer;
    }
    private int binarySearch(List<Map.Entry<Integer, Integer>> entryList, int targetVal) {
        int start=0;
        int end=entryList.size()-1;
        int result=-1;

        while (start<=end) {
            int mid = (start+end)/2;
            int compareVal = entryList.get(mid).getKey();
            if (compareVal >= targetVal) {
                result = entryList.get(mid).getValue(); // 결과 저장
                end = mid-1; // 더 작은 값을 찾기 위해 end 줄이기
            } else {
                start = mid+1;
            }
        }
        return result;
    }
}
