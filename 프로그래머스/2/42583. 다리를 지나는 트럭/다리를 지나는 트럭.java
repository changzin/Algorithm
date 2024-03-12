import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int w = truck_weights[0];
        int index = 0;
        int lastIndex = 0;
        int time = 1;
        int[] way = new int[truck_weights.length];
        way[0] = 1;
        
        while(true){
            time++;
            // 다리 진행상황 업데이트
            for(int i = index; i <= lastIndex; i++){
                way[i]++;
            }
            // 다리 제일 먼저들어간 버스 꺼내기
            if (way[index] == bridge_length+1){
                w -= truck_weights[index];
                index++;
            }
            // 새로운 트럭 들여오기
            if (lastIndex - index + 1 < bridge_length && lastIndex < truck_weights.length-1){
                if (truck_weights[lastIndex+1] + w <= weight){
                    lastIndex++;
                    way[lastIndex]++;
                    w += truck_weights[lastIndex];
                }
            }    
            // 마지막 버스가 나왔을 때 break
            if (index == truck_weights.length){
                break;
            }
        }
        
        int answer = time;

        return answer;
    }
}