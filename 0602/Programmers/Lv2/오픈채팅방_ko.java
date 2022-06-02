import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    
    static class Sub {
		String id;
		boolean isIn;
		public Sub(String id, boolean isIn) {
			this.id = id;
			this.isIn = isIn;
		}
	}

    public String[] solution(String[] record) {
     	HashMap<String, String> map = new HashMap<>();
		List<Sub> list = new ArrayList<>();
		int rLen = record.length;
		
        for(int i =0; i<rLen; i++) {
			String[] now = record[i].split(" ");
            
			switch (now[0].charAt(0)) {
			case 'L': // 나간 경우
				list.add(new Sub(now[1], false));				
				break;
			case 'E': // 들어온 경우
				list.add(new Sub(now[1], true));
			default: // 이름 저장
				map.put(now[1], now[2]);
				break;
			}
		}
        
		int lLen = list.size();
		String[] answer = new String[lLen];
		Sub sub;
		
        for(int i =0; i<lLen; i++) {
			sub = list.get(i);
			if(sub.isIn)
				answer[i] = map.get(sub.id) + "님이 들어왔습니다.";
			else
				answer[i] = map.get(sub.id) + "님이 나갔습니다.";
		}
		
		return answer;
    }
}