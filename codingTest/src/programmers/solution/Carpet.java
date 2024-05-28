package programmers.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 참고 링크 : https://easybrother0103.tistory.com/110
public class Carpet {
    public static void main(String[] args) {
        Carpet c = new Carpet();
        System.out.println(Arrays.toString(c.solution(10, 2)));
        System.out.println(Arrays.toString(c.solution(8, 1)));
        System.out.println(Arrays.toString(c.solution(24, 24)));
    }

    // 풀이1
//    public int[] solution(int brown, int yellow) {
//        List<Integer[]> caseList = new ArrayList<>();
//
//        for (int i=1; i<=yellow; i++) {
//            if (yellow % i == 0) {
//                if (i < yellow/i) {
//                    continue;
//                }
//                Integer[] caseArrElem = new Integer[2];
//
//                caseArrElem[0] = i;
//                caseArrElem[1] = yellow/i;
//
//                caseList.add(caseArrElem);
//            }
//        }
//
//        for (Integer[] elem : caseList) {
//            if ((2*elem[0] + 2*elem[1] + 4) == brown) {
//                return new int[] {elem[0]+2, elem[1]+2};
//            }
//        }
//
//        return new int[2];
//    }

    // 풀이2
    public int[] solution(int brown, int yellow) {
        int sum = brown+yellow;

        for (int height=1; height<=sum/height; height++) {
            if (sum%height!=0) {
                continue;
            }
            int width = sum/height;

            if ((width-2) * (height-2) == yellow) {
                return new int[] {width, height};
            }
        }

        return null;
    }
}
