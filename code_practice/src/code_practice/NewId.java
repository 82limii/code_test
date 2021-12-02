package code_practice;

public class NewId {
	public String solution(String new_id) {
		String answer = "";
//      1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		new_id = new_id.toLowerCase();

//      2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		String match = "[^0-9a-z\\-\\_\\.]";
		new_id = new_id.replaceAll(match, "");
		
//      3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		String dots = "..";
		String two = "..";
		
		for (int i = 1; i < new_id.length(); i++) {
			new_id = new_id.replace(dots, ".");
			new_id = new_id.replace(two, ".");
			dots += ".";
		}
		
//      4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		StringBuffer new_idBuffer = null;
		if (new_id.indexOf(".") == 0 || new_id.lastIndexOf(".") == (new_id.length() - 1)) {
			if (new_id.indexOf(".") == 0) {
				new_idBuffer = new StringBuffer(new_id);
				new_id = new_idBuffer.substring(1, (new_id.length()));
			} else if (new_id.lastIndexOf(".") == (new_id.length() - 1)) {
				new_idBuffer = new StringBuffer(new_id);
				new_id = new_idBuffer.substring(0, (new_id.length() - 1));
			}
		}
		
//      5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if (new_id.isEmpty()) {
			new_id += "a";
		}
		
//      6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//      	만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if (new_id.length() >= 16) {
			new_idBuffer = new StringBuffer(new_id);
			new_id = new_idBuffer.substring(0, 15);
		}
		
		if (new_id.lastIndexOf(".") == (new_id.length() - 1)) {
			new_idBuffer = new StringBuffer(new_id);
			new_id = new_idBuffer.substring(0, (new_id.length() - 1));
		}

//      7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
//		boolean flagLoop = true;
		String lastStr = new_id.charAt(new_id.length() - 1) + "";

		if (new_id.length() <= 2) {
			while (new_id.length()<3) {
				new_id += lastStr;
			}
		}
		
		answer = new_id;
		return answer;
	}

	public static void main(String[] args) {
		NewId method = new NewId();
		String new_id = "bat.y.abcdefghijklm";
		String answer = method.solution(new_id);
		System.out.println(answer);
	}
}
