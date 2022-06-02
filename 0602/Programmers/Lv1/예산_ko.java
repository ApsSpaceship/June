import java.util.Arrays;

class Solution {

	public int solution(int[] d, int budget) {
		Arrays.sort(d);
		int len = d.length;
		int ans = 0;

		for (; ans < len; ans++) {
			budget -= d[ans];
			if (budget < 0)
				break;
		}

		return ans;
	}

}
