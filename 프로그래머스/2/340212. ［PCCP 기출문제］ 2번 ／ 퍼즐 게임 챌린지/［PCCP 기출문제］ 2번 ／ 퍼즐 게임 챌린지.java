class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int maxDiff = 1;
        
        for(int diff : diffs){
            maxDiff = (maxDiff <= diff) ? diff : maxDiff;
        }
        
        // binary search 구현해야한다.
        
        int l = 1;
        int r = maxDiff;
        
        
        while(l <= r){    
            int mid = (l + r) / 2;
            long solveTime = timeToSolve(diffs, times, mid);
            
            if (solveTime > limit){
                l = mid+1;
            }
            if (solveTime <= limit){
                r = mid-1;
            }
        }
        return l;
    }
    
    long timeToSolve(int[] diffs, int[] times, int level){
        long time = 0;
        long prev = 0;
        
        for(int i = 0; i < diffs.length; i++){
            if (i == 0 || level >= diffs[i]){
                time += times[i];        
            }
            else{
                time += (diffs[i] - level) * (times[i-1] + times[i]);
                time += times[i];        
            }
        }
        
        return time;
    }
}