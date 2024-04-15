import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] arrA = new int[10001];
        int[] arrB = new int[10001];
        int numA, numB;
        numA = numB = 0;
        
        for(int i = 0; i < topping.length; i++){
            arrA[topping[i]]++;
            if (arrA[topping[i]] == 1){
                numA++;
            }
        }
        for(int i = 0; i < topping.length; i++){
            arrA[topping[i]]--;
            arrB[topping[i]]++;
            if (arrA[topping[i]] == 0){
                numA--;
            }
            if (arrB[topping[i]] == 1){
                numB++;
            }
            if (numA==numB){
                answer++;
            }
        }
        
        
        return answer;
    }
}