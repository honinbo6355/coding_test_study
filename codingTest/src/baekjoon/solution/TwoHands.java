package baekjoon.solution;

import java.util.Scanner;

/*
- SPR : 가위(0) 보(1) 바위(2)
- 낸것들의 인덱스 값을 구한다.
- +2%3한 값이 이길 수 있는 상황이다.
- 예를 들어 (0(가위)+2)%3 = 2(바위)
- 이길 수 있는 상황은 상대방이 왼손과 오른손을 똑같은 걸 냈고 && 내가 왼손과 오른손 중 이길 수 있는걸 냈을 경우이다.
 */
public class TwoHands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] stArr = sc.nextLine().split(" ");
        int[] arr = new int[stArr.length];

        for (int i=0; i<arr.length; i++) {
            arr[i] = "SPR".indexOf(stArr[i]);
        }

        if (arr[0] == arr[1] && ((arr[0]+2)%3 == arr[2] || (arr[0]+2)%3 == arr[3])) {
            System.out.println("TK");
        } else if (arr[2] == arr[3] && ((arr[2]+2)%3 == arr[0] || (arr[2]+2)%3 == arr[1])) {
            System.out.println("MS");
        } else {
            System.out.println("?");
        }
    }
}
