package baekjoon.solution;

import java.util.*;

/*
    중복 제거, 정렬 필요한 경우이므로 TreeSet 자료구조를 생각해내는게 관건.
 */
public class DictionarySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Set<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return Integer.compare(o1.length(), o2.length());
                }

                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i<N; i++) {
            treeSet.add(sc.nextLine());
        }

        for (String str : treeSet) {
            System.out.println(str);
        }
    }
}
