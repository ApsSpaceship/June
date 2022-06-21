package study_0621;

public class Lv1_나머지가1이되는수 {
	public static void main(String[] args) {
		int n = 12;
		int ans = 0;
		for(int i = 2; i < n; i++) {
			if(n % i == 1) {
				ans = i;
				break;
			}
		}
	}

}
