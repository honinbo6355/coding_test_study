package programmers.solution;

import java.util.Stack;

public class ProperbracketCnt {
	class Bracket {
		int open;
		int close;
		
		Bracket(int open, int close) {
			this.open = open;
			this.close = close;
		}
	}
	public int solution(int n) {
		int answer = 0;
		Stack<Bracket> stack = new Stack<>();
		
		stack.push(new Bracket(0, 0));
		while (!stack.isEmpty()) {
			Bracket bracket = stack.pop();
			
			if (bracket.open > n || bracket.close > n) continue; // 괄호가 n개를 초과할 경우
			if (bracket.open < bracket.close) continue; // 닫는 괄호가 여는 괄호보다 많을 경우
			if (bracket.open + bracket.close == n*2) { // 올바른 괄호일 경우
				answer++;
				continue;
			}
			stack.push(new Bracket(bracket.open+1, bracket.close));
			stack.push(new Bracket(bracket.open, bracket.close+1));
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		ProperbracketCnt properbracketCnt = new ProperbracketCnt();
		
		System.out.println(properbracketCnt.solution(2));
	}
}
