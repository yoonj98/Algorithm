//https://www.acmicpc.net/problem/1032

#include<iostream>
#include<string>

using namespace std;
 
int main() {
    int num, check, i, j;
    string str[51];
    
    check = 0;
    cin >> num;
    
    for(i = 0; i<str[0].length(); ++i, check = 0){
    	for(j = 0; j < num; ++j){
    		if(str[0].at(i) != str[j].at(i)){
    			check = 1;
    			cout << "?";
    			break;
    		}
    	}
    	
    	if(!check)
		cout<<str[0][i];
		
    }
    
    return 0;
    
}