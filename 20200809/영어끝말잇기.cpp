//https://programmers.co.kr/learn/courses/30/lessons/12981

#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    int flag = 0;
    string str_f, str_e;
    vector<int> answer;

    for (int i = 1; i < words.size(); i++) {
        str_f = words[i - 1];
        str_e = words[i];

        if (str_f.back() != str_e.front())
            flag = 1;

        for (int j = 0; j < i; j++) {
            if (words[j] == str_e) {
                flag = 1;
                break;
            }
        }

        if (flag) {
            answer.push_back((i % n) + 1);
            answer.push_back((i / n) + 1);

            return answer;
        }
    }

    answer.push_back(0);
    answer.push_back(0);

    return answer;

}

