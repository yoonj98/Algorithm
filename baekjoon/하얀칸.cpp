//https://www.acmicpc.net/problem/1100

#include <iostream>

using namespace std;

int main(){
	char array[8][8];
	int cnt = 0;
	
	for(int i=0;i<8;i++){
		for(int j=0;j<8;j++){
			cin >> array[i][j];
			if(array[i][j] == 'F' || array[i][j] == 'f'){
				if(i%2 == 0 && j%2 == 0)
					cnt++;
				else if(i%2 == 1 && j%2 == 1)
				cnt++;
			}
		}
	}
	
	cout << cnt << endl;
	return 0;
}