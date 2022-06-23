using namespace std;

long long solution(int price, int money, int count) {
    long long cost = (1LL + count) * count / 2 * price;
    return cost <= money ? 0 : cost - money;
}