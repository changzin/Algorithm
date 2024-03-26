import java.util.*;

class Solution {
    int n, m, startX, startY;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int map[][] = new int[50][50];
    public int[] solution(String[] park, String[] routes) {
        n = park.length;
        m = park[0].length();
        StringTokenizer st;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (park[i].charAt(j) == 'S'){
                    startX = i; startY = j;
                }
                else if (park[i].charAt(j) == 'X') map[i][j] = -1;
            }
        }
        
        for(int i = 0; i < routes.length; i++){
            st = new StringTokenizer(routes[i], " ");
            String temp = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            int dir = 0;
            if (temp.equals("E")) dir = 0;
            else if (temp.equals("S")) dir = 1;
            else if (temp.equals("W")) dir = 2;
            else dir = 3;
            
            move(dist, dir);
            
        }
        int[] answer = {startX, startY};
        return answer;
    }
    
    void move(int dist, int dir){
        int nx, ny;
        boolean check = true;
        
        nx = ny = 0;
        for(int i = 1; i <= dist; i++){
            nx = startX + (dx[dir] * i);
            ny = startY + (dy[dir] * i);
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) check = false;
            else if(map[nx][ny] == -1) check = false;
        }
        if (check){
            startX = nx;
            startY = ny;
        }
    }
}