import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 0; i < enemy.length; i++){            
            sum += enemy[i];
            pq.add(-enemy[i]);
            
            // System.out.printf("현재 enemy : %d, sum : %d, pq.peek() = %d\n", enemy[i], sum, -pq.peek());
            
            if (sum > n && k != 0){
                // System.out.println("pq에서 뺴준다");
                sum -= -pq.poll();
                k--;
            }
            else if (sum > n && k == 0){
                // System.out.println("더이상 뺼 수 없다");
                answer = i;
                break;
            }
            
            if (i == enemy.length-1){
                // System.out.println("끝가지 왔다");
                
                answer = enemy.length;
            }
        }
        
        return answer;
    }
}