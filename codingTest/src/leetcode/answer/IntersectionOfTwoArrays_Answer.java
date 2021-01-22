package leetcode.answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays_Answer {
	/**
	 * 동일한 값의 원소를 전부 리턴하는 문제.
	 * 정렬이 되어 있지 않을 경우이므로, hashmap 이용.
	 * 결과값 순서는 상관없다.
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>(); // <number, count>
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            map.merge(num, 1, Integer::sum); // 원소별 갯수를 구한다
        }
        
        for (int num : nums2) {
        		int count = map.getOrDefault(num, 0);
        		if (count > 0) {
        			list.add(num);
        			map.put(num, count-1);
        		}
        }
        
        return list.stream().mapToInt(k -> k).toArray();
	}
	
	// 두 배열이 정렬된 상태면 two pointer를 이용해서 최적화 시킬 수 있다.
	public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return list.stream().mapToInt(k -> k).toArray();
    }
	
	public static void main(String[] args) {
		IntersectionOfTwoArrays_Answer intersectionOfTwoArrays_Answer = new IntersectionOfTwoArrays_Answer();
		
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		
		System.out.println(Arrays.toString(intersectionOfTwoArrays_Answer.intersect(nums1, nums2)));
	}
}
