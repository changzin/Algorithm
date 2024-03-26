import java.util.*;

class Solution {
    // bfs를 돌리기 위한 기본 요소들
    int n, m;
    int[][] map = new int[100][100];
    boolean[][] visit = new boolean[100][100];
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    Queue<Node> q = new LinkedList<>();
    
    public int solution(String[] maps) {
        n = maps.length; m = maps[0].length();
        
        int startX, startY, leverX, leverY, endX, endY;
        startX = startY = leverX = leverY = endX = endY = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (maps[i].charAt(j) == 'S') {
                    startX = i; startY = j;
                }
                else if (maps[i].charAt(j) == 'L'){
                    leverX = i; leverY = j;
                }
                else if (maps[i].charAt(j) == 'E'){
                    endX = i; endY = j;                       
                }
                else if (maps[i].charAt(j) =='X') map[i][j] = -1;
            }
        }
        
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int answer = -1;

        int first = bfs(startX, startY, leverX, leverY);
        if (first != -1){
            int second = bfs(leverX, leverY, endX, endY);    
            if (second != -1){
                answer = first + second;
            }
        }
        
        return answer;
    }
    
    int bfs(int sx, int sy, int ex, int ey){
        int x, y, weight, nx, ny;
        q.add(new Node(sx, sy, 0));
        visit[sx][sy] = true;
        initVisit();
        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.x;
            y = node.y;
            weight = node.weight;
            
            if (x == ex && y == ey){
                clearQ();
                return weight;
            }
            
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if (!visit[nx][ny] && map[nx][ny] != -1){
                        visit[nx][ny] = true;
                        q.add(new Node(nx, ny, weight+1));
                    }
                }
            }
        }
        return -1;   
    }
    
    
    void initVisit(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visit[i][j] = false;
            }
        }
    }
    
    void clearQ(){
        while(!q.isEmpty()){
            q.poll();
        }
    }
    
    class Node{
        int x;
        int y;
        int weight;
        Node(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}