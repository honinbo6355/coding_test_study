package programmers.solution;

/**
 * - https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */

// 풀이1
// import java.io.IOException;
// import java.util.*;
//
//public class SearchPrime {
//     int count = 0;
//
//    public static void main(String[] args) {
//        SearchPrime s = new SearchPrime();
//        System.out.println(s.solution("17"));
//    }
//     public int solution(String numbers) {
//         List<Character> list = new ArrayList<>();
//         boolean[] visited = new boolean[numbers.length()];
//
//         char[] chars = numbers.toCharArray();
//         Arrays.sort(chars);
//         numbers = new String(chars);
//         permutation(numbers, list, visited);
//
//         return count;
//     }
//
//     public void permutation(String numbers, List<Character> list, boolean[] visited) {
//         if (!list.isEmpty() && list.get(0) == '0') {
//             return;
//         }
//
//         if (isPrime(parseToInt(list))) {
//             count++;
//         }
//
//         if (list.size() == numbers.length()) {
//             return;
//         }
//
//         for (int i=0; i<numbers.length(); i++) {
//             if (i > 0 && numbers.charAt(i) == numbers.charAt(i-1) && !visited[i-1]) {
//                 continue;
//             }
//
//             if (!visited[i]) {
//                 visited[i] = true;
//                 list.add(numbers.charAt(i));
//                 permutation(numbers, list, visited);
//                 visited[i] = false;
//                 list.remove(list.size()-1);
//             }
//         }
//     }
//
//     private boolean isPrime(int number) {
//         if (number <= 1) {
//             return false;
//         }
//
//         for (int i=2; i<number; i++) {
//             if (number % i == 0) {
//                 return false;
//             }
//         }
//
//         return true;
//     }
//
//     private int parseToInt(List<Character> list) {
//         if (list.size() == 0) {
//             return 0;
//         }
//
//         StringBuilder sb = new StringBuilder();
//
//         for (char ch : list) {
//             sb.append(ch);
//         }
//
//         return Integer.parseInt(sb.toString());
//     }
// }

// 풀이2
import java.util.*;

public class SearchPrime {
    private static int answer = 0;

    public static void main(String[] args) {
        SearchPrime s = new SearchPrime();
        System.out.println(s.solution("17"));
    }

    public int solution(String numbers) {
        String[] arr = numbers.split("");
        boolean[] isVisited = new boolean[arr.length];
        List<String> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i=1; i<=arr.length; i++) {
            subset(arr, list, set, isVisited, i);
        }

        return answer;
    }

    private void subset(String[] arr, List<String> list, Set<Integer> set, boolean[] isVisited, int count) {
        if (list.size() == count) {
            if (list.get(0).equals("0")) {
                return;
            }

            int value = convertToInt(list);
            if (set.contains(value)) {
                return;
            }
            if (isPrime(value)) {
                set.add(value);
                answer++;
                return;
            }
        }
        for (int i=0; i<arr.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                list.add(arr[i]);
                subset(arr, list, set, isVisited, count);
                list.remove(list.size()-1);
                isVisited[i] = false;
            }
        }
    }

    private int convertToInt(List<String> list) {
        StringBuffer sb = new StringBuffer();
        list.stream().forEach(i -> sb.append(i));
        return Integer.parseInt(sb.toString());
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i=2; i<num; i++) {
            if (num%i==0) {
                return false;
            }
        }
        return true;
    }
}



