package code_practice;

import java.util.*;

public class NotSameNum01 {
	public int[] solution(int[] arr) {
		int[] answer = {};
		for (int i=1; i < arr.length; i++) {
			if(arr[i]==arr[i-1]) {
				arr[i-1] = -1;
			}
		}
		List<Integer> arrSol = new ArrayList<Integer>();
		
		for (int i : arr) {
			if(i>-1) {
				arrSol.add(i);
			}
		}
		
		answer = new int[arrSol.size()];
		
		for (int i = 0; i < arrSol.size(); i++) {
			answer[i] = arrSol.get(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] a = {1,1,2,3,3,2,4};
		NotSameNum01 sol = new NotSameNum01();
		int[] ans = sol.solution(a);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
