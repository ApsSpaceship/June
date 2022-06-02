
import java.util.Arrays;

public class 예산_kim {
	public static void main(String[] args) {
		int[] d = {2,2,3,3};
		int budget = 10;
		
		Arrays.sort(d); // 오름차순으로 정렬
		int sum = 0;
		int idx = 0;
		while(idx<d.length) {
			sum += d[idx];
			if(sum > budget) { // 부서별 신청금액의 합이 예산보다 크면 멈춤
				break;
			}
			idx++;
		}
		System.out.println(idx);
	}

}
