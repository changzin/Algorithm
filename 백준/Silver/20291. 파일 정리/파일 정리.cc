#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>

int n;
std::string temp;
std::map<std::string, int> map;
std::vector<std::string> format;

int main(void) {
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::cin >> n;
	for (int i = 0; i < n; i++) {
		std::cin >> temp;
		std::string result = temp.substr(temp.find('.')+1, -1);
		if (map[result] == 0) {
			format.push_back(result);
		}
		map[result] += 1;
	}

	std::sort(format.begin(), format.end());

	for (int i = 0; i < format.size(); i++) {
		std::cout << format[i] << " " << map[format[i]] << std::endl;
	}

	return 0;
}