import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> arr = new ArrayList<>();
        int answer = 0;
        int num = N;
        
        for(int i = 0; i <= 8; i++){
            arr.add(new HashSet());
        }
        
        arr.get(1).add(N);
        for(int i = 2; i < 9; i++){
            num = (num*10) + N;
            arr.get(i).add(num);
        }
        
        for(int i = 2; i <= 8; i++){
            // i번 사용한 수를 구하기 위해 j + (i-j) 번 사용한 것으로 구현할것임.
            System.out.println(i);
            for(int j = 1; j < i; j++){
                for(int a : arr.get(j)){
                    for(int b : arr.get(i-j)){
                        int plus, minus, multiple, divide;
                        plus = a + b;
                        minus = a - b;
                        multiple = a * b;
                        if (b != 0){
                            divide = a / b;
                            arr.get(i).add(divide);
                        }
                        arr.get(i).add(plus);
                        arr.get(i).add(minus);
                        arr.get(i).add(multiple);
                        
                    }
                }
            }
        }
        answer = -1;
        for(int i = 1; i <= 8; i++){
            if (arr.get(i).contains(number)){
                answer = i;
                break;
            }
        }
        return answer;
    }
}