import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int length = a.length;
        int[] leftMinArr = new int[length];
        int[] rightMinArr = new int[length];
        
        leftMinArr[0] = a[0];
        rightMinArr[length-1] = a[length-1];
        
        if (length >= 3){
            for(int i = 1; i < length; i++){
                leftMinArr[i] = Math.min(a[i], leftMinArr[i-1]);
            }

            for(int i = length-2; i >= 0; i--){
                rightMinArr[i] = Math.min(a[i], rightMinArr[i+1]);
            }
            
            answer = 2;
            for(int i = 1; i < length-1; i++){
                if (leftMinArr[i-1] < a[i] && rightMinArr[i+1] < a[i]){
                    continue;
                }
                answer++;
            }
        }
        else{
            answer = length;
        }
        return answer;
    }
    
    public void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "");
        }
        System.out.println("");
    }
}