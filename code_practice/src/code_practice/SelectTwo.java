package code_practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SelectTwo {
	public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if(i != j) {
					int sum = 0;
					sum = numbers[i] + numbers[j];
					set.add(sum);
				}
			}
		}
        answer = new int[set.size()];
        Iterator itr = set.iterator();
        int cnt = 0;

        while (itr.hasNext()) {
			answer[cnt] = (int) itr.next();
			cnt++;
		}
        Arrays.sort(answer);
        return answer;

    }
	
	public static void main(String[] args) {
		int[] a = {5,0,2,7};
		SelectTwo sol = new SelectTwo();
		int[] ans = sol.solution(a);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
