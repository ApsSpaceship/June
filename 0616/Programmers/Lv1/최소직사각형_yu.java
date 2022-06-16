class Solution {
    public int solution(int[][] sizes) {
      	int maximum = 0;
		
		int minimum = 0;
				
		for(int i=0; i<sizes.length; i++) {
			int max = Math.max(sizes[i][1], sizes[i][0]);
			int min = Math.min(sizes[i][1], sizes[i][0]);
			
			if(max>maximum) {
				maximum = max;
			}
			if(min>minimum) {
				minimum = min;
			}
			
		}
		int answer = maximum*minimum;
        return answer;
    }
}