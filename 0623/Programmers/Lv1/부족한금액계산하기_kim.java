package study_0623;

public class Lv1_부족한금액계산하기 {
	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;
		
		long fee = 0;
		for(int i = 1; i <= count; i++) {
			fee += price*i;
		}
		if(fee > money) {
			System.out.println(fee-money);
		}else {
			System.out.println(0);
		}
		
		
		
		
	}
}
