package code_practice;

import java.util.*;

public class NotSameNum02 {
	public int[] solution(int[] arr) {
		int[] answer = {};
		ArrayList<Integer> tempList = new ArrayList<>();
		int temp = 10;
		for (int num : arr) {
			if(temp != num) {
				tempList.add(num);
			}
			temp = num;
		}
		answer = new int[tempList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = tempList.get(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] a = {1,1,2,3,3,2,4};
		NotSameNum02 sol = new NotSameNum02();
		int[] ans = sol.solution(a);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
