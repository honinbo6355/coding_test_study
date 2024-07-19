package baekjoon.solution;

import java.util.*;

/**
 * - https://www.acmicpc.net/problem/7490
 * - 풀이 참고 : https://loosie.tistory.com/765
 */
public class MakeZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<count; i++) {
            List<String> result = new ArrayList<>();
            recursive(result, "1", sc.nextInt(), 1);
            Collections.sort(result);

            for (String str : result) {
                sb.append(str).append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void recursive(List<String> result, String str, int N, int start) {
        if (N == start) {
            if (calculate(str) == 0) {
                result.add(str);
            }
            return;
        }
        recursive(result, str+"+"+(start+1), N, start+1);
        recursive(result, str+"-"+(start+1), N, start+1);
        recursive(result, str+" "+(start+1), N, start+1);
    }

    private static int calculate(String str) {
        StringTokenizer st = new StringTokenizer(str, "+-", true);
        int sum = 0;
        if (st.hasMoreTokens()) {
            sum = Integer.parseInt(st.nextToken().replaceAll(" ", ""));
        }
        String delimiter = null;
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("+") || token.equals("-")) {
                delimiter = token;
                continue;
            }
            if (delimiter.equals("+")) {
                sum += Integer.parseInt(token.replaceAll(" ", ""));
            } else if (delimiter.equals("-")) {
                sum -= Integer.parseInt(token.replaceAll(" ", ""));
            }
        }
        return sum;
    }
}
