package code_practice;

public class AddNonExistent {
	public int solution(int[] numbers) {
        int answer = -1;
        int[] allNum = {0,1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < allNum.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (allNum[i] == numbers[j]) {
					allNum[i] = 0;
				}
			}
		}
        
        answer = 0;
        for (int i = 0; i < allNum.length; i++) {
			answer += allNum[i];
		}
        return answer;
    }
	
	public static void main(String[] args) {
		AddNonExistent a = new AddNonExistent();
		int[] b = {1,2,3,4,5};
		int c = a.solution(b);
		System.out.println(c);
	}
}
