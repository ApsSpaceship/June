import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        TreeSet<Integer> ts = new TreeSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                ts.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[ts.size()];

        int idx = 0;
        for (int x : ts)
            answer[idx++] = x;

        return answer;
    }
}