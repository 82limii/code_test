package code_practice;

public class LottoBestWorst01 {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = {};
		int bestCount = 0;
		int worstCount = 0;
		int bestRank = 0;
		int worstRank = 0;
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(lottos[i] == win_nums[j]) {
					bestCount++;
					worstCount++;
				}
			}
			if(lottos[i] == 0) {
				bestCount++;
			}
		}
		
		switch(bestCount) {
			case 6:
				bestRank = 1;
				break;
			case 5:
				bestRank = 2;
				break;
			case 4:
				bestRank = 3;
				break;
			case 3:
				bestRank = 4;
				break;
			case 2:
				bestRank = 5;
				break;
			default:
				bestRank = 6;
				break;
		}
		
		switch(worstCount) {
		case 6:
			worstRank = 1;
			break;
		case 5:
			worstRank = 2;
			break;
		case 4:
			worstRank = 3;
			break;
		case 3:
			worstRank = 4;
			break;
		case 2:
			worstRank = 5;
			break;
		default:
			worstRank = 6;
			break;
		}
		
		answer = new int[] {bestRank, worstRank};
		return answer;
	}
	
	public static void main(String[] args) {
		LottoBestWorst01 obj = new LottoBestWorst01();
		int[] lottos = {31, 10, 45, 1, 6, 19};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] result = obj.solution(lottos, win_nums);
		System.out.println(result[0] + "," + result[1]);
	}
}
