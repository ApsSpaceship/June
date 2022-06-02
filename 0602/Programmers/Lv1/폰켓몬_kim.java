

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬_kim {
	public static void main(String[] args) {
		int[] nums = {3,3,3,2,2,2};
		Set<Integer> set = new HashSet<>(); // 중복 제거해서 set에 저장
		for(int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		if((nums.length/2) > set.size()) { 
			System.out.println(set.size());
		}else {
			System.out.println(nums.length/2);
		}
	}

}
