import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> p = new LinkedList();
        Queue<Integer> s = new LinkedList();
        List<Integer> arr = new ArrayList<>();
        
        int time = 1;
        for(int i = 0; i < progresses.length; i++){
            p.add(progresses[i]);
            s.add(speeds[i]);
        }
        
        while(!p.isEmpty()){
            int num = 0;
            while(!p.isEmpty()){
                int hp = p.element();
                int hs = s.element();
                if (hp + (hs * time) >= 100){
                    num++;
                    p.remove();
                    s.remove();
                }   
                else{
                    break;
                }
            }
            
            if (num != 0){
                arr.add(num);
            }
            time++;
        }
        
        
        int answer[] = new int[arr.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}