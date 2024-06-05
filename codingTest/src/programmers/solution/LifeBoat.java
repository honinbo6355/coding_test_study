package programmers.solution;

/**
 * - https://school.programmers.co.kr/learn/courses/30/lessons/42885
 */

import java.util.Arrays;

public class LifeBoat {
    public static void main(String[] args) {
        LifeBoat l = new LifeBoat();
        System.out.println(l.solution(new int[] {70,50,80,50}, 100));
        System.out.println(l.solution(new int[] {70,80,50}, 100));
        System.out.println(l.solution(new int[] {10,5,8,3}, 15));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;

        while (left < right) {
            if (people[left]+people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }

        if (left == right) {
            return answer+1;
        }
        return answer;
    }
}
