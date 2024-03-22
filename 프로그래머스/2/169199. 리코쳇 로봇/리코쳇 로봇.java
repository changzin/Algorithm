import java.util.*;

class Solution {
    int n, m;
    int startX, startY;
    int endX, endY;
    boolean[][] visit = new boolean[100][100]; 
    int[][] map = new int[100][100];
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int ans = Integer.MAX_VALUE;
    Queue<Node> q = new LinkedList();
    
    public int solution(String[] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                char c = board[i].charAt(j);
                if (c == '.')
                    map[i][j] = 0;
                else if (c == 'D')
                    map[i][j] = -1;
                else if (c =='R'){
                    startX = i; startY = j;
                }
                else if (c == 'G'){
                    endX = i; endY = j;
                }
            }
        }
        n = board.length;
        m = board[0].length();
        
        bfs();
        int answer;
        if (ans == Integer.MAX_VALUE){
            answer = -1;
        }
        else{
            answer = ans;
        }
        return answer;
    }
    
    
    void bfs(){
        q.add(new Node(startX, startY, 0));
        visit[startX][startY] = true;
                
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int weight = node.weight;
            int nx, ny;

            // 목표지점 도달 시 정답 업데이트
            if (x == endX && y == endY){
                ans = weight;
                break;
            }
            for(int i = 0; i < 4; i++){
                nx = x;
                ny = y;
                // 쭉 갈 수 있는데까지 가기
                while(true){
                    int nnx = nx + dx[i];
                    int nny = ny + dy[i];
                    if (nnx >= 0 && nnx < n && nny >= 0 && nny < m){
                        if (map[nnx][nny] != -1){
                            nx = nnx;
                            ny = nny;    
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
                // 갈 수 있는곳이 방문한곳이라면 그냥 넘어가기
                if (!visit[nx][ny]){
                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny, weight+1));
                }
                else{
                    continue;
                }
            }

        }
        
    }
    class Node{
        public int x;
        public int y;
        public int weight;
        
        Node(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
    
}