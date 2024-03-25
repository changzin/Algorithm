import java.util.*;

class Solution {
    public int solution(int n, int[] tops) {
        int[][] dp = new int[n][4];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        if (tops[0] == 1){
            dp[0][3] = 1;
        } 
        for(int i = 1; i < n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3]) % 10007;
            dp[i][1] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][3]) % 10007;
            dp[i][2] = dp[i][0];
            if (tops[i] == 1){
                dp[i][3] = dp[i][0];
            }
        }
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < 4; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int answer = (dp[n-1][0] + dp[n-1][1] + dp[n-1][2] + dp[n-1][3]) %10007;
        return answer;
    }
}