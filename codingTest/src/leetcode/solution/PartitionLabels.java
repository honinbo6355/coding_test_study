package leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 풀이 참고 링크 https://bcp0109.tistory.com/205

public class PartitionLabels {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));
    }

    public static List<Integer> partitionLabels(String S) {
        int[] lastIndexes = new int[26]; // 총 알파벳 갯수만큼 배열 공간 생성
        List<Integer> result = new ArrayList<>();

        // 각 알파벳의 마지막 index 값을 구하는 작업.
        // char 타입값을 index 형태로 담을 때 많이 사용하는 방법
        for (int i=0; i<S.length(); i++) {
            lastIndexes[S.charAt(i)-'a'] = i;
        }
        int partLastIndex = 0;
        int start = 0;

        for (int i=0; i<S.length(); i++) {
            partLastIndex = Math.max(partLastIndex, lastIndexes[S.charAt(i)-'a']);

            // i == partLastIndex 이면 중복없는 partition
            if (i == partLastIndex) {
                result.add(partLastIndex-start+1);
                start = i+1; // 다음 partition의 start를 위한 update
            }
        }

        return result;
    }
}

