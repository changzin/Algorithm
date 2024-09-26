import java.util.*;

class Solution {
    int[] list;
    int[] label = new int[101];
    boolean[] visit = new boolean[101];
    int[] nums = new int[101];
    
    public int solution(int[] cards) {
        int answer = 0;
        list = cards;

        for(int i = 0; i < list.length; i++){
            list[i] -= 1;
            label[i] = i;
        }
        
        for(int i = 0; i < list.length; i++){
            check(i);
        }
        
        for(int i = 0; i < list.length; i++){
            nums[label[i]]++;
        }
        
        List<Integer> s = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            s.add(nums[i]);
        }
        
        s.sort((a,b)->{
            return b - a;
        });
        
        
        return s.get(0) * s.get(1);
    }
    
    int check(int x){
        visit[x] = true;
        
        if (x == list[x]){
            label[x] = x;
            return x;
        }
        if (visit[list[x]]){
            label[x] = label[list[x]];
            return label[x];
        }
        
        return label[x] = check(list[x]);
    };
}