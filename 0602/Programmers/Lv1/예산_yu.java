import java.util.Arrays;

public class lv1_예산 {
	public static void main(String[] args) {
		
		int[] d = {1,3,2,5,4};
		int budget = 9;
		int answer = 0;
		
		Arrays.sort(d);
		int sum = 0;
		
		for(int i=0; i<d.length; i++) {
			sum += d[i];
			
			if(sum> budget) {
				break;
			}
			answer++;
		}
			
		System.out.println(answer);
	}

}
