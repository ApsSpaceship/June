#include <iostream>
#include <string>
#include <vector>

using namespace std;
int Y, X;
int board[101][101];

//배열 회전하고 최소값 반환
int rotate(int y1, int x1, int y2, int x2) {
    int ret = 10000;
    int temp = board[y1][x1];
    for (int i = y1; i < y2; i++) {
        board[i][x1] = board[i + 1][x1];
        ret = min(ret, board[i][x1]);
    }
    for (int j = x1; j < x2; j++) {
        board[y2][j] = board[y2][j + 1];
        ret = min(ret, board[y2][j]);
    }
    for (int i = y2; i > y1; i--) {
        board[i][x2] = board[i - 1][x2];
        ret = min(ret, board[i][x2]);
    }
    for (int j = x2; j > x1 + 1; j--) {
        board[y1][j] = board[y1][j - 1];
        ret = min(ret, board[y1][j]);
    }
    board[y1][x1 + 1] = temp;
    ret = min(ret, board[y1][x1 + 1]);
    return ret;
}
void init() {
    int cnt = 1;
    for (int i = 1; i <= Y; i++) {
        for (int j = 1; j <= X; j++) {
            board[i][j] = cnt++;
        }
    }
}
vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;
    Y = rows;
    X = columns;
    init();
    for (int i = 0; i < queries.size(); i++) {
        vector<int> v = queries[i];
        answer.push_back(rotate(v[0], v[1], v[2], v[3]));
    }
    return answer;
}