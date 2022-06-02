

import java.util.Arrays;

public class Programmers_Lv2_카카오프렌즈컬러링북 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int max;
	static int fill;

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		max = 0; // 최대로 칠한 칸 수
		int count = 0; // 영역 수
		visited = new boolean[m][n];
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && !visited[i][j]) { // 0이 아니고 방문하지 않았다면
					fill = 0; // 색칠한 칸의 수 체크 할 변수
					check(picture, i, j);
					count++; // 영역 수 증가
					max = Math.max(max, fill); // 최대로 칠한 칸 수 max에 비교해 저장
				}
			}
		}
		int[] ans = new int[2];
		ans[0] = count; // 영역 수
		ans[1] = max; // 최대로 칠한 칸의 수
		System.out.println(Arrays.toString(ans));

	}

	private static void check(int[][] picture, int r, int c) {		
		visited[r][c] = true;
		fill++; // 현재 색칠한 칸의 수 증가
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < picture.length && nc >= 0 && nc < picture[0].length) {
				if(!visited[nr][nc] && picture[r][c]==picture[nr][nc]) {
					check(picture, nr, nc);
				}				
			}
		}
	}
}
