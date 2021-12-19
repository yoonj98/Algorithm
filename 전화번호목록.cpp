#include <string>
#include <vector>

bool solution(std::vector<std::string> phone_book) {
    int flag, cnt, j, i = 0;
    std::string str1, str2;
    bool answer = true;

    while (i != phone_book.size()) {
        j = 0;
        while (j != phone_book.size()) {
            if (i != j) {
                if (phone_book[i].length() <= phone_book[j].length()) {
                    flag = 0;
                    cnt = 0;
                    str1 = phone_book[i];
                    str2 = phone_book[j];

                    while (flag != str1.length()) {
                        if (str1.at(flag) != str2.at(flag))
                            break;
                        else {
                            cnt++;
                            answer = false;
                        }
                        flag++;
                    }
                    if (cnt == str1.length() && answer == false)
                        return false;
                }
            }
            j++;
        }
        i++;
    }
    return true;
}