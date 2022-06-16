class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        long W = w;
        long H = h;
        // 최대공약수 만큼 패턴 반복
		int gcd = 1;
		int idx = (int)Math.min(W, H);

		for (int i = 2; i <= idx; i++) {
			if (W % i == 0 && H % i == 0) {
				gcd = i;
			}
		}

		if (W == H) { // 대각선이 정확하게 가로지름 ( w or h개수만큼만 빠짐)
			answer = W * H - H;
		} else { // 세로는 무조건 1칸씩, 가로는 w/gcd-1번 : 2칸 -> 추가로 더해주기
			answer = W * H - (W + H - gcd);
		}
        return answer;
    }
}