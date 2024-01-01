#include <iostream>
#include <vector>
#include <queue>
#include <climits>

int n, m, fuel, carX, carY;
int map[21][21];
// 승객별 목적지까지의 거리 
int customerDist[401];
// 승객별 목적지 따로 저장
std::pair<int, int> customerDest[401];
bool visit[21][21];
int dx[] = { -1, 0, 0, 1 };
int dy[] = { 0, -1, 1, 0 };

void makeVisit() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			visit[i][j] = false;
		}
	}
}

int calculateDist(int startX, int startY, int distX, int distY) {	
	std::queue<std::pair<int, std::pair<int, int>>> q;
	int x, y, nx, ny, depth;

	// 출발지 == 목적지라면 0 리턴
	if (startX == distX && startY == distY) {
		return 0;
	}

	makeVisit();
	q.push({0, {startX, startY}});
	visit[startX][startY] = true;

	while (!q.empty()) {		
		x = q.front().second.first;
		y = q.front().second.second;
		depth = q.front().first;
		q.pop();

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			// 맵 범위 계산
			if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
				// 벽이 아니고, 방문하지 않았을 때
				if (map[nx][ny] != -1 && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.push({ depth+1, {nx, ny} });
					// 목적지를 찾았을 때 거리 리턴
					if (nx == distX && ny == distY) {
						return depth + 1;
					}
				}
			}
		}
	}
	// 찾아갈 수 없을 시 -1 리턴
	return -1;
}

bool findCustomer() {
	std::queue<std::pair<int, std::pair<int, int>>> q;
	int x, y, nx, ny, depth, cx, cy, cd;
	
	makeVisit();
	cd = INT_MAX;
	q.push({ 0, {carX, carY} });
	visit[carX][carY] = true;

	while (!q.empty()) {
		x = q.front().second.first;
		y = q.front().second.second;
		depth = q.front().first;
		q.pop();

		// 연료보다 먼 곳을 탐색하거나, 현재 찾은 승객보다 먼 곳을 탐색한다면 탈출
		if (depth > fuel || depth > cd) {
			break;
		}

		// 승객을 발견했고, 출발지점까지 갈 수 있는 상황이라면
		if (map[x][y] != 0 && customerDist[map[x][y]] != -1) {
			if (cd == INT_MAX) {
				cd = depth;
				cx = x;
				cy = y;
			}
			else if (depth < cd) {
				cd = depth;
				cx = x;
				cy = y;
			}
			else if (depth == cd){
				// depth가 같을 때, x좌표가 더 작거나, x좌표가 같은데 y좌표가 작다면
				if ((cx > x) || ((cx == x && cy > y))) {
					cd = depth;
					cx = x;
					cy = y;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			// 맵 범위 계산
			if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
				// 벽이 아니고, 방문하지 않았을 때
				if (map[nx][ny] != -1 && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.push({ depth + 1, {nx, ny} });
				}
			}
		}
	}
	// 태우고 목적지까지 갈 승객이 없을 시
	if (cd == INT_MAX) {
		return false;
	}
	else {
		if (fuel - cd - customerDist[map[cx][cy]] < 0) {
			return false;
		}
		else {
			fuel = fuel - cd + customerDist[map[cx][cy]];
			carX = customerDest[map[cx][cy]].first;
			carY = customerDest[map[cx][cy]].second;
			map[cx][cy] = 0;
			return true;
		}
	}
}

int main(void) {
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::cin >> n >> m >> fuel;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			std::cin >> map[i][j];
			if (map[i][j] == 1) {
				map[i][j] = -1;
			}
		}
	}
	std::cin >> carX >> carY;
	for (int i = 1; i <= m; i++) {
		int custX, custY, distX, distY;
		std::cin >> custX >> custY >> distX >> distY;

		// map에 승객 번호 저장, customer에 목적지까지의 거리 저장
		map[custX][custY] = i;
		customerDist[i] = calculateDist(custX, custY, distX, distY);
		customerDest[i] = { distX, distY };
	}

	bool stop;
	for (int i = 0; i < m; i++) {
		// findCustomer()가 false를 반환할 시 -1 출력하고 끝남
		stop = !findCustomer();
		if (stop) {
			fuel = -1;
			break;
		}
	}
	std::cout << fuel;
	
	return 0;
}