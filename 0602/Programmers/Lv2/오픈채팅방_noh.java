import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};

        List<String> ans = new ArrayList<String>();
        HashMap<String, String> uidToNickname = new HashMap<String, String>();
        HashMap<String, List<Integer>> uidToIndexes = new HashMap<String, List<Integer>>();

        for (int i = 0; i < record.length; ++i) {
            String[] splitt = record[i].split(" ");
            String command = splitt[0];
            String uid = splitt[1];
            String nickname = "";
            if (!command.equals("Leave")) {
                nickname = splitt[2];
                uidToNickname.put(uid, nickname);
            }

            if (command.equals("Enter")) {
                ans.add(uid + "님이 들어왔습니다.");
                if (uidToIndexes.get(uid) == null)
                    uidToIndexes.put(uid, new ArrayList<Integer>());
                uidToIndexes.get(uid).add(ans.size() - 1);
            } else if (command.equals("Leave")) {
                ans.add(uid + "님이 나갔습니다.");
                uidToIndexes.get(uid).add(ans.size() - 1);
            }
        }

        for (Map.Entry<String, String> entry : uidToNickname.entrySet()) {
            String uidd = entry.getKey();
            String nicknamee = entry.getValue();
            List<Integer> indexes = uidToIndexes.get(uidd);
            for (int idx : indexes) {
                ans.set(idx, ans.get(idx).replace(uidd, nicknamee));
            }
        }

        answer = ans.toArray(new String[0]);

        return answer;
    }
}