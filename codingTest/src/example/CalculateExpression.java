package example;

import java.util.Stack;

/**
 * - 계산식에 하나의 괄호쌍을 넣어서 최대값 구하기
 */
public class CalculateExpression {
    public static void main(String[] args) {
        CalculateExpression c = new CalculateExpression();
        String expression = "2-1X5-4X3+2";
//        long result = s.calculate(expression);
        long result = c.solution(expression);
        System.out.println("Result: " + result); // 계산 결과 출력
    }

    // expression 계산값을 구하는 메소드
    public long calculate(String expression) {
        // 곱셈 먼저 처리하기 위해 X를 *로 대체
        expression = expression.replace("X", "*");

        // '+'와 '-'를 기준으로 부분 문자열 나누기
        String[] additionSubtractionParts = expression.split("(?=[+-])");
        int result = 0;

        for (String part : additionSubtractionParts) {
            if (part.contains("*")) { // 곱셈이 포함된 경우
                String[] multiplicationParts = part.split("\\*");
                int product = 1;
                for (String num : multiplicationParts) {
                    product *= Integer.parseInt(num);
                }
                result += product; // 곱셈 결과를 더하거나 빼기
            } else {
                result += Integer.parseInt(part);
            }
        }
        return result;
    }

    // expression에 하나의 괄호쌍을 넣어서 최대값을 얻는 메소드
    public long solution(String expression) {
        long maxResult = Long.MIN_VALUE;

        // 가능한 모든 괄호 쌍을 시도
        for (int i = 0; i < expression.length(); i++) {
            for (int j = i + 1; j < expression.length(); j++) {
                // 괄호가 숫자 사이에만 위치하도록 함
                if (Character.isDigit(expression.charAt(i)) && Character.isDigit(expression.charAt(j))) {
                    String newExpression = expression.substring(0, i) + "("
                            + expression.substring(i, j + 1) + ")"
                            + expression.substring(j + 1);
                    maxResult = Math.max(maxResult, evaluateExpression(newExpression));
                }
            }
        }

        return maxResult;
    }

    public long evaluateExpression(String expression) {
        Stack<Long> numbers = new Stack<>();
        long num = 0;
        char sign = '+';
        int n = expression.length();

        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                // 123인 경우를 위해 num * 10이 필요함.
                // ex)
                // num = 0 * 10 + 1 = 1
                // num = 1 * 10 + 2 = 12
                // num = 12 * 10 + 3 = 123
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                int j = i, brackets = 0;
                while (i < n) {
                    if (expression.charAt(i) == '(') brackets++;
                    if (expression.charAt(i) == ')') brackets--;
                    if (brackets == 0) break;
                    i++;
                }
                num = evaluateExpression(expression.substring(j + 1, i));
            }

            if (!Character.isDigit(c) && c != ' ' || i == n - 1) {
                if (sign == '+') {
                    numbers.push(num);
                } else if (sign == '-') {
                    numbers.push(-num);
                } else if (sign == 'X') {
                    numbers.push(numbers.pop() * num);
                }
                sign = c;
                num = 0;
            }
        }

        int result = 0;
        while (!numbers.isEmpty()) {
            result += numbers.pop();
        }

        return result;
    }
}
