package baekjoon.solution;

import java.util.*;

public class BalanceWorld {
    private Stack<Character> stack = new Stack<>();

    public static Map<Character, Character> bracketMap;
    public static Scanner sc;
    public static StringBuffer sb;

    static {
        bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');

        sc = new Scanner(System.in);

        sb = new StringBuffer();
    }

    public static void main(String[] args) {
        BalanceWorld balanceWorld = new BalanceWorld();
        balanceWorld.start();
    }

    private void start() {
        while (true) {
            String str = sc.nextLine();
            if (str.charAt(0) == '.') {
                break;
            }
            sb.append(isCheckBalance(str)).append("\n");
            stack.clear();
        }

        System.out.println(sb);
    }

    private String isCheckBalance(String str) {
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '(' :
                case '[' :
                    stack.push(ch);
                    break;
                case ')' :
                case ']' :
                    if (stack.isEmpty()) {
                        return "no";
                    }

                    if (stack.peek() == bracketMap.get(ch)) {
                        stack.pop();
                        break;
                    } else {
                        return "no";
                    }
            }
        }

        // 검사 후 stack이 비어있으면 yes, 아니면 no
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}

