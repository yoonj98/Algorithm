//https://programmers.co.kr/learn/courses/30/lessons/42842

#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;

    for (int i = (brown + yellow); i > 2; i--) {  //����
        if ((brown + yellow) % i == 0) { //���� >> �ð� �ʰ� ���� ���۸�
            int j = (brown + yellow) / i;
            if ((i - 2) * (j - 2) == yellow) {
                answer.push_back(i);
                answer.push_back(j);
                break;
            }
        }
    }

    return answer;

}