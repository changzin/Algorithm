class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int)(right - left) + 1;
        int[] answer = new int[length];
        int row, column, idx;
        idx = 0;
        
        for(long i = left; i <= right; i++){
            row = (int)(i / n)+1;
            column = (int)(i % n)+1;
            
            answer[idx] = Math.max(row, column);
            idx++;
            
        }
        
        
        return answer;
    }
}