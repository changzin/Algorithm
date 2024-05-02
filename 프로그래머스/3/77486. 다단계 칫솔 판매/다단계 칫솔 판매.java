import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    int[] arr;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        int[] arr = new int[enroll.length];
        
        // Map으로 정수 - 판매원 이름 매핑해요
        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i], i);
            arr[i] = -1;
        }
        
        // 단방향 그래프를 만들어요
        for(int i = 0; i < referral.length; i++){
            int boss = 0;
            if (map.containsKey(referral[i])){
                boss = map.get(referral[i]);
                arr[i] = boss;
            }
        }
        // 한 명씩 팔이를 계산해봐요..
        for(int i = 0; i < seller.length; i++){
            int money = amount[i] * 100;
            int node  = map.get(seller[i]);
            
            while(true){
                if (arr[node] == -1){
                    answer[node] += (money - (money / 10));
                    break;
                }
                int parent = arr[node];
                int nextMoney = money / 10;
                
                if (nextMoney == 0){
                    answer[node] += money;
                    break;
                }
                answer[node] += money - nextMoney;
                
                money = nextMoney;
                node = parent;
                
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