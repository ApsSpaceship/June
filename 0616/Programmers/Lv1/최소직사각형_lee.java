class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        for(int i = 0; i < sizes.length; i++){
            // 가로는 주어진 명함 가로 세로 중 더 큰 것
            int w = Math.max(sizes[i][0], sizes[i][1]);
            // 세로는 더 작은 것
            int h = Math.min(sizes[i][0], sizes[i][1]);
            // 가로 최대 값 갱신 
            maxW = Math.max(maxW ,w);
            // 세로 최대 값 갱신
            maxH = Math.max(maxH ,h);
        }
        int answer = maxW * maxH;
        return answer;
    }

}