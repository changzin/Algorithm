import java.util.*;

class Solution {
    long[][] dp;
    boolean[][] visit;
    public int solution(int m, int n, int[][] puddles) {
        dp = new long[n+1][m+1];
        
        for(int i = 0; i < puddles.length; i++){
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        dp[1][1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if (i == 1 && j == 1){
                    continue;
                }
                else if (dp[i][j] == -1){
                    continue;
                }
                else{
                    if (i > 1 && i <= n){
                        if (dp[i-1][j] != -1){
                            dp[i][j] = (dp[i][j] + dp[i-1][j]) % 1000000007;
                        }
                    }
                    if (j > 1 && j <= m){
                        if (dp[i][j-1] != -1){
                            dp[i][j] = (dp[i][j] + dp[i][j-1]) % 1000000007;
                        }
                    }
                }
            }
        }
        
        
        // for(int i = 1; i<= n; i++){
        //     for(int j = 1; j <= m; j++){
        //         System.out.printf("%d ", dp[i][j]);
        //     }
        //     System.out.println();
        // }
        int answer = (int)dp[n][m];
        return answer;
    }
}