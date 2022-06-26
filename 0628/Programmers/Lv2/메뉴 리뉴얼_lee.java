import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    static ArrayList<String> orderList;
    public String[] solution(String[] orders, int[] course) {
       
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        // 주문 종류별 개수 구하기
        for(int i = 0 ; i < orders.length; i++) {
            char[] originOrder = orders[i].toCharArray();
            // 문자 오름차순 정렬
            Arrays.sort(originOrder);
            int len = originOrder.length;
            orderList = new ArrayList<String>();
            // 부분집합
            powerset(originOrder, new boolean[len], len, 0);
            for(String order : orderList) {
                // 존재하면 개수 증가, 없으면 추가
                if(map.containsKey(order)) {
                    int cnt = map.get(order);
                    map.put(order, ++cnt);
                }else map.put(order, 1);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < course.length; i++) {
            // 구하고자 하는 코스 메뉴 개수
            int courseLen = course[i];
            // 가장 많이 선택된 횟수
            int maxOrderCnt = 0;
            // 최대 횟수 구하기
            for(String key : map.keySet()) {
                int cnt = map.get(key);
                if(cnt > 1 && courseLen == key.length()){
                    if(cnt > maxOrderCnt)
                        maxOrderCnt = cnt;
                }
            }
            // 최대 횟수에 해당하는 메뉴 조합이 여러개 일 수 있어서 한  번 더  구함
            for(String key : map.keySet()) {
                if(courseLen == key.length() && map.get(key) == maxOrderCnt)
                        list.add(key);
            }
        }
        // 문자열 오름차순 정렬
        String[] answer = list.toArray(new String[list.size()]);
        Arrays.sort(answer);
        return answer;
    }
    // 부분집합
    public static void powerset(char[] order, boolean[] visited, int len, int idx) {
        if(idx == len) {
            StringBuilder sb = new StringBuilder();
            for(int i= 0 ; i < len; i++) {
                if(visited[i])
                    sb.append(order[i]);
            }
            if(sb.length() >= 2)
                orderList.add(sb.toString());
            return;
        }
        visited[idx] = false;
        powerset(order, visited, len, idx+1);
        visited[idx] = true;
        powerset(order, visited, len, idx+1);
    }
}