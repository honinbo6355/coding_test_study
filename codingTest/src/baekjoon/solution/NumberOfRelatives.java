package baekjoon.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRelatives {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] stArr = br.readLine().split(" ");
        int num1 = Integer.parseInt(stArr[0]), num2 = Integer.parseInt(stArr[1]);
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n+1];
        boolean[] isVisited = new boolean[n+1];

        for (int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            String[] relation = br.readLine().split(" ");
            int parent = Integer.parseInt(relation[0]);
            int child = Integer.parseInt(relation[1]);

            list[parent].add(child);
            list[child].add(parent);
        }

        Queue<Person> queue = new LinkedList<>();
        queue.offer(new Person(num1, 0));
        isVisited[num1] = true;

        while (!queue.isEmpty()) {
            Person person = queue.poll();

            if (person.num == num2) {
                System.out.println(person.count);
                return;
            }

            for (int e : list[person.num]) {
                if (!isVisited[e]) {
                    queue.offer(new Person(e, person.count+1));
                    isVisited[e] = true;
                }
            }
        }

        System.out.println(-1);
    }
}

class Person {
    int num;
    int count;

    Person(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

