import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public int[] solution(int m, int n, int[][] picture) {
		int[] answer = new int[2]; // 공간 수, 최댓값
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (picture[i][j] != 0 && !visited[i][j]) {
					answer[0]++;
					answer[1] = Math.max(answer[1], bfs(i, j, picture, m, n));
				}

		return answer;
	}

	static int bfs(int i, int j, int[][] picture, int m, int n) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i, j));
		visited[i][j] = true;
		int cnt = 1;

		while (q.size() > 0) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				// 범위, 방문 여부, 같은 숫자인지 확인
				if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc] || picture[i][j] != picture[nr][nc])
					continue;
				visited[nr][nc] = true;
				cnt++;
				q.add(new Point(nr, nc));
			}
		}

		return cnt;
	}
}