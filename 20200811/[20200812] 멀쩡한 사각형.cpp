//https://programmers.co.kr/learn/courses/30/lessons/62048
//처음 아이디어 : 기울기에서 올림한 값 * 가로 = 중복 개수

using namespace std;

long long solution(int w, int h) {
	long long sum = (long long)w * (long long)h;
	int gcd, start = w < h ? w : h;

	for (int i = start; i > 0; i--) {
		if ((w % i == 0) && (h % i == 0)) { //최대 공약수 구하기
			gcd = i;
			break;
		}
	}

	return sum - gcd * ((w / gcd) + (h / gcd) - 1); //가로, 세로에서 중복되는 1 빼주기

}