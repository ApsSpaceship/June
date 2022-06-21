import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static final int[] dy = { 1, -1, 0, 0 };
    static final int[] dx = { 0, 0, 1, -1 };
    static int Y = -1;
    static int X = -1;
    static boolean[][] visited = null;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        Y = picture.length;
        X = picture[0].length;
        visited = new boolean[Y][X];

        for (int i = 0; i < Y; ++i) {
            for (int j = 0; j < X; ++j) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    ++numberOfArea;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, BFS(i, j, picture));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }

    }

    static int BFS(int y, int x, int[][] picture) {
        int cnt = 0;
        Queue<Pos> q = new LinkedList<Solution.Pos>();
        q.add(new Pos(y, x));

        while (!q.isEmpty()) {
            int curY = q.peek().y;
            int curX = q.poll().x;
            if (visited[curY][curX])
                continue;
            visited[curY][curX] = true;
            ++cnt;
            for (int d = 0; d < 4; ++d) {
                int ny = curY + dy[d];
                int nx = curX + dx[d];
                if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx] && picture[ny][nx] == picture[y][x]) {
                    q.add(new Pos(ny, nx));
                }
            }
        }
        return cnt;
    }
}