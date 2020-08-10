#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    int num = 0;

    for (int i = 0; i < s.size(); i++) {
        if (!num) {
            s[i] = toupper(s[i]);
            num++;
        }
        else
            s[i] = tolower(s[i]);

        if (s[i] == ' ')
            num = 0;

    }

    return s;

}