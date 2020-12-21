#include <iostream>
#include <string>
#include <vector>

int calculate(int N) {
    if (N == 1)
        return 1;
    else if (N == 2)
        return 1;
    else
        return calculate(N - 1) + calculate(N - 2);
}

long long solution(int N) {

    long long answer = 0;
    std::vector<int> side;

    for (int i = 1; i <= N; i++) 
        side.push_back(calculate(i));

    if (N > 3) {
        for (int i = N - 4; i < N; i++) {
            if (i == N - 4)
                answer += side[i] * 1;
            else if (i == N-1)
                answer += side[i] * 3;
            else
                answer += side[i] * 2;
        }
    }
    else {
        if (N == 1)
            answer = 4;
        else if (N == 2)
            answer = 6;
        else
            answer = 10;
    }
       
    return answer;
}

int main() {
    
    int N;

   std::cout << "타일의 개수를 입력하시오 : ";
   std::cin >> N;

   std::cout << solution(N) << std::endl;

    return 0;

}