class Solution {
    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < sizes.length; i++){
            if (sizes[i][0] > sizes[i][1]){
                x = Math.max(x, sizes[i][0]);
                y = Math.max(y, sizes[i][1]);
            }
            else{
                x = Math.max(x, sizes[i][1]);
                y = Math.max(y, sizes[i][0]);
            }
        }
        
        
        int answer = x * y;
        return answer;
    }
}