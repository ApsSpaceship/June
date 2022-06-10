class Solution {
    static int answer;
    public int solution(int n, String[] data) {
        answer = 0;
        String str = "ACFJMNRT";
        boolean[] visited = new boolean[8];
        perm(str, "", visited, 0, n, data);
        return answer;
    }
	// 순열
	public static void perm(String str, String curr, boolean[] visited, int depth, int n, String[] data) {
	    if (curr.length() == 8) {
            if(check(curr, n, data))
                answer++;
	        return;
	    }
        if(depth == 8)
            return;  
	    for (int i = 0; i < 8; i++) {
	        if (visited[i] != true) {
	            visited[i] = true;
	            perm(str, curr + str.charAt(i), visited, depth + 1, n, data); 
	            visited[i] = false;
	        }
	    }
	}
    // 조건 체크
        // n : 조건 data의 개수  
        // 0 : 조건 제시 프렌즈
        // 1 : ~
        // 2 : 상대방 프렌즈
        // 3 : = < > 같음 미만 초과
        // 4 : 0~6 두 프렌즈 사이 다른 프렌즈 수
    public static boolean check(String c, int n, String[] data) {
        for(int i = 0 ; i < n; i++) {
            String condition = data[i];
            char f1 = condition.charAt(0);
            char f2 = condition.charAt(2);
            int dist = Math.abs(c.indexOf(f1) - c.indexOf(f2));
            int len = condition.charAt(4) - '0' +1;
            switch(condition.charAt(3)) {
                case '=':
                    if(dist != len)
                        return false;
                    break;
                case '<':
                    if(dist >= len)
                        return false;
                    break;
                case '>':
                    if(dist <= len)
                        return false;
                    break;
            }
        }
        return true;
    }
}