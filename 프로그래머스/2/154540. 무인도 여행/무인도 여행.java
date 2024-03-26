import java.util.*;

class Solution {
    int n, m;
    int[][] map = new int[100][100];
    boolean[][] visit = new boolean[100][100];
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int weight;
    
    public int[] solution(String[] maps) {
        n = maps.length; m = maps[0].length();
        List<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (maps[i].charAt(j) == 'X') map[i][j] = -1;
                else map[i][j] = maps[i].charAt(j) - '0';
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (!visit[i][j] && map[i][j] != -1){
                    weight = 0;
                    dfs(i, j);
                    arr.add(weight);
                }
            }
        }
        
        int[] answer;
        if (arr.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            arr.sort((a,b) -> a-b);
            answer = new int[arr.size()];
            for(int i = 0; i < arr.size(); i++){
                answer[i] = arr.get(i);
            }
        }
        return answer;
    }
    
    void dfs(int x, int y){
        int nx, ny;
        
        visit[x][y] = true;
        weight += map[x][y];
        
        for(int i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                if (!visit[nx][ny] && map[nx][ny] != -1){
                    dfs(nx, ny);
                }
            }
        }
        
        return;
    }
    
}