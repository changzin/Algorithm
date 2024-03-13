import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> arr = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            String str = numbers[i] + "";
            arr.add(str);     
        }
        arr.sort((a,b) -> {
            String x = a + b;
            String y = b + a;
            for(int i = 0; i < x.length(); i++){
                int z = y.charAt(i) - x.charAt(i);
                if (z != 0){
                    return z;
                }
            }
            return 0;
        });
        if (arr.get(0).equals("0")){
            answer = "0";
        }   
        else{
            for(int i = 0; i < arr.size(); i++){
                answer += arr.get(i);
            }    
        }
        return answer;
    }
}