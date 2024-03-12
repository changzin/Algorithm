#include <iostream>
#include <queue>
#include <map>
#include <vector>
int t, k, num, cnt;
char temp;

int main(void) {
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::cin >> t;
	for (int j = 0; j < t; j++) {
		std::map <int, int> ma;
		std::priority_queue<int> max_heap;
		std::priority_queue<int, std::vector<int>, std::greater<int>> min_heap;
		cnt = 0;
		std::cin >> k;
		for (int i = 0; i < k; i++) {
			std::cin >> temp >> num;
			if (temp == 'I') {
				ma[num]++;
				cnt++;
				max_heap.push(num);
				min_heap.push(num);
			}
			else {
				if (cnt == 0) {
					continue;
				}
				else if (num == 1) {
					while (ma[max_heap.top()] < 1) {
						max_heap.pop();
					}
					ma[max_heap.top()]--;
					cnt--;
					max_heap.pop();
				}
				else {
					while (ma[min_heap.top()] < 1){
						min_heap.pop();
					}
					ma[min_heap.top()]--;
					cnt--;
					min_heap.pop();
				}
			}						
		}
		if (cnt == 0) {
			std::cout << "EMPTY" << '\n';
		}
		else {
			while (ma[max_heap.top()] < 1) {
				max_heap.pop();
			}
			while (ma[min_heap.top()] < 1) {
				min_heap.pop();
			}
			std::cout << max_heap.top() << " " << min_heap.top() << '\n';
		}
	}	
	return 0;
}