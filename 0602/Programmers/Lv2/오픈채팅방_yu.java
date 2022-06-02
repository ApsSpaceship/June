import java.util.Arrays;
import java.util.HashMap;

public class lv2_오픈채팅방 {
	public static void main(String[] args) {
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		//
		
		int ncnt = 0;
		
		HashMap<String, String> user = new HashMap<>();
		
		for(int i=0; i<record.length; i++) {
			if(record[i].charAt(0) == 'E' || record[i].charAt(0) == 'L') {
				ncnt++;
			}
			
			if(record[i].charAt(0) == 'E' || record[i].charAt(0) == 'C') {
				user.put(record[i].split(" ")[1], record[i].split(" ")[2]);
			}
		}
		
		String[] answer = new String[ncnt];
		
		int idx = 0;
		
		for(int i=0; i<record.length; i++) {
			
			if(record[i].charAt(0) == 'C') {
				continue;
			}
			
			
			if(record[i].charAt(0) == 'E') {
				String id = record[i].split(" ")[1];
				String nickname = user.get(id);
				answer[idx] = nickname + "님이 들어왔습니다.";
			}
			
			if(record[i].charAt(0) == 'L') {
				answer[idx] = user.get(record[i].split(" ")[1]) + "님이 나갔습니다.";
			}
			
			idx++;
		}
		
		System.out.println(Arrays.toString(answer));
		
	}

}
