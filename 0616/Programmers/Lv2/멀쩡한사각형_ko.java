class Solution {
	public long solution(int w, int h) {
		int no;

		if (w > h)
			no = eucd(w, h);
		else
			no = eucd(h, w);

		return (long) w * h - (w + h - no);
	}

	static int eucd(int big, int small) { // 유클리드호제법
		// 큰 숫자를 작은 숫자로 나눈 나머지 계산
		int r = big % small;

		// 나머지가 0이면 작은숫자가 최대공약수
		if (r == 0)
			return small;

		// 나머지가 0 이상이면 더 찾기
		return eucd(small, r);
	}

}
