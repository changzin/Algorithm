import java.util.*;

class Solution {
    int n, m;
    int[][] graph;
    int[] gasY;
    boolean[][] visit;
    boolean[] visitY;
    Queue<Node> q = new LinkedList();
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int solution(int[][] land) {
        graph = land;
        n = land.length;
        m = land[0].length;
        gasY = new int[m];
        visit = new boolean[n][m];
        visitY = new boolean[m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (!visit[i][j] && graph[i][j] == 1){
                    bfs(i, j);
                }
            }
        }
                
        int answer = 0;
        
        for(int i = 0; i < m; i++){
            answer = Math.max(answer, gasY[i]);
        }
        
        return answer;
    }
    
    void bfs(int sx, int sy){
        int count = 1;
        int nx, ny, x, y;
        initVisit();
        
        q.add(new Node(sx, sy));
        visit[sx][sy] = true;
        visitY[sy] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.x;
            y = node.y;
            
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if (!visit[nx][ny] && graph[nx][ny] == 1){
                        visit[nx][ny] = true;
                        visitY[ny] = true;
                        count++;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            if (visitY[i]){
                gasY[i] += count;
            }
        }
    }
    
    void initVisit(){
        for(int i = 0; i < m; i++){
            visitY[i] = false;
        }
    }
    
    void print(){
        for(int i = 0; i < m; i++){
            System.out.print(gasY[i] + " ");
        }
        System.out.println();
    }
    
    class Node {
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}