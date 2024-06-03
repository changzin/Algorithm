import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        boolean[] visit = new boolean[26];
        
        List<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < skill.length(); i++){
            char c = skill.charAt(i);
            visit[(int)(c - 'A')] = true;    
            arr.add((int)(c - 'A'));
        }
        
        int answer = 0;
        
        
        for(int i = 0; i < skill_trees.length; i++){
            
            boolean check = true;
            int index = 0;
            boolean[] visitSec = new boolean[26];
            
            for(int j = 0; j < skill_trees[i].length(); j++){
                if (index >= arr.size()-1){
                    continue;
                }
                int num = (int)(skill_trees[i].charAt(j) - 'A');
                if (visit[num]){
                    if (arr.get(index) != num){
                        check = false;
                        break;
                    }
                    else{
                        index++;
                        visitSec[num] = true;
                    }
                }
            }
            if (check){
                answer++;
            }
            
        }
        
        
        return answer;
    }
}