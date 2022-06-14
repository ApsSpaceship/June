class Solution {
    public long solution(int w, int h) {
        long wv = Long.valueOf(w);
        long hv = Long.valueOf(h);
        long gcd = findgcd(wv, hv);
        // 전체 넓이 - (가로/최대공약수 + 세로/최대공약수 -1) * 반복(최대공약수만큼) -> 못쓰는 사각형
        long answer = wv * hv - (wv/gcd + hv/gcd - 1) * gcd;
        return answer;
    }
    // 최대공약수 
    public long findgcd(long w, long h) {
        while(h != 0) {
            long r = w % h;	// 나머지를 구해준다.
            w = h;		
            h = r;
        }
        return w;
    }
}
