import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int ans1 = 0;
        int now1 = Integer.MIN_VALUE;
        
        int ans2 = 0;
        int now2 = Integer.MAX_VALUE;
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        for(int i = 0; i < routes.length; i++){
            if (now1 < routes[i][0]){
                now1 = routes[i][1];
                ans1++;
            }            
        }
        return answer = ans1;
    }
}