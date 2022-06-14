import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> dul = new HashSet<>();
		
		for(int i=0; i<numbers.length-1; i++) {
			for(int j= i+1; j<numbers.length; j++) {
				int addnum = numbers[i] + numbers[j];
				dul.add(addnum);
			}
		}
		
		int[] answer = new int[dul.size()];
		
		Iterator<Integer> iter = dul.iterator();
		
		int idx = 0;
		while(iter.hasNext()) {
			answer[idx++] = iter.next();
			
		}
		
		Arrays.sort(answer);
        return answer;
    }
}