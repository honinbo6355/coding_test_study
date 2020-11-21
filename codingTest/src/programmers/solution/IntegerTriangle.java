package programmers.solution;

public class IntegerTriangle {
	public int solution(int[][] triangle) {
        int answer = 0; // 최대 합을 저장하는 변수
        
        // top-bottom 방식
        for (int i=1; i<triangle.length; i++) {
        		for (int j=0; j<triangle[i].length; j++) {
        			int left = 0;
        			int right = 0;
        			
        			// 위쪽의 왼쪽 요소가 존재할 경우
        			if (j != 0) {
        				left = triangle[i][j] + triangle[i-1][j-1];
        			}
        			// 위쪽의 오른쪽 요소가 존재할 경우
        			if (j != triangle[i].length-1) {
        				right = triangle[i][j] + triangle[i-1][j];
        			}
        			
        			triangle[i][j] = Math.max(left, right); // 두 방법중 합이 큰 값을 현재 요소에 저장한다.
        			answer = Math.max(triangle[i][j], answer); // 현재 요소의 값과 answer값 중 큰 값을 answer에 update 한다.
        		}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		IntegerTriangle integerTriangle = new IntegerTriangle();
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(integerTriangle.solution(triangle));
	}
}
