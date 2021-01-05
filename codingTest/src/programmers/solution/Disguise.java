package programmers.solution;

import java.util.HashMap;
import java.util.Map;

public class Disguise {
	public int solution(String[][] clothes) {
		Map<String, Integer> combination = new HashMap<>();
		int answer = 1;
		
		for (String[] cloth : clothes) {
			// 같은 종류일 경우 기존 값 + 1
			String key = cloth[1];
			combination.put(key, combination.getOrDefault(key, 0) + 1);
		}
		
		// 경우의 수 : answer *= (각각의 옷 개수 + 안 입을 경우)
		for (Map.Entry<String, Integer> elem : combination.entrySet()) {
			answer *= (elem.getValue()+1);
		}
		
		// 하나도 입지 않았을 경우도 있으므로 -1
		return answer-1;
	}
	public static void main(String[] args) {
		Disguise disguise = new Disguise();
		String[][] clothes = {
			{"yellow_hat", "headgear"},
			{"blue_sunglasses", "eyewear"},
			{"green_turban", "headgear"}
		};
		System.out.println(disguise.solution(clothes));
	}
}
