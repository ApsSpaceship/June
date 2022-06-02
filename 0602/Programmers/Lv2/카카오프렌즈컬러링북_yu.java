import java.util.Arrays;

public class lv2_카카오프렌즈컬러링북 {
	
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1}; // 상하좌우
	static boolean[][] visited;
	static int m, n, g;
	static int[][] pic;
	
	public static void main(String[] args) {
		
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		//
		
		m = 6; // 그림 크기
		n = 4; // 그림 크기  mxn
		
		pic = new int[m][n];
		visited = new boolean[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				pic[i][j] = picture[i][j];
			}
		}
		
		
		int cnt = 0;
		int maxg = 0;
		
		for(int r=0; r<m; r++) {
			for(int c=0; c<n; c++) {
				g=0;
				if(!visited[r][c] && pic[r][c]>0) {
					cnt++;
					g =dfs(r, c);
				}
				
				if(maxg<g) {
					maxg = g;
				}
			}
		}
		
		int[] answer = new int[2];
		answer[0] = cnt;
		answer[1] = maxg;

		
		System.out.println(Arrays.toString(answer));
		
	}
	

	static int dfs(int r, int c) {
		
		visited[r][c] = true;
		int num = pic[r][c];
		
		for(int i=0; i<4; i++) {
			
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			
			if(nr<0 || nc<0 || nr>=m|| nc>=n) {
				continue;
			}
			
			if(visited[nr][nc] || pic[nr][nc] != num) {
				continue;
			}
			
			dfs(nr, nc);
			g++;
		}
		return g+1;
		
		
	}

}
