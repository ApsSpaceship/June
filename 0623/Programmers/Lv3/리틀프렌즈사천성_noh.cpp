#include <string>
#include <vector>
#include <unordered_map>
#include <cstring>
using namespace std;

//알파벳의 좌표 클래스
class Pos {
   public:
    int y1, x1;
    int y2, x2;
};

//알파벳이 존재하는지
int alphabet[26];
//해당 알파벳의 좌표 저장
unordered_map<char, Pos> mp;
//보드의 크기
int Y, X;
//남아있는 알파벳의 개수
int cnt;

//초기화 함수
void init() {
    memset(alphabet, 0, sizeof(alphabet));
    mp.clear();
    cnt = 0;
}

bool link(char c, vector<string> board) {
    int y1 = mp[c].y1;
    int x1 = mp[c].x1;
    int y2 = mp[c].y2;
    int x2 = mp[c].x2;

    //루트1
    bool route1 = true;
    //루트2
    bool route2 = true;
    if (x1 <= x2) {
        for (int i = y1; i <= y2; i++) {
            //루트1 막힘
            if (board[i][x1] != '.' && board[i][x1] != c) {
                route1 = false;
            }
            //루트2 막힘
            if (board[i][x2] != '.' && board[i][x2] != c) {
                route2 = false;
            }
        }
        if (!route1 && !route2)
            return false;
        for (int j = x1 + 1; j <= x2 - 1; j++) {
            //루트1 막힘
            if (board[y2][j] != '.' && board[y2][j] != c) {
                route1 = false;
            }
            //루트2 막힘
            if (board[y1][j] != '.' && board[y2][j] != c) {
                route2 = false;
            }
        }
    } else {
        for (int i = y1; i <= y2; i++) {
            //루트1 막힘
            if (board[i][x1] != '.' && board[i][x1] != c) {
                route1 = false;
            }
            //루트2 막힘
            if (board[i][x2] != '.' && board[i][x2] != c) {
                route2 = false;
            }
        }
        if (!route1 && !route2)
            return false;
        for (int j = x2; j <= x1; j++) {
            //루트1 막힘
            if (board[y2][j] != '.' && board[y2][j] != c) {
                route1 = false;
            }
            //루트2 막힘
            if (board[y1][j] != '.' && board[y1][j] != c) {
                route2 = false;
            }
        }
    }
    return route1 || route2;
}

string solution(int m, int n, vector<string> board) {
    string answer = "";
    init();
    Y = board.size();
    X = board[0].length();
    for (int i = 0; i < Y; i++) {
        for (int j = 0; j < X; j++) {
            char c = board[i][j];
            if (c == '.' || c == '*')
                continue;
            alphabet[c - 'A']++;
            if (alphabet[c - 'A'] == 1) {
                mp[c].y1 = i;
                mp[c].x1 = j;
            } else if (alphabet[c - 'A'] == 2) {
                mp[c].y2 = i;
                mp[c].x2 = j;
                cnt++;
            }
        }
    }
    //검사할 위치
    int p = 0;
    while (cnt != 0) {
        bool noRemove = true;
        for (int i = p; i < 26; i++) {
            if (alphabet[i] == 0)
                continue;
            char c = 'A' + i;
            //연결 되면
            if (link(c, board)) {
                //하나라도 지움
                noRemove = false;
                //보드에 알파벳 지우고
                board[mp[c].y1][mp[c].x1] = '.';
                board[mp[c].y2][mp[c].x2] = '.';
                //알파벳 개수 줄이고
                alphabet[i] = 0;
                //총 알파벳 개수 줄이고
                cnt--;
                //위치 처음으로 초기화
                p = 0;
                //정답 더하기
                answer += c;
                break;
            }
        }
        if (noRemove)
            break;
    }
    if (cnt == 0)
        return answer;
    return "IMPOSSIBLE";
}