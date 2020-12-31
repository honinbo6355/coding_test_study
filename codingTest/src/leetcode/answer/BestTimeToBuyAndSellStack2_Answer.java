package leetcode.answer;

public class BestTimeToBuyAndSellStack2_Answer {
	public int maxProfit(int[] prices) {
		int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
	}
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStack2_Answer main = new BestTimeToBuyAndSellStack2_Answer();
		
		System.out.println(main.maxProfit(new int[] {1,2,3,4,5}));
	}
}
