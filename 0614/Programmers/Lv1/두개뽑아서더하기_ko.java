class Solution {
	public int[] solution(int[] numbers) {
		int len = numbers.length;
		int cnt = 0;
		int[] sum = new int[201];
		for (int i = 0; i < len - 1; i++)
			for (int j = i + 1; j < len; j++)
				if (sum[numbers[i] + numbers[j]]++ == 0)
					cnt++; // 중복 없는 개수 세기
		
		int[] answer = new int[cnt];
		for (int i = 200; i > 0 && cnt >= 0; i--)
			if (sum[i] > 0)
				answer[--cnt] = i;

		return answer;
	}
}