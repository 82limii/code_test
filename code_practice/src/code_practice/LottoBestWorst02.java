package code_practice;

public class LottoBestWorst02 {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = {};
		int rank = 7;
		int zero = 0;
		
		for(int i=0; i<lottos.length; i++) {
			for(int j=0; j<win_nums.length; j++) {
				if(lottos[i] == win_nums[j]) {
					rank--;
				}
			}
			if(lottos[i] == 0) {
				zero++;
			}
		}
		
		if(rank == 7) {
			if(zero == 0) {				
				answer = new int[] {rank-1, rank-1};
			} else {				
				answer = new int[] {rank-zero, rank-1};
			}
		} else {			
			answer = new int[] {rank-zero, rank};
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		LottoBestWorst02 obj = new LottoBestWorst02();
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] result = obj.solution(lottos, win_nums);
		System.out.println(result[0] + "," + result[1]);
	}
}
