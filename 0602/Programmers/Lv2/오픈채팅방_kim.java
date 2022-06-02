
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_Lv2_오픈채팅방 {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[][] records = new String[record.length][3]; // [0]: 출입, 수정 , [1]: 아이디 , [2]: 닉네임
		Map<String, String> map = new HashMap<>(); // 해쉬맵 생성
		for(int i = 0; i < records.length; i++) {
			String a = record[i];
			records[i] = a.split(" ");
			if(records[i][0].equals("Leave")) {
				continue;
			}
			// map에 아이디를 키로 닉네임을 value로 저장해서 change일 때 자동으로  닉네임 바뀜
			map.put(records[i][1], records[i][2]); 
		}
		List<String> list = new ArrayList<>(); // 메세지 저장할 리스트
		for(int i = 0; i < records.length; i++) {
			if(records[i][0].equals("Enter")) {
				list.add(map.get(records[i][1])+"님이 들어왔습니다.");
			}else if(records[i][0].equals("Leave")) {
				list.add(map.get(records[i][1])+"님이 나갔습니다.");
			}
		}
		//ans 배열에 list 값 옮겨 담아서 반환
		String[] ans = new String[list.size()];
		for(int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		System.out.println(Arrays.toString(ans));
	
	}

}
