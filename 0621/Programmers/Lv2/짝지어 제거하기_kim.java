package study_0621;

import java.util.Stack;

public class Lv2_짝지어제거하기2 {
	public static void main(String[] args) {
		String a = "cdcd";
		System.out.println(solution(a));
	}
	
	public static int solution(String s) {
	
		Stack<Character> stack = new Stack<>(); 
		for(int i = 0; i < s.length(); i++) {
			if(!stack.isEmpty()&&stack.peek() == s.charAt(i)) {
				stack.pop();
			}else {
				stack.add(s.charAt(i));
			}
		}
		
		if(stack.size() == 0) {
			return 1;
		}else {
			return 0;
		}
			
		
	}

}
