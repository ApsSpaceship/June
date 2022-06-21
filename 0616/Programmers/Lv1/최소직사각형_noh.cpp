#include <string>
#include <vector>

using namespace std;

// sizes를 순회하면서 가로 길이가 더 길도록 swap한 후 가로의 최대값과 세로의 최대값을 곱한다.
int solution(vector<vector<int>> sizes) {
    int maxW = 0;
    int maxH = 0;

    for (int i = 0; i < sizes.size(); i++) {
        if (sizes[i][0] < sizes[i][1])
            swap(sizes[i][0], sizes[i][1]);
        maxW = max(maxW, sizes[i][0]);
        maxH = max(maxH, sizes[i][1]);
    }

    return maxW * maxH;
}