//https://www.acmicpc.net/problem/1157

#include<iostream>
#include<string>

using namespace std;

int main(){
	string str;
	chat answer;
	int num[26] = {0,}; 
	int i, max, flag;

	max = -1;
	flag = -1;
	
	cin >> str;

	for (i = 0; i < str.length(); i++){
		if(str[i]<97)
			num[str[i] - 65]++; 
		else
			num[str[i] - 97]++;
	}

	for (i = 0; i < 26; i++){
		if (max < num[i]){
			max = num[i];
			idx = i;
		}
	}

	for (i = 0; i < 26; i++){
		if (idx == i)
			continue;
			
		if (max == num[i]){
			cout << '?';
			return 0;
		}
	}
	
	answer = (char)(idx+65);
	cout << answer;
	
	return 0;
}