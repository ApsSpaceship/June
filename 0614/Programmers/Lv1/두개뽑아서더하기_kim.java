
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_Lv1_두개뽑아서더하기 {
	static int n = 2;
	static int[] sel;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		sel = new int[2];
		comb(numbers, 0, 0);
		int[] ans = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		Arrays.sort(ans);
		System.out.println(Arrays.toString(ans));
				
	}
	private static void comb(int[] numbers, int idx, int sidx) {
		if(sidx == 2) {
			int sum = 0;
			for(int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if(!list.contains(sum)) {
				list.add(sum);
			}
			return;
		}
		if(idx == numbers.length) {
			return;
		}
		
		sel[sidx] = numbers[idx];
		comb(numbers,idx+1, sidx+1);
		comb(numbers,idx+1, sidx);
				
	}
}
