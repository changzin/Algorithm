import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        long lk = Long.valueOf(K);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long first, second;
        int answer = 0;
        for(int i = 0; i < scoville.length; i++){
            pq.add(Long.valueOf(scoville[i]));
        }
        
        while(true){
            first = pq.poll();
            second = pq.poll();
            
            if (first >= lk){
                break;
            }
            
            pq.add(first + (second * 2));
            answer++;
            
            if (pq.size()==1){
                break;
            }
        }
        if (!pq.isEmpty() && pq.poll() < lk){
            answer = -1;
        }
        System.out.println(pq.size());
        return answer;
    }
}