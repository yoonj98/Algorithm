//https://programmers.co.kr/learn/courses/30/lessons/42746

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare_first(string str_a, string str_b) {
    string a, b;
    a = str_a.at(0);
    b = str_b.at(0);

    if (a == b)
        return str_a + str_b > str_b + str_a;
    else
        return str_a > str_b;
}

string solution(vector<int> numbers) {
    string tmp, answer = "";
    vector<string> str;

    for (int i = 0; i < numbers.size(); i++)
        str.push_back(to_string(numbers[i]));

    sort(str.begin(), str.end(), compare_first);

    if (str[0] == "0")
        return "0";

    for (int i = 0; i < str.size(); i++)
        answer += str[i];

    return answer;
}