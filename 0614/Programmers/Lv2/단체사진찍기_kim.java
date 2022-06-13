
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers_Lv2_단체사진찍기 {
	static Character[] sel;
	static Character[] member = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	static Character[][] datas;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) {
		int n = 2;
		String[] data = { "M~C<2", "C~M>1" };
		datas = new Character[n][5];
		sel = new Character[8];
		visited = new boolean[8];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < 5; j++) {
				datas[i][j] = data[i].charAt(j);
			}
		}
		ans = 0; // 경우의 수
		perm(0); // 순열
		System.out.println(ans);

	}

	private static void perm(int idx) {
		if (idx == 8) {
			Map<Character, Integer> map = new HashMap<>();
			// 맵에 각 캐릭터와 인덱스 저장함
			for(int i = 0; i < sel.length; i++) {
				map.put(sel[i], i);
			}	
			boolean flag = true;
			// 조건의 수 만큼 확인하기
			for(int i = 0; i < datas.length; i++) {
				int first = map.get(datas[i][0]); // 첫번째 캐릭터 위치
				int second = map.get(datas[i][2]); // 두번째 캐릭터 위치
				int position = datas[i][4]-'0'; // 두 캐릭터 사이의 다른 프렌즈 수
				switch(datas[i][3]) {
				case '=':
					// position이 두 캐릭터 사이의 프렌즈 수라 두 캐릭터의 위치-1한 값과 비교를 해줘야 함.
					// ex) position이 0이면 두 캐릭터가 붙어있어야 하는데 그 때의 두 캐릭터의 인덱스 차이가 1이므로
					if(position != Math.abs(first-second)-1) { 
						flag = false;
					}
					break;
				case '>':
					if(position >= Math.abs(first-second)-1) {
						flag = false;
					}
					break;
				case '<':
					if(position <= Math.abs(first-second)-1) {
						flag = false;
					}
					break;
				}
			}
			//조건을 다 만족했을 경우만 경우의 수 증가시킴.
			if(flag) {
				ans++;
			}
			
			return;
		}
          
		// 순열로 8명 뽑기
		for (int i = 0; i < 8; i++) {
			if (visited[i])
				continue;
			sel[idx] = member[i];
			visited[i] = true; // 사용
			perm(idx + 1);
			visited[i] = false; // 사용하지 않음
		}

	}

}
