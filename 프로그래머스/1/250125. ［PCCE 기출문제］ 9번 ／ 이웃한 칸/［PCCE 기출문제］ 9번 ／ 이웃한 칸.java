class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(String[][] board, int h, int w) {
        
        int nx, ny, n, m;
        n = board.length;
        m = board[0].length;
        String str = board[h][w];
        int answer = 0;
        
        for(int i = 0; i < 4; i++){
            nx = h + dx[i];
            ny = w + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                if(str.equals(board[nx][ny])){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}