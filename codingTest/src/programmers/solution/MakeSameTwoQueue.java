package programmers.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * - https://school.programmers.co.kr/learn/courses/30/lessons/118667
 * - 참고 풀이 : https://maicoding.tistory.com/66
 * - 투포인터, 그리디 두 가지 방식으로 풀수있지만 그리디 방식이 좀 더 알기 쉽다.
 * 합이 더 큰 큐에서 반대편 큐로 옮기는 방식이 핵심이고, 원상태로 돌아가기 전까지 반복하는 것이기 때문에 반복 횟수 주의!
 */
public class MakeSameTwoQueue {
    public static void main(String[] args) {
        MakeSameTwoQueue m = new MakeSameTwoQueue();
        System.out.println(m.solution(new int[] {3,2,7,2}, new int[] {4,6,5,1}));
        System.out.println(m.solution(new int[] {1,2,1,2}, new int[] {1,10,1,2}));
        System.out.println(m.solution(new int[] {1,1}, new int[] {1,5}));
    }

    // 첫번째 풀이
//    public int solution(int[] queue1, int[] queue2) {
//        int count = 0;
//        long q1Sum = 0, q2Sum = 0;
//
//        Queue<Integer> q1 = new LinkedList<>();
//        Queue<Integer> q2 = new LinkedList<>();
//
//        for (int element : queue1) {
//            q1Sum += element;
//            q1.offer(element);
//        }
//
//        for (int element : queue2) {
//            q2Sum += element;
//            q2.offer(element);
//        }
//
//        while (count < queue1.length*4) {
//            if (q1Sum == q2Sum) {
//                break;
//            } else if (q1Sum > q2Sum) {
//                int q1Element = q1.poll();
//                q2.offer(q1Element);
//                q1Sum -= q1Element;
//                q2Sum += q1Element;
//            } else {
//                int q2Element = q2.poll();
//                q1.offer(q2Element);
//                q1Sum += q2Element;
//                q2Sum -= q2Element;
//            }
//            count++;
//        }
//
//        if (q1Sum != q2Sum) {
//            return -1;
//        }
//
//        return count;
//    }

    // 두번째 풀이
    public int solution(int[] queue1, int[] queue2) {
        long queueSum1 = 0, queueSum2 = 0;
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        int answer = 0;

        for (int i=0; i<queue1.length; i++) {
            queueSum1 += queue1[i];
            queueSum2 += queue2[i];

            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        if (queueSum1 == queueSum2) {
            return answer;
        }

        for (int i=0; i<queue1.length*4; i++) {
            if (queueSum1 == queueSum2) {
                return answer;
            } else if (queueSum1 < queueSum2) {
                int qElement2 = q2.poll();
                q1.add(qElement2);
                queueSum1 += qElement2;
                queueSum2 -= qElement2;
            } else {
                int qElement1 = q1.poll();
                q2.add(qElement1);
                queueSum1 -= qElement1;
                queueSum2 += qElement1;
            }

            answer++;
        }

        return -1;
    }
}
