package study_0623;

import java.util.Arrays;

public class Lv2_행렬테두리회전하기 {
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6; 
		int[][] map = new int[rows][columns];
		int st = 1;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				map[i][j] = st++;
			}
		}
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[] ans = new int[queries.length];
		for(int i = 0; i < queries.length; i++ ) {
			int r1 = queries[i][0]-1;
			int c1 = queries[i][1]-1;
			int r2 = queries[i][2]-1;
			int c2 = queries[i][3]-1;
			int save = map[r1][c1];
			int min = map[r1][c1];
			for(int r = r1; r < r2; r++) {
				map[r][c1] = map[r+1][c1];
				min = Math.min(min, map[r][c1]);
			}
			for(int c = c1; c < c2; c++) {
				map[r2][c] = map[r2][c+1];
				min = Math.min(min, map[r2][c]);
			}
			for(int r = r2; r >r1; r--) {
				map[r][c2] = map[r-1][c2];
				min = Math.min(min, map[r][c2]);
			}
			for(int c = c2; c > c1+1; c--) {
				map[r1][c] = map[r1][c-1];
				min = Math.min(min, map[r1][c]);
			}
			map[r1][c1+1] = save;
			ans[i] = min;			
		}
		System.out.println(Arrays.toString(ans));
	}

}
