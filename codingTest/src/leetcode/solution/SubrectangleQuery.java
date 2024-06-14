package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * - https://leetcode.com/problems/subrectangle-queries/description/
 */
public class SubrectangleQuery {
    public static void main(String[] args) {
        List<String> answer = new ArrayList<>();
        SubrectangleQueries s = new SubrectangleQueries(new int[][] {
                {1,2,1},
                {4,3,4},
                {3,2,1},
                {1,1,1}
        });
        answer.add(null);
        answer.add(String.valueOf(s.getValue(0, 2)));
        s.updateSubrectangle(0, 0, 3, 2, 5);
        answer.add(null);
        answer.add(String.valueOf(s.getValue(0, 2)));
        answer.add(String.valueOf(s.getValue(3, 1)));
        s.updateSubrectangle(3, 0, 3, 2, 10);
        answer.add(String.valueOf(s.getValue(3, 1)));
        answer.add(String.valueOf(s.getValue(0, 2)));

        System.out.println(answer);
    }
}

class SubrectangleQueries {
    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = new int[rectangle.length][];

        for (int row=0; row<rectangle.length; row++) {
            this.rectangle[row] = new int[rectangle[row].length];
            for (int column=0; column<rectangle[row].length; column++) {
                this.rectangle[row][column] = rectangle[row][column];
            }
        }
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int row=row1; row<=row2; row++) {
            for (int column=col1; column<=col2; column++) {
                this.rectangle[row][column] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }
}
