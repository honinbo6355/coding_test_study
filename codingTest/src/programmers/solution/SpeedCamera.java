package programmers.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * - https://velog.io/@ahnick/programmers-%EB%8B%A8%EC%86%8D%EC%B9%B4%EB%A9%94%EB%9D%BC
 * - https://school.programmers.co.kr/learn/courses/30/lessons/42884
 * - 그리디 문제
 */
public class SpeedCamera {
    public static void main(String[] args) {
        SpeedCamera s = new SpeedCamera();
        System.out.println(s.solution(new int[][] {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
    }

    public int solution(int[][] routes) {
        int answer = 0;

        // 진출 지점을 기준으로 오름차순 정렬 하는게 핵심이다.
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int cam = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (cam < route[0]) { // 설치한 카메라 위치보다 진출 지점이 더 큰 경로(겹치지 않는 곳)는 새로운 카메라를 설치해줘야 한다.
                cam = route[1];
                answer++;
            }
        }
        return answer;
    }
}
