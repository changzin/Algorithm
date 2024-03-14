import java.util.*;

class Solution {
    Queue<Node> q = new LinkedList();
    boolean[][] visit;
    int n, m;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n][m];
        maps[n-1][m-1] = -3;
        bfs(maps);
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(maps[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int answer = -1;
        if (maps[n-1][m-1] != -3){
            answer = maps[n-1][m-1];
        }
        return answer;
    }
    
    void bfs(int[][] map){
        int nx, ny, x, y;
        q.add(new Node(0,0));
        visit[0][0] = true;
        map[0][0] = 1;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.x;
            y = node.y;
            
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if (!visit[nx][ny] && map[nx][ny] != 0){
                        map[nx][ny] = map[x][y] + 1;
                        visit[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
    }
    
    class Node{
        public int x;
        public int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}