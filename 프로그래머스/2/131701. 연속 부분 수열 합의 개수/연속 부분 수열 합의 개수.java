import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] arr = new int[elements.length];
        Set<Integer> set = new HashSet();
        
        arr[0] = elements[0];
        for(int i = 1; i < elements.length; i++){
            arr[i] = arr[i-1] + elements[i];
            if (!set.contains(arr[i])){
                set.add(arr[i]);
                answer++;
            }
        }
        
        int sum = 0;
        int nextIndex = 0;
        for (int i = 1; i <= elements.length-1; i++){
            for(int j = 0; j < elements.length; j++){
                if (j == 0) sum = arr[i-1];
                else{
                    nextIndex = (j + i-1) % elements.length; 
                    sum = sum - elements[j-1] + elements[nextIndex];
                }
                
                // System.out.printf("%d ~ %d  : %d\n", j, (j==0)?0:nextIndex, sum);
                
                if (!set.contains(sum)){
                    set.add(sum);
                    answer++;
                }
            }
        }      
        return answer;
    }
}