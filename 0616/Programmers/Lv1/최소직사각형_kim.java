package study_0616;

public class Programmers_Lv1_최소직사각형 {
	public static void main(String[] args) {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		int width = 0;
		int height = 0;
		// 가로랑 세로의 값을 비교하여 가로를 제일 큰 값으로 바꾼다.
		for(int i = 0; i < sizes.length; i++) {
			if(sizes[i][0] < sizes[i][1]) {
				int tmp = sizes[i][0];
				sizes[i][0] = sizes[i][1];
				sizes[i][1] = tmp;
			}
			width = Math.max(width, sizes[i][0]);
			height = Math.max(height, sizes[i][1]);
		}
		int ans = width * height;
		System.out.println(ans);
	
		
	}

}
