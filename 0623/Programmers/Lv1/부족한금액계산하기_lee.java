class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long calcMoney = Long.valueOf(money);
        for(int i = 1 ; i <= count; i++)
            calcMoney -= price * i;
        if(calcMoney < 0)
            answer = Math.abs(calcMoney);
        return answer;
    }
}