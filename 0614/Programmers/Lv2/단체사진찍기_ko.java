import java.util.HashMap;

class Solution {
	static int answer;
	static int[] place;
	static HashMap<Character, Integer> map;
	static int len;

	public int solution(int n, String[] data) {
		answer = 0;
		len = n;
		place = new int[8];
		map = new HashMap<>(); // 카카오프렌즈 place 인덱스

		map.put('A', 0);
		map.put('C', 1);
		map.put('F', 2);
		map.put('J', 3);
		map.put('M', 4);
		map.put('N', 5);
		map.put('R', 6);
		map.put('T', 7);

		nPn(data, 0, 0);

		return answer;
	}

	static void nPn(String[] data, int idx, int visit) { // 8명 순열
		if (idx == 8) {
			if (check(data))
				answer++;
			return;
		}

		for (int i = 0; i < 8; i++)
			if ((visit & (1 << i)) == 0) { // 이 위치 안 썼으면
				place[idx] = i; // idx는 카카오프렌즈, i는 이번 위치
				nPn(data, idx + 1, visit | (1 << i));
			}
	}

	static boolean check(String[] data) {
		int abDiff, diff;
		for (int i = 0; i < len; i++) {
			abDiff = Math.abs(place[map.get(data[i].charAt(0))] - place[map.get(data[i].charAt(2))]);
			diff = data[i].charAt(4) - '0' + 1;

			switch (data[i].charAt(3)) {
			case '=':
				if (abDiff != diff)
					return false;
				break;
			case '>':
				if (abDiff <= diff)
					return false;
				break;
			default:
				if (abDiff >= diff)
					return false;
				break;
			}

		}
		return true;
	}

}