package programmers.solution;

import java.util.*;
import java.util.stream.Collectors;

/**
 * - https://school.programmers.co.kr/learn/courses/30/lessons/64065
 */
public class Tuple {
    public static void main(String[] args) {
        Tuple t = new Tuple();
        System.out.println(Arrays.toString(t.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
    }

    public int[] solution(String s) {
        // 각 원소의 등장 횟수를 세기 위해 Map으로 변환
        Map<String, Long> frequencyMap = Arrays.stream(s.split("[{},]+"))
                .filter(element -> !"".equals(element))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // 등장 횟수가 높은 순서대로 정렬된 List 생성
        List<Map.Entry<String, Long>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        return sortedEntries.stream()
                .mapToInt(entry -> Integer.parseInt(entry.getKey()))
                .toArray();
    }
}

