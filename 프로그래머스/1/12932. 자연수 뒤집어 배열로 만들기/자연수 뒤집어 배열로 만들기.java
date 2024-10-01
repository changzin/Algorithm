import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> arr = new ArrayList<>();
        while (true){
            if (n < 10){
                arr.add((int)n);
                break;
            }
            if (n < 100){
                arr.add((int)(n % 10));
                arr.add((int)(n / 10));
                break;
            }
            int num = (int)(n % 10);
            arr.add(num);
            n /= 10;
        }
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}