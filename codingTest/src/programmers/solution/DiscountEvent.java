package programmers.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * - https://school.programmers.co.kr/learn/courses/30/lessons/131127
 * - 슬라이딩 윈도우를 활용한 문제
 */
public class DiscountEvent {
    public static void main(String[] args) {
        DiscountEvent d = new DiscountEvent();
        System.out.println(d.solution(
                new String[] {"banana", "apple", "rice", "pork", "pot"},
                new int[] {3, 2, 2, 2, 1},
                new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}
        ));
        System.out.println(d.solution(
                new String[] {"banana", "apple", "rice", "pork", "pot"},
                new int[] {3, 2, 2, 2, 1},
                new String[] {"apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana", "chicken", "apple"}
        ));
        System.out.println(d.solution(
                new String[] {"apple"},
                new int[] {10},
                new String[] {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}
        ));
    }

    // 첫번째 풀이
//    public int solution(String[] want, int[] number, String[] discount) {
//        Map<String, Integer> wantNumberMap = new HashMap<>();
//        Map<String, Integer> discountMap = new HashMap<>();
//        int answer = 0;
//        for (int i=0; i<number.length; i++) {
//            wantNumberMap.put(want[i], number[i]);
//        }
//
//        // 초기 10일간의 할인 상품을 카운트
//        for (int i=0; i<10 && i<discount.length; i++) {
//            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0)+1);
//        }
//        if (isAvailable(wantNumberMap, discountMap)) {
//            answer++;
//        }
//
//        // 슬라이딩 윈도우를 사용하여 계산
//        for (int i=10; i<discount.length; i++) {
//            // 윈도우를 한 칸 이동 (앞의 요소 제거, 뒤에 요소 추가)
//            String removeItem = discount[i-10];
//            discountMap.put(removeItem, discountMap.get(removeItem)-1);
//            String addItem = discount[i];
//            discountMap.put(addItem, discountMap.getOrDefault(addItem, 0)+1);
//            if (isAvailable(wantNumberMap, discountMap)) {
//                answer++;
//            }
//        }
//        return answer;
//    }
//
//    private boolean isAvailable(Map<String, Integer> wantNumberMap, Map<String, Integer> discountMap) {
//        for (Map.Entry<String, Integer> entry : wantNumberMap.entrySet()) {
//            if (discountMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
//                return false;
//            }
//        }
//        return true;
//    }

    // 두번째 풀이
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;

        for (int i=0; i<10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0)+1);
            if (checkWant(want, number, map)) {
                answer++;
            }
        }
        for (int i=10; i<discount.length; i++) {
            map.put(discount[i-10], map.get(discount[i-10])-1);
            map.put(discount[i], map.getOrDefault(discount[i], 0)+1);
            if (checkWant(want, number, map)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean checkWant(String[] want, int[] number, Map<String, Integer> map) {
        for (int j=0; j<want.length; j++) {
            Integer count = map.get(want[j]);
            if (count == null || count < number[j]) {
                return false;
            }
        }

        return true;
    }
}
