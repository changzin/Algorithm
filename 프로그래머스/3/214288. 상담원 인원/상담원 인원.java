import java.util.*;

class Solution {
    int[] wait;
    int[] mentor;
    List<List<int[]>> arr;
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        
        // 변수 초기화, 상담자 분류
        wait = new int[k];
        mentor = new int[k];
        arr = new ArrayList<>();
        for(int i = 0; i < k; i++){
            arr.add(new ArrayList<>());
            mentor[i] = 1;
        }
        
        for(int i = 0; i < reqs.length; i++){
            int[] temp = {reqs[i][0], reqs[i][1]};
            arr.get(reqs[i][2]-1).add(temp);
        }
        
        // k명만 있을 때, 각 상담유형별 대기시간을 구한다.
        for(int i = 0; i < k; i++){
            wait[i] = getTotalWaitTime(i, 1);
        }
        
        // n-k명의 상담인원을 k개의 상담유형에 넣어보며 대기시간이 가장 줄어드는 곳에 넣는다.
        for(int i = 0; i < n-k; i++){
            int maxWait = 0;
            int index = 0;
            for(int j = 0; j < k; j++){
                int temp = wait[j] - getTotalWaitTime(j, mentor[j]+1);
                if (temp > maxWait){
                    maxWait = temp;
                    index = j;
                }
            }
            mentor[index]++;
            wait[index] -= maxWait;
        }
        
        for(int i = 0; i < k; i++){
            answer += wait[i];
        }
        return answer;
    }    
    
    void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    void print(List<int[]> arr){
        for(int i = 0; i < arr.size(); i++){
            System.out.print(arr.get(i)[0] + " " + arr.get(i)[1] + " / ");
        }
        System.out.println();
    }
    
    int getTotalWaitTime(int category, int n){
        int totalWaitTime = 0;
        // 가장 빠른 상담사를 찾기 위함이다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < n; i++) pq.add(0);
        
        List<int[]> tempList = arr.get(category);
        
        for(int i = 0; i < tempList.size(); i++){
            int[] req = tempList.get(i);
            int fastTime = pq.poll();
            // 바로 상담 가능
            if (fastTime <= req[0]){
                pq.add((req[0] + req[1]));
            }
            else{
                totalWaitTime += (fastTime - req[0]);
                pq.add((fastTime + req[1]));
            }
            
        }
        return totalWaitTime;
    }
}