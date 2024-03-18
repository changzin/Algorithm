import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int dl, pl, dest, count;
        long answer = 0;
        
        pl = dl = -1;
        for(int i = deliveries.length-1; i >= 0; i--){
            if (deliveries[i] > 0 && dl == -1){
                dl = i;
            }
            if (pickups[i] > 0 && pl == -1){
                pl = i;
            }
            if (dl != -1 && pl != -1){
                break;
            }
        }
        while (dl != -1 || pl != -1){
            // 먼 곳에 있는 배달과 수거 처리
            dest = Math.max(dl, pl);
            answer = answer + ((dest+1) * 2);
            count = 0;
            while(dl != -1){
                count += deliveries[dl];
                
                if (count > cap){
                    deliveries[dl] = count-cap;
                    break;
                }
                else {
                    dl--;
                }
            }
            count = 0;
            while(pl != -1){
                count += pickups[pl];
                
                if (count > cap){
                    pickups[pl] = count - cap;
                    break;
                }
                else {
                    pl--;
                }
            }
        }
        
        return answer;
    }
    
    class Pair{
        int first;
        int second;
        
        Pair(int x, int y){
            this.first = x;
            this.second = y;
        }
    }
}