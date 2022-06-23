class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        int n = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0 ; j < columns; j++)
                arr[i][j] = n++;
        }

        int[] answer = new int[queries.length];
        for(int a = 0; a < queries.length; a++) {
            int[] query = queries[a];
            int rv1 = query[0]-1;
            int rv2 = query[2]-1;
            int cv1 = query[1]-1;
            int cv2 = query[3]-1;
            
            int val = arr[rv1][cv1];
            int minV = val;
            for(int r = rv1+1; r <= rv2; r++){
                minV = Math.min(minV, arr[r][cv1]);
                arr[r-1][cv1] = arr[r][cv1];
            }
            for(int c = cv1+1 ; c <= cv2; c++){
                minV = Math.min(minV, arr[rv2][c]);
                arr[rv2][c-1] = arr[rv2][c];
            }
            for(int r = rv2-1; r >= rv1; r--){
                minV = Math.min(minV, arr[r][cv2]);
                arr[r+1][cv2] = arr[r][cv2];
            }
            for(int c = cv2-1 ; c >= cv1; c--){
                minV = Math.min(minV, arr[rv1][c]);
                arr[rv1][c+1] = arr[rv1][c];
            }
            arr[rv1][cv1+1] = val;
            answer[a] = minV;
        }
        return answer;
    }
}
