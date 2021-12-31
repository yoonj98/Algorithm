//https://programmers.co.kr/learn/courses/30/lessons/62048
//ó�� ���̵�� : ���⿡�� �ø��� �� * ���� = �ߺ� ����

using namespace std;

long long solution(int w, int h) {
	long long sum = (long long)w * (long long)h;
	int gcd, start = w < h ? w : h;

	for (int i = start; i > 0; i--) {
		if ((w % i == 0) && (h % i == 0)) { //�ִ� ����� ���ϱ�
			gcd = i;
			break;
		}
	}

	return sum - gcd * ((w / gcd) + (h / gcd) - 1); //����, ���ο��� �ߺ��Ǵ� 1 ���ֱ�

}