import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n+1];
        
        int answer = 0;
        // 전체 한벌씩 줬다가 뺏고 여분을 주는 과정
        for(int i = 0; i < n+1; i++){
            arr[i] = 1;
        }
        for(int i = 0; i < lost.length; i++){
            arr[lost[i]]--;
        }
        for(int i = 0; i < reserve.length; i++){
            arr[reserve[i]]++;
        }
        
        // 빌려주는 과정, 1번부터 올라가면서 보기 때문에, 작은 번호에게 우선적으로 빌려줌
        for(int i = 1; i < n+1; i++){
            if (arr[i] == 2){
                if (i != 1) {
                    if (arr[i-1] == 0){
                        arr[i] = 1;                    
                        arr[i-1] = 1;
                        continue;
                    }
                }
                if (i != n){
                    if (arr[i+1] == 0){
                        arr[i] = 1;
                        arr[i+1] = 1;
                        continue;
                    }
                }
            }
        }
        for(int i = 1; i < arr.length; i++){
            if (arr[i] >= 1){
                answer++;
            }
        }
        return answer;
    }
}