//https://programmers.co.kr/learn/courses/30/lessons/12904?language=cpp

#include <string>
#include <algorithm>

using namespace std;

int solution(string s)
{
	int answer = 1;
	int start, len = s.length();

	while (len > 1) {
        start = 0;
		for (int i = 0; i <= s.length()-len; i++) {
			bool flag = false;

			if (len % 2 != 0) { //홀수일 때
				for (int j = 0; j < len / 2; j++) {
					if (s.at(i+j) != s.at(i+len / 2 * 2 - j)) {
						flag = true;
						break;
					}
				}
                
				if (!flag)
					return len;
                
			}
			else {  //짝수일 때
				for (int j = 0; j < len / 2; j++) {
					if (s.at(i+j) != s.at(i+len / 2 * 2 -1 - j)) {
						flag = true;
						break;
					}
				}
                
				if (!flag)
					return len;
                
			}
		}
        
		len--;
        
	}
    
	return answer;
    
}