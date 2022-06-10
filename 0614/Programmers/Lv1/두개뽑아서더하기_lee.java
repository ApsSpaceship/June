import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    static HashSet<Integer> list;
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        boolean[] selected = new boolean[len];
        list = new HashSet<Integer>();
        comb(0, 0, len, numbers, selected);
        ArrayList<Integer> ans = new ArrayList<>(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = ans.get(i);
        Arrays.sort(answer);
        return answer;
    }
    // 조합 백트래킹
    public static void comb(int cnt, int idx, int len, int[] numbers, boolean[] selected) {
        if(cnt == 2) {
            int n = 0;
            int sum = 0;
            for(int j = 0 ; j < len; j++) {
                if(n == 2)
                    break;
                if(selected[j]){
                    sum += numbers[j];
                    n++;
                }         
            }
            list.add(sum);
            return;
        }
        else {
            for(int i = idx; i < len; i++) {
                selected[i] = true;
                comb(cnt+1, i+1, len, numbers, selected);
                selected[i] = false;
            }
        }
    }
}