class Solution {
    int[][] graph;
    boolean[][] visitRed;
    boolean[][] visitBlue;
    int n,m, count;
    boolean redIn, blueIn;
    // 빨간 수레 x-y, 파란 수레 x-y 
    int[] red = new int[2];
    int[] redDest = new int[2];
    int[] blue = new int[2];
    int[] blueDest = new int[2];
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maze) {
        graph = maze;
        n = maze.length;
        m = maze[0].length;
        visitRed = new boolean[n][m];
        visitBlue = new boolean[n][m];
        count = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (graph[i][j] == 1){
                    graph[i][j] = 0;
                    red[0] = i;
                    red[1] = j;
                    visitRed[i][j] = true;
                }
                else if (graph[i][j] == 2){
                    graph[i][j] = 0;
                    blue[0] = i;
                    blue[1] = j;
                    visitBlue[i][j] = true;
                }
                else if (graph[i][j] == 3){
                    graph[i][j] = 0;
                    redDest[0] = i;
                    redDest[1] = j;
                }
                else if (graph[i][j] == 4){
                    graph[i][j] = 0;
                    blueDest[0] = i;
                    blueDest[1] = j;
                }
            }
        }
        dfs(0);
        int answer = count;
        if (count == -1){
            answer = 0;
        }
        return answer;
    }
    
    void dfs(int weight){
        // 목적지 모두 도달했을 때 count update
        if (red[0] == redDest[0] && red[1] == redDest[1] && blue[0] == blueDest[0] && blue[1] == blueDest[1]){
            if (count == -1){
                count = weight;
            }
            else{
                count = Math.min(count, weight);
            }
            return;
        }
        // 현재 최적의 수인 count보다 많이 움직이면 그냥 리턴 
        if (count != -1 && count <= weight){
            return;
        }
        
        // 두 수레가 상하좌우로 움직이는 가짓수는 16
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                // 현재 위치를 dfs 스택에 저장
                int[] redP = new int[2];
                int[] blueP = new int[2];
                for(int k = 0;k < 2; k++){
                    redP[k] = red[k];
                    blueP[k] = blue[k];
                }
                // 움직이고
                boolean check = move(i, j);
                // dfs 실행
                if (check){                
                    dfs(weight+1);
                }
                else{
                    continue;
                }
                // 백트래킹
                backMove(redP, blueP);
            }
        }
        
    }
    
    boolean move(int dir1, int dir2){
        int rx, ry, nrx, nry, bx, by, nbx, nby;
        // 위치 저장
        rx = red[0];
        ry = red[1];
        bx = blue[0];
        by = blue[1];        
        // 빨간색 수레 이동
        if (!(red[0] == redDest[0] && red[1] == redDest[1])){
            nrx = rx + dx[dir1];
            nry = ry + dy[dir1];
            if (nrx >= 0 && nrx < n && nry >= 0 && nry < m){
                //방문을 하지 않았으며, 벽이 아닐 때 통과
                if (!visitRed[nrx][nry] && graph[nrx][nry] == 0){
                    ;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            nrx = rx;
            nry = ry;
        }
        
        // 파란색 수레 이동
        if (!(blue[0] == blueDest[0] && blue[1] == blueDest[1])){
            nbx = bx + dx[dir2];
            nby = by + dy[dir2];
            if (nbx >= 0 && nbx < n && nby >= 0 && nby < m){
                //방문을 하지 않았으며, 벽이 아니고, 파란색 수레와 겹치지 않을 때
                if (!visitBlue[nbx][nby] && graph[nbx][nby] == 0){
                    ;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            nbx = bx;
            nby = by;
        }
        
        if (nbx == rx && nby == ry && nrx == bx && nry == by){
            return false;
        }
        else if (nbx == nrx && nby == nry){
            return false;
        }
        
        // 유효한 움직임이면 위치 바꾸고 리턴
        red[0] = nrx;
        red[1] = nry;
        blue[0] = nbx;
        blue[1] = nby;
        visitRed[nrx][nry] = true;
        visitBlue[nbx][nby] = true;
        return true;
    }
    
    void backMove(int[] redP, int[] blueP){
        visitRed[red[0]][red[1]] = false;
        visitBlue[blue[0]][blue[1]] = false;
        
        for(int i = 0; i < 2; i++){
            red[i] = redP[i];
            blue[i] = blueP[i];
        }
        visitRed[red[0]][red[1]] = true;
        visitBlue[blue[0]][blue[1]] = true;
        return;
    }


    void print(){
        graph[red[0]][red[1]] = 1;
        graph[blue[0]][blue[1]] = 2;
        for(int i = 0; i < n; i++){
            for(int j  = 0 ; j< m; j++){
                System.out.print(graph[i][j] + "  ");
            }
            System.out.println();
        }
        graph[red[0]][red[1]] = 0;
        graph[blue[0]][blue[1]] = 0;
    }
}