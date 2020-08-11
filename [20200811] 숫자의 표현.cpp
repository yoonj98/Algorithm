//https://programmers.co.kr/learn/courses/30/lessons/12924

#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int half, sum, answer = 0;
    half = n / 2 + 1;

    for (int i = 1; i < half; i++) {
        sum = 0;
        for (int j = i; j < n; j++) {
            sum += j;
            if (sum == n) {
                answer++;
                break;
            }
            else if (sum > n)
                break;
        }
    }

    answer++;   //자기 자신

    return answer;

}