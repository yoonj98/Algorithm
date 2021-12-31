//https://programmers.co.kr/learn/courses/30/lessons/12907

#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> money) {
    int answer = 0;
    d[0] = 1;
    
    for(int i=money[0]; i<=n; i+=money[0])
        d[i] = 1;

    for(int j=1; j<money.size(); j++)
        for(int i=0; i<=n; i++)
            if(i>=money[j])
                d[i] += d[i-money[j]] % 1000000007;

    answer = d[n];
    return answer;   

}