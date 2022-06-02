import java.util.HashSet;

public class lv1_폰켓몬 {
	public static void main(String[] args) {
		int[] nums = {3,3,3,2,2,2};
		int answer = 0;
		//
		
		int n = nums.length;
		
		HashSet<Integer> mon = new HashSet<>();
		
		for(int i=0; i<n; i++) {
			mon.add(nums[i]);
		}
		
		if(mon.size()>n/2) {
			answer = n/2;
		}else {
			answer = mon.size();
		}
		
		System.out.println(answer);
	}

}
