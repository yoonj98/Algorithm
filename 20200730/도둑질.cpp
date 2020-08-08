#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

int solution(std::vector <int> money) {

	int size = money.size();
	int answer = 0;
	int max = 0;

	std::vector<int> first(size);
	std::vector<int> next(size - 1);

	first[0] = money[0];
	first[1] = money[0];

	next[0] = 0;
	next[1] = money[1];

	if (size == 3) {
		max = money[0];
		for (int i = 1; i < 3; i++)
			if (max < money[i])
				max = money[i];
		answer = max;
	}
	else if (size == 4)
		answer = std::max((money[0] + money[2]), (money[1] + money[3]));
	else {
		for (int i = 2; i < size - 1; i++)
			first[i] = std::max(money[i] + first[i - 2], first[i - 1]);
		for (int i = 2; i < size; i++)
			next[i] = std::max(money[i] + next[i - 2], next[i - 1]);

		answer = std::max(first[size - 2], next[size - 1]);
	}

	return answer;
}