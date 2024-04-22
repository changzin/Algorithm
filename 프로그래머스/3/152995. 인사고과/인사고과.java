import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        List<Score> arr = new ArrayList<>();
        boolean[] canIncentive = new boolean[scores.length];
        canIncentive[0] = true;
        
        for(int i = 0; i < scores.length; i++){
            arr.add(new Score(scores[i][0], scores[i][1], i));
        }
        
        arr.sort((a, b)-> {
            if (b.first == a.first){
                return a.second - b.second;
            }
            return b.first - a.first;
        });
        
        int maxA = arr.get(0).second;
        int lastA = arr.get(0).first;
        
        for(int i = 1; i < arr.size(); i++){
            Score temp = arr.get(i);
            if (temp.first < lastA && temp.second < maxA){
                temp.check = false;
            }
            else {
                lastA = temp.first;
                maxA = temp.second;
            }
        }
        
        arr.sort((a,b)->b.sum-a.sum);
        
        
        int ind=0;
        int last = 0;
        int gap = 0;
        
        for(int i = 0; i < arr.size(); i++){
            // System.out.printf("%d  %d %s  %d %d\n", arr.get(i).first, arr.get(i).second, arr.get(i).check, ind, gap);
            
            if (!arr.get(i).check){
                if (arr.get(i).index == 0){
                    ind = -1;
                    break;
                }
                continue;
            }
            
            if (i == 0){
                ind++;
                last = arr.get(i).sum;
            }
            else if (arr.get(i).sum != last){
                ind += gap+1;
                gap = 0;
                last = arr.get(i).sum;
            }
            else{
                gap++;
            }
            
            
            if (arr.get(i).index == 0){
                break;
            }
        }
        
//         for(int i = 0; i < canIncentive.length; i++){
//             System.out.println(canIncentive[i]);
//         }
        
        int answer = ind;
        return answer;
    }
}

class Score{
    int first;
    int second;
    int sum;
    int index;
    boolean check;
    
    Score(int first, int second, int index){
        this.first = first;
        this.second = second;
        this.index = index;
        this.sum = first + second;
        check = true;
    }
}