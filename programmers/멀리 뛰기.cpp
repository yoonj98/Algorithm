//https://programmers.co.kr/learn/courses/30/lessons/12914

#include <string>
#include <vector>

using namespace std;

long long solution(int n) {
	long long a, b, tmp, answer;
    a = 1;
    b = 1;
    
	if (n == 1)
		return 1;
    
	for (int i=2; i <= n; i++) {
		tmp = (a + b) % 1234567;
		a = b;
		b = tmp;
	}	
    
    answer = b % 1234567;
    
	return answer;

}