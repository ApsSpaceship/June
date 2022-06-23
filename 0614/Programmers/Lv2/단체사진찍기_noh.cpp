#include <string>
#include <vector>
using namespace std;

//순열로 모든 경우의 수를 탐색하며 조건을 만족하는지 찾는다.

int ans = 0;
char arr[8] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

//순열이 정해진 배열이 조건을 만족하는지 체크하는 함수, 만족하면 1, 아니면 0 반환
int check(vector<string> data) {
    for (int i = 0; i < data.size(); i++) {
        //프렌즈 1
        char f1 = data[i][0];
        //프렌즈 2
        char f2 = data[i][2];
        //조건 연산자
        char oper = data[i][3];
        //숫자
        int num = data[i][4] - '0';

        //각 프렌즈의 인덱스 구하기
        int f1_idx = -1;
        int f2_idx = -1;
        for (int j = 0; j < 8; j++) {
            if (arr[j] == f1)
                f1_idx = j;
            else if (arr[j] == f2)
                f2_idx = j;
        }
        //두 프렌즈 사이에 있는 프렌즈 수
        int dist = abs(f1_idx - f2_idx) - 1;
        //조건 연산자에 따라 조건 확인
        switch (oper) {
            case '=':
                if (dist != num)
                    return 0;
                break;
            case '<':
                if (dist >= num)
                    return 0;
                break;
            case '>':
                if (dist <= num)
                    return 0;
                break;
        }
    }
    return 1;
}

// swap으로 구현한 순열 함수
void swapPerm(int idx, vector<string> data) {
    if (idx == 8) {
        ans += check(data);
        return;
    }
    for (int i = idx; i < 8; i++) {
        swap(arr[idx], arr[i]);
        swapPerm(idx + 1, data);
        swap(arr[idx], arr[i]);
    }
}

//전역변수 초기화 함수
void init() {
    ans = 0;
    arr[0] = 'A';
    arr[1] = 'C';
    arr[2] = 'F';
    arr[3] = 'J';
    arr[4] = 'M';
    arr[5] = 'N';
    arr[6] = 'R';
    arr[7] = 'T';
}

int solution(int n, vector<string> data) {
    init();
    swapPerm(0, data);
    return ans;
}

int main() {
    vector<string> data;
    data.push_back("N~F=0");
    data.push_back("R~T>2");
    printf("%d", solution(2, data));
    return 0;
}