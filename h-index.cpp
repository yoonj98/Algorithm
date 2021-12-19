#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    sort(citations.rbegin(), citations.rend()); //�������� ����

    while (answer < citations.size()) {
        if (citations[answer] <= answer)
            break;
        answer++;
    }

    return answer;

}