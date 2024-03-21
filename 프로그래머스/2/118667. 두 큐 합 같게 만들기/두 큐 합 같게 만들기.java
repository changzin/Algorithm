import java.util.*;

class Solution {

    Queue<Long> q1 = new LinkedList<>();
    Queue<Long> q2 = new LinkedList<>();
    long sum1, sum, middle;
    int count = 0;
    
    public int solution(int[] queue1, int[] queue2) {
        for(int i = 0; i < queue1.length; i++){
            q1.add((long)queue1[i]);
            sum1 += (long)queue1[i];
            sum += (long)queue1[i];
        }
        for(int j = 0; j < queue2.length; j++){
            q2.add((long)queue2[j]);
            sum+=(long)queue2[j];
        }
        middle = sum / 2;
        int answer = -1;
        if (sum % 2 == 0){
            long num;
            while(count <= queue1.length + queue2.length + 2){
                if (sum1 > middle){
                    num = q1.poll();
                    sum1 -= num;
                    q2.add(num);
                }
                else if (sum1 < middle){
                    num = q2.poll();
                    sum1 += num;
                    q1.add(num);
                }
                else{
                    answer = count;
                    break;
                }
                count++;
            }
        }
        
        
        return answer;
    }
    
    
}