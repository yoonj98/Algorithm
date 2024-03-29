#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int flag, answer = 0;
    string str, tmp;

    for (int i = 0; i < skill_trees.size(); i++) { 
        tmp = "";
        flag = 0;
        str = skill_trees[i];

        for (int t = 0; t < str.length(); t++) {
            for (int j = 0; j < skill.length(); j++) {           
                if (skill.at(j) == str.at(t))
                    tmp += str.at(t);
            }
        }

        for (int k = 0; k < tmp.length(); k++) {
            if (tmp.at(k) == skill.at(k))
                flag++;
        }

        if (flag == tmp.length())
            answer++;

    }

    return answer;

}