#include <vector>
using namespace std;
 
int dfs(vector<vector<int>>& computers, int n) {
	int i;
	
	if (!computers[n][n])    //이미 순회한 경우 >> 종료조건
		return 0;
	else{		//아닌 경우
		computers[n][n] = 0;
    
		for (i = 0; i < computers.size(); i++){
			if (computers[n][i])    
				dfs(computers, i);	//재귀
		}
		return 1;
	}
}
 
int solution(int n, vector<vector<int>> computers) {
	int i, answer = 0;
    
	for (i = 0; i < n; i++) {
		if (computers[i][i] && dfs(computers, i))        
			answer++;
	}
    
	return answer;
    
}