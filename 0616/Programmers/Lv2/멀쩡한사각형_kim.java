package study_0616;

public class Programmers_Lv2_멀쩡한사각형 {
	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		long ans = 0;
		if(w > h) { // 세로의 길이가 더 크게 설정
			int tmp = w;
			w = h;
			h = tmp;
		}
		int max = 0; // 최대공약수
		for(int i = 1; i <= w; i++) {
			if(w % i == 0 && h % i == 0) {
				max = i;
			}
		}
		ans = (long)w * h - (w+h-max);
		System.out.println(ans);
		
	}

}
