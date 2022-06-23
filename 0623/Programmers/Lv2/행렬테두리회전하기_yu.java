class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
      int[][] map = new int[rows][columns];
		
		int idx = 1;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				map[i][j] = idx++;
			}
		}
		
		int n = queries.length;
		
		int[] answer = new int[n];
		
		int aidx = 0;
		
		for(int i=0; i<n; i++) {
			int sr = queries[i][0]-1;
			int sc = queries[i][1]-1;
			int er = queries[i][2]-1;
			int ec = queries[i][3]-1;
			int st = map[sr][sc];
			int min = st;
			
		for(int a = sr+1; a<=er; a++) { // 왼 아래-> 왼위
			map[a-1][sc] = map[a][sc];
			min = Math.min(min, map[a][sc]);
		}
		for(int a = sc+1; a<=ec; a++) { // 오 아래-> 왼 아래
			map[er][a-1] = map[er][a];
			min = Math.min(min, map[er][a]);
		}
		for(int a = er-1; a>=sr; a--) { // 왼 위 -> 왼 아래
			map[a+1][ec] = map[a][ec];
			min = Math.min(min, map[a][ec]);
		}
		for(int a = ec-1; a>=sc; a--) { // 왼 위 -> 오 위
			map[sr][a+1] = map[sr][a];
			min = Math.min(min, map[sr][a]);
		}
		
		map[sr][sc+1] = st;
		
		answer[aidx++] = min;
        }
        return answer;
    }
}