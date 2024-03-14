class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        for(int i = 0; i < triangle.length; i++){
            dp[i] = new int[triangle[i].length];
            for(int j = 0; j < dp[i].length; j++){
                dp[i][j] = 0;
            }
        }
        
        dp[0] = triangle[0];
        
        for(int i = 0; i < triangle.length-1; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if (dp[i+1][j] == 0){
                    dp[i+1][j] = dp[i][j] + triangle[i+1][j];
                }
                else{                
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + triangle[i+1][j]);
                }
                if (dp[i+1][j+1] == 0){
                    dp[i+1][j+1] = dp[i][j] + triangle[i+1][j+1];
                }
                else{                
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1]);
                }                
            }
        }
        int length = triangle.length;
        int answer = 0;
        
        for(int i = 0; i< dp[length-1].length; i++){
            answer = Math.max(answer, dp[length-1][i]);
        }
        return answer;
    }
}