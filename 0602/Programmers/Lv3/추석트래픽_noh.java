class Solution {
    public int solution(String[] lines) {
        int answer = 0;

        for (int i = 0; i < lines.length; ++i) {
            String[] splitt = lines[i].split(" ");
            String S = splitt[1];

            double SD = strToDouble(S);
            int cnt = 1;
            for (int j = i + 1; j < lines.length; ++j) {
                String[] splitt2 = lines[j].split(" ");
                String S2 = splitt2[1];
                String T2 = splitt2[2].substring(0, splitt2[2].length() - 1);
                double S2D = strToDouble(S2);
                double T2D = Double.parseDouble(T2);

                if (S2D - SD >= 3.999)
                    break;

                if (SD >= S2D - T2D - 0.998)
                    ++cnt;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    static double strToDouble(String str) {
        String[] tSplit = str.split(":");
        double sum = 0;
        sum += (Double.parseDouble(tSplit[0]) * 60 * 60);
        sum += (Double.parseDouble(tSplit[1]) * 60);
        sum += Double.parseDouble(tSplit[2]);
        return sum;
    }
}