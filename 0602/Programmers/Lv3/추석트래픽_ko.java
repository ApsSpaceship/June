class Solution {
	static class Point {
		int start;
		int end;

		Point(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public int solution(String[] lines) {
		int answer = 1; // 최소 1개
		int lLen = lines.length;
		Point[] list = new Point[lLen];

		for (int i = 0; i < lLen; i++) // 시작, 끝 시간 저장
			list[i] = getTime(lines[i]);

		int cnt;
		for (int i = 0; i < lLen; i++) {
			cnt = 1;
			for (int j = i + 1; j < lLen; j++) // 끝나는 시간 기준 정렬 상태이므로
				if (list[i].end + 1000 > list[j].start)
					cnt++;

			if (answer < cnt) // 최댓값 갱신
				answer = cnt;
		}

		return answer;
	}

	static Point getTime(String str) { // 밀리초 기준 시작, 끝 시간 계산
		int start, end, mid;
		end = ((Integer.parseInt(str.substring(11, 13)) * 60 // 시 -> 분
				+ Integer.parseInt(str.substring(14, 16))) * 60) * 1000 // 분 -> 밀리초
				+ (int) (Double.parseDouble(str.substring(17, 23)) * 1000); // 초 -> 밀리초
		mid = (int) (Double.parseDouble(str.substring(24, str.length() - 1)) * 1000); // 처리 시간
		start = end - mid + 1; // 시작 시간

		return new Point(start, end);
	}
}