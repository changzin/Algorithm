import java.util.*;

class Solution {
    int startX, startY, endX, endY;
    int[][] map = new int[102][102];
    boolean[][] air = new boolean[102][102];
    boolean[][] visit = new boolean[102][102];
    int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    Queue<Node> q = new LinkedList();
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        startX = characterX*2;
        startY = characterY*2;
        endX = itemX*2;
        endY = itemY*2;
        for(int i = 0; i < rectangle.length; i++){
            int ax = rectangle[i][0]*2;
            int ay = rectangle[i][1]*2;
            int bx = rectangle[i][2]*2;
            int by = rectangle[i][3]*2;
            for(int j = ax; j <= bx; j++){
                for(int k = ay; k <= by; k++){
                    map[j][k] = 1;
                }
            }
        }
        // 빈 공간 체크완료
        airBfs();
        
        bfs();
        
        int answer = (map[endX][endY]-1) /2;
        return answer;
    }
    
    public void airBfs(){
        q.add(new Node(0,0));
        air[0][0] = true;
        while(!q.isEmpty()){
            int nx, ny, x, y;
            Node node = q.poll();
            x = node.x;
            y = node.y;
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx>=0 && nx <= 101 && ny >= 0 && ny <= 101){
                    if (!air[nx][ny] && map[nx][ny] == 0){
                        q.add(new Node(nx, ny));
                        air[nx][ny] = true;
                    }
                }
            }
        }
    }
    
    public void bfs(){
        q.add(new Node(startX, startY));
        visit[startX][startY] = true;
        while(!q.isEmpty()){
            int x, y, nx, ny;
            Node node = q.poll();
            x = node.x;
            y = node.y;
            
            if (x == endX && y == endY){
                break;
            }
            
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx >= 1 && nx <= 100 && ny >= 1 && ny <= 100){
                    if (!air[nx][ny] && map[nx][ny] == 1){
                        int cx, cy;
                        boolean check = false;
                        for(int j = 0; j < 8; j++){
                            cx = nx + dx[j];
                            cy = ny + dy[j];
                            if (air[cx][cy]){
                                check = true;
                                break;
                            }
                        }
                        if (check){
                            q.add(new Node(nx, ny));
                            visit[nx][ny] = true;
                            map[nx][ny] = map[x][y]+1;
                        }
                    }
                }
            }
            
        }
    }
    
    public void printVisit(){
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 30; j++){
                int num = (visit[i][j])?1:0;
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    public void printMap(){
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 30; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void printAir(){
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 30; j++){
                int num = (air[i][j])?1:0;
                System.out.print(num + " ");
            }
            System.out.println();
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