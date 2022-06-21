import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
Stack<Character> test = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			
			char word = s.charAt(i);
			
			if(!test.isEmpty() && test.peek() == word) {
				test.pop();
				continue;
			}
			
			test.add(word);
			
		}
		
		if(test.isEmpty()) {
			answer = 1;
		}

        return answer;
    }
}