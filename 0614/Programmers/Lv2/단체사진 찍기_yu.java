class Solution {
    static String[] kakao;
	static String[] ddata;
	static int N = 8;
	static int m;
	static int answer;
    
    public int solution(int n, String[] data) {
        kakao = new String[] {"A", "C", "F", "J", "M", "N", "R", "T"};
        m= n;
        answer = 0;
        ddata = new String[m];
        for(int i=0; i<m; i++) {
            ddata[i] = data[i];
        }
	    perm(0);
        return answer;
    }
    
    static void swap(int a , int b) {
	String temp = kakao[a];
	kakao[a] = kakao[b];
	kakao[b] = temp;
}

static void perm(int idx) {
	if(idx == N) {
		int cnt = 0;
		
		for(int i=0; i<m; i++) {
			int fst = 0;
			int snd = 0;
			int num = Integer.parseInt(ddata[i].substring(4, 5));
			
			for(int j=0; j<kakao.length; j++) {
				if(kakao[j].equals(ddata[i].substring(0, 1))) {
					fst = j;
				}
				if(kakao[j].equals(ddata[i].substring(2, 3))) {
					snd = j;
				}
			}
			if(ddata[i].substring(3, 4).equals("=")) {
				if(Math.abs(fst-snd)!=num+1) {
					break;
				}else{
                    cnt++;
                }
			}else if(ddata[i].substring(3, 4).equals("<")) {
				//if(Math.abs(fst-snd)<=num) {
                if(Math.abs(fst-snd)>num) {
					break;
				}else{
                    cnt++;
                }
			}else {  // > 일 떄
				//if(Math.abs(fst-snd)>=num+2) {
                if(Math.abs(fst-snd)<num+2) {
					break;
				}else{
                    cnt++;
                }
			}
		}
		
		if(cnt == m) {
			answer++;
		}
		
		return;
	}
	
	for(int i=idx; i<N; i++) {
		swap(i, idx);
		perm(idx+1);
		swap(i, idx);
	}
}
}