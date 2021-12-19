//https://programmers.co.kr/learn/courses/30/lessons/12927

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(int n, vector<int> works) {
    long long answer = 0;
	int size = works.size();
	int i = size - 1;
    
	sort(works.begin(), works.end()); 
    
	while (n > 0) {
		n--;
		if (works[i] > 0)
			works[i] = works[i]-1;
		if (i == 0) {
			i--;
		}
		else { 
			if (works[i] < works[i - 1])  
				i--;
			else
				i = size - 1;
		}
	}
    
	for (int i = 0; i < size; i++)
		answer += works[i]*works[i];
    
	return answer;
    
}