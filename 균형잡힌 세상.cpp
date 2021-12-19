//https://www.acmicpc.net/problem/4949

#include <iostream>
#include <string>
#include <stack>

using namespace std;

string check(stirng str){
	stack<char> st;
	char ch = ' ';
	
	for(int i=0; i<str.length(); i++){
		if(st.empty() && (str[i] == ')' || str[i] == ']'))
			return "NO";
		if(str[i] == '(' || str[i] == '[' ){
			st.push(str[i]);
			ch = str[i];
		}
		if((ch == '(' && str[i] == ')') || (ch == '[' && str[i] == ']')){
			st.pop();
			if(!st.empty())
				ch = st.top();
		}
	}
	
	if(st.empty())
		return "YES";
	else
		return "NO";
}

int main(){
	string str;
	
	while(1){
		getline(cin, str);
		if(str == ".")
			break;
		
		cout<<check(str) << endl;
	}
	return 0;
}