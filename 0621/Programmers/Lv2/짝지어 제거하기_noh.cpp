#include <iostream>
#include <string>
#include <stack>
using namespace std;

int solution(string s) {
    stack<char> st;
    for (int i = 0; i < s.length(); i++) {
        //스택이 비어있거나 스택의 top과 문자가 다르면 스택에 push
        if (st.empty() || st.top() != s[i])
            st.push(s[i]);
        //아니면 pop
        else
            st.pop();
    }
    //전부 제거했으면 1 반환
    if (st.empty())
        return 1;
    //남아있으면 0 반환
    return 0;
}