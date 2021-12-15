package code_practice;
import java.util.*;

public class Crain {
    public int solution(int[][] board, int[] moves) {
    	int answer = 0;
    	
        return answer;
    }
    
    public static void main(String[] args) {
		int[][] board = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}
		};
		
		int[] moves = {1,5,3,5,1,2,1,4};
		
//		System.out.println(board.length);
		// 쌓이는 곳 => 4,(3,(1,1),3),2,"",4
		Stack<Integer> stack = new Stack<>();
		for(int move : moves) {
			for(int i=0; i<board.length; i++) {
				if(board[i][move-1] != 0) {
					stack.push(board[i][move-1]);
					board[i][move-1] = 0;
					break;
				}
			}
			
		}
		System.out.println(stack.peek());
	}
}
