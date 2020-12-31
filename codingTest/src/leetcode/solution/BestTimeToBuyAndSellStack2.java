package leetcode.solution;

public class BestTimeToBuyAndSellStack2 {
	public int maxProfit(int[] prices) {
		/*
		 * 문제에서 몇일에 사서 가장 비싼 일에 판다고 했지만 
		 * 그 차이는 하루하루 차이를 더한 값과 같다.
		 * greedy 방식으로 해결할 수 있다.
		 */
		
		int tmp = prices[0];
		int answer = 0;
		
        for (int i=1; i<prices.length; i++) {
        		if (tmp < prices[i]) {
        			answer += (prices[i] - tmp);
        		}
        		tmp = prices[i];
        }
        
        return answer;
    }
	public static void main(String[] args) {
		BestTimeToBuyAndSellStack2 main = new BestTimeToBuyAndSellStack2();
		
		System.out.println(main.maxProfit(new int[] {1,2,3,4,5}));
	}
}
