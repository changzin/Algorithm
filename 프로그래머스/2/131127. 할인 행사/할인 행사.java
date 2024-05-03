import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;
        int[][] arr = new int[discount.length][number.length];
        for(int i = 0; i < want.length; i++){
            map.put(want[i], i);
        }
        int past = -1;
        
        for(int i = 0; i < discount.length; i++){
            if (i != 0){
                for(int j = 0; j < number.length; j++){
                    arr[i][j] = arr[i-1][j];
                }
            }
            if (map.containsKey(discount[i])){
                int x = map.get(discount[i]);
                arr[i][x]++;
            }
        }
        
        for(int i = 0; i < discount.length; i++){
            int idx = i + 9;
            if (idx >= discount.length){
                idx = discount.length-1;
                boolean check = true;
                for(int j = 0; j < number.length; j++){
                    int x = (i != 0) ? arr[idx][j] - arr[i-1][j] : arr[idx][j];
                    if (number[j] > x){
                        check = false;
                    }
                }
                if (check){
                    answer++;
                }
            }
            else{
                boolean check = true;
                for(int j = 0; j < number.length; j++){
                    int x = (i != 0) ? arr[idx][j] - arr[i-1][j] : arr[idx][j];
                    if (number[j] > x){
                        check = false;
                    }
                }
                if (check){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}