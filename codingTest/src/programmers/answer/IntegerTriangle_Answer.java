package programmers.answer;

public class IntegerTriangle_Answer {
	public int solution(int[][] triangle) {
		/**
		 * bottom-top 방식
		 * top-bottom 방식과 비교해보면, left와 right 요소가 항상 존재하기 때문에 코드가 좀 더 간결해진다.
		 */
        for (int i=triangle.length-2; i>=0; i--) {
        		for (int j=0; j<triangle[i].length; j++) {
        			int left = triangle[i][j] + triangle[i+1][j];
        			int right = triangle[i][j] + triangle[i+1][j+1];
        			
        			triangle[i][j] = Math.max(left, right);
        		}
        }
        
        // 맨 꼭대기에 최대 합의 결과값이 계산되어있다.
        return triangle[0][0];
    }
	
	public static void main(String[] args) {
		IntegerTriangle_Answer integerTriangle_Answer = new IntegerTriangle_Answer();
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(integerTriangle_Answer.solution(triangle));
	}
}
