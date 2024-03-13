import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int a, b, c, ai, bi, ci;
        a = b = c = ai = bi = ci = 0;
        
        for(int i = 0; i < answers.length; i++){
            int ans = answers[i];
            if (first[ai] == ans){
                a++;
            }
            if (second[bi] == ans){
                b++;
            }
            if (third[ci] == ans){
                c++;
            }
            ai++;
            bi++;
            ci++;
            if (ai == 5){
                ai = 0;
            }
            if (bi == 8){
                bi = 0;
            }
            if (ci ==10){
                ci = 0;
            }
        }
        
        int maxValue = Math.max(a, Math.max(b, c));
        List<Integer> arr = new ArrayList<>();
        if (maxValue == a){
            arr.add(1);
        }
        if (maxValue == b){
            arr.add(2);
        }
        if (maxValue == c){
            arr.add(3);
        }
        
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}