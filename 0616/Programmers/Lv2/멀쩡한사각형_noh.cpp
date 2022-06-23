#include <iostream>
using namespace std;

int GCD(int a, int b) {
    if (b == 0)
        return a;
    return GCD(b, a % b);
}

long long solution(int w, int h) {
    if (w < h)
        swap(w, h);
    int gcd = GCD(w, h);
    return (long long)w * h - gcd * ((w + h) / gcd - 1);
}