//https://programmers.co.kr/learn/courses/30/lessons/12939

#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

vector<int> split(string str, char delimiter) {
    int temp;
    vector<int> internal;
    stringstream ss(str);
    string tmp;

    while (getline(ss, tmp, delimiter)) {
        temp = atoi(tmp.c_str());
        internal.push_back(temp);
    }

    return internal;

}

string solution(string s) {
    int max, min;
    string str_max, str_min, answer = "";
    vector<int> split_int = split(s, ' ');

    sort(split_int.begin(), split_int.end(), greater<int>());
    answer += to_string(split_int.back());
    answer += " ";
    answer += to_string(split_int.front());

    return answer;

}