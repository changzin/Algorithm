#include <iostream>
#include <vector>
#include <queue>

int N, K, R, r1, c1, r2, c2, x, y, answer;
int map[101][101];
std::vector<std::pair<int, int>> ways[101][101];
std::vector<std::pair<int, int>> cows;
std::queue<std::pair<int, int>> q;
bool visit[101][101];
int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };
bool checkCowRelation[100][100];


void print() {
	std::cout << std::endl << "소의 관계도" << std::endl;
	for (int i = 0; i < K; i++) {
		for (int j = 0; j < K; j++) {
			std::cout << checkCowRelation[i][j] << " ";
		}
		std::cout << std::endl;
	}
	std::cout << "소 위치 표시" << std::endl;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			std::cout << map[i][j] << " ";
		}
		std::cout << std::endl;
	}
}

void init() {
	for (int i = 1; i < 101; i++) {
		for (int j = 1; j < 101; j++) {
			map[i][j] = -1;
		}
	}
}

void makeVisit() {
	for (int i = 1; i < 101; i++) {
		for (int j = 1; j < 101; j++) {
			visit[i][j] = false;
		}
	}
}

void makeAnswer() {
	for (int i = 0; i < K-1; i++) {
		for (int j = i+1; j < K; j++) {
			if (!checkCowRelation[i][j]) {
				answer++;
			}
		}
	}
}

void bfs(int cow) {
	int x, y, nx, ny;
	bool check;
	// 소의 좌표를 q에 넣고 bfs 시작
	q.push(std::make_pair(cows[cow].first, cows[cow].second));
	visit[cows[cow].first][cows[cow].second] = true;

	while (!q.empty()) {
		x = q.front().first;
		y = q.front().second;
		q.pop();

		if (map[x][y] != -1) {
			// 길을 통하지 않아도 갈 수 있다면, 소의 사이를 true로 전환
			checkCowRelation[cow][map[x][y]] = true;
		}
		for (int i = 0; i < 4; i++){
			nx = x + dx[i];
			ny = y + dy[i];
			check = true;
			if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
				for (int j = 0; j < ways[x][y].size(); j++) {
					if (ways[x][y][j].first == nx && ways[x][y][j].second == ny){
						check = false;
						break;
					}
				}
				if (check && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.push(std::make_pair(nx, ny));
				}
			}
		}
	}
}

int main(void) {
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::cin >> N >> K >> R;

	// 목초지 사이에 길이 있는지 판단하기 위해 ways에 저장
	for (int i = 0; i < R; i++) {
		std::cin >> r1 >> c1 >> r2 >> c2;
		ways[r1][c1].push_back(std::make_pair(r2, c2));
		ways[r2][c2].push_back(std::make_pair(r1, c1));
	}

	init();
	// 소 위치 체크
	for (int i = 0; i < K; i++){
		std::cin >> x >> y;
		map[x][y] = i;
		cows.push_back(std::make_pair(x, y));
	}

	for (int i = 0; i < K; i++) {
		makeVisit();
		bfs(i);
	}
	makeAnswer();
	std::cout << answer << std::endl;;
	return 0;
}