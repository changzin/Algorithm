class Solution {
    int[][] prefix;
    int n, m;
    public int solution(int[][] board, int[][] skill) {
        n = board.length; m = board[0].length;
        prefix = new int[n+1][m+1];
        int type, r1, c1, r2, c2, degree;
        
        for(int i = 0; i < skill.length; i++){
            type = (skill[i][0] == 1) ? -1 : 1;
            r1 = skill[i][1];
            c1 = skill[i][2];
            r2 = skill[i][3];
            c2 = skill[i][4];
            degree = skill[i][5] * type;
            
            prefix[r1][c1] += degree;
            prefix[r1][c2+1] += -degree;
            prefix[r2+1][c1] += -degree;
            prefix[r2+1][c2+1] += degree;
        }
        int answer = 0;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                prefix[i][j] += prefix[i-1][j];
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                prefix[i][j] += prefix[i][j-1];
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (board[i][j] + prefix[i][j] > 0){                
                    answer++;
                }
            }
        }
        return answer;
    }
    
    void print(){
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(prefix[i][j] + " ");
            }
            System.out.println();
        }
            System.out.println();
    }
}