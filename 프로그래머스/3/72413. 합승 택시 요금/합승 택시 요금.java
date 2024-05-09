class Solution {
    int floyd[][];
    public int solution(int n, int s, int a, int b, int[][] fares) {
        floyd = new int[n+1][n+1];
        
        for(int i = 0; i < fares.length; i++){
            int x = fares[i][0];
            int y = fares[i][1];
            int len = fares[i][2];
            floyd[x][y] = len;
            floyd[y][x] = len;
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if (i == j){
                        continue;
                    }
                    if (floyd[i][k] == 0 || floyd[k][j] == 0){
                        continue;
                    }            
                    if (floyd[i][k] + floyd[k][j] < floyd[i][j] || floyd[i][j] == 0){
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                        floyd[j][i] = floyd[i][k] + floyd[k][j];
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i <= n; i++){
            if (check(s, i) && check(a, i) && check(b, i)){
                if (floyd[s][i] + floyd[i][a] + floyd[i][b] < answer)
                answer = floyd[s][i] + floyd[i][a] + floyd[i][b];        
            }
        }
        return answer;
    }
    
    boolean check(int a, int b){
        if (a != b && floyd[a][b] == 0){
            return false;
        }
        return true;
    }
    
    void print(int[][] arr){
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}