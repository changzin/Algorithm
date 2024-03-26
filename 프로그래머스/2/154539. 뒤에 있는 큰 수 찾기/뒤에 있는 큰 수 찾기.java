import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            answer[i] = -1;
        }
        
        
        int index = 0;
        
        pq.add(new Pair(0, numbers[0]));
        for(int i = 1; i < numbers.length; i++){
            while(true){
                if (pq.isEmpty()) break;
                if (pq.peek().second >= numbers[i]) break;
                
                Pair p = pq.poll();
                answer[p.first] = numbers[i];
            }
            pq.add(new Pair(i, numbers[i]));
        }
        
        return answer;
    }
    
    class Pair implements Comparable<Pair>{
        public int first;
        public int second;
        
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
        
        @Override
        public int compareTo(Pair p){
            return this.second - p.second;
        }
    }    
}