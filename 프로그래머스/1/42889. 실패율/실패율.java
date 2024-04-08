import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int len = stages.length;
        
        List<Pair> arr = new ArrayList<>();
        for(int i = 0; i < N+2; i++){
            arr.add(new Pair(i, 0, 0));
        }
        
        for(int i = 0; i< stages.length; i++){
            arr.get(stages[i]).third += 1;
        }
        
        int sum = arr.get(N+1).third;
        
        for(int i = N; i >= 0; i--){
            int x = arr.get(i).third;
            sum += x;
            if (sum == 0 || x == 0){                
                arr.get(i).second = 0;
            }
            else{
                arr.get(i).second = (double)x / sum;
            }
        }
        
        arr.sort((a, b) -> {
            if (Double.compare(a.second, b.second) == 0){
                return a.first - b.first;
            }
            else{
                return Double.compare(b.second, a.second);
            }
        });

        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i).first + " : " + arr.get(i).second);
        }
        
        int index = 0;
        for(int i = 0; i < arr.size(); i++){
            if (arr.get(i).first != 0 && arr.get(i).first != N+1){
                answer[index++] = arr.get(i).first;
            }
        }
        
        return answer;
    }
}

class Pair{
    public int first;
    public double second;
    public int third;
    Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}