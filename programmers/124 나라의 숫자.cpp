#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(int n) {
    int num;
    string str, answer = "";

    while (n != 0) {
        if (n % 3 == 0) {
            answer.append("4");
            n = n / 3 - 1;
        }
        else {
            num = n % 3;
            str = to_string(num);
            answer.append(str);
            n = n / 3;
        }
    }

    reverse(answer.begin(), answer.end());

    return answer;
}