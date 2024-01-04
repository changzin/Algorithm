#include <iostream>

int n, m, a, b, answer;
bool check, stop;
int label[500000];

void init() {
	for (int i = 0; i < n; i++) {
		label[i] = i;
	}
}

int find(int x) {
	if (label[x] == x) {
		return x;
	}
	return label[x] = find(label[x]);
}

bool merge(int x, int y) {
	int temp1, temp2;

	temp1 = find(x);
	temp2 = find(y);

	if (temp1 == temp2) {
		return true;
	}
	else {
		label[temp2] = temp1;
		return false;
	}
}

int main(void) {
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::cin >> n >> m;

	init();
	for (int i = 1; i <= m; i++) {
		std::cin >> a >> b;
		check = merge(a, b);

		if (stop) {
			continue;
		}
		if (check) {
			answer = i;
			stop = true;
		}
	}


	std::cout << answer;

	return 0;
}