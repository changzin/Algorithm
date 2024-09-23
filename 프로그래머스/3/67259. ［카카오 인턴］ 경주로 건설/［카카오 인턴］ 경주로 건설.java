import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        
        int len = board.length;
        int x = 0;
        int y = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // 0123 : 상하좌우
        int[][][] dp = new int[25][25][4];
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                for(int k = 0; k < 4; k++){
                    if (i == 0 && j == 0){
                        continue;
                    }
                    else{
                        dp[i][j][k] = Integer.MAX_VALUE;    
                    }
                }
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 3));
        q.add(new Node(0, 0, 1));
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int nx, ny;
            
            for(int i = 0; i < 4; i++){
                // 역주행 방지욥
                if ((node.dir == 0 && i == 1) || (node.dir == 1 && i == 0) || (node.dir == 2 && i == 3) || (node.dir == 3 && i == 2)){
                    continue;
                }
                
                nx = node.x + dx[i];
                ny = node.y + dy[i];
                // 움직일 곳이 보드 안인지 확인
                if (nx >= 0 && ny >= 0 && nx < len && ny < len){
                    // 움직일 곳에 벽이 없는지 확인
                    if(board[nx][ny] != 1){
                        // 도착 비용 계산
                        int distance = dp[node.x][node.y][node.dir] + ((i == node.dir) ? 100 : 600);
                        // 계산한 비용이 현재 저장된 비용보다 적으면 갱신하고 queue에 삽입
                        if (distance < dp[nx][ny][i]){
                            dp[nx][ny][i] = distance;
                            q.add(new Node(nx, ny, i));
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < 4; i++){
            answer = Math.min(answer, dp[len-1][len-1][i]);
        }
        
        return answer;
    }
}

class Node{
    Node(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    
    public String toString(){
        return this.x + "." + this.y + " / " + this.dir;
    }
    int x;
    int y;
    int dir;
}