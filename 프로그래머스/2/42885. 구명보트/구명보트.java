import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        List<Integer> arr = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = people.length-1;
        int count = 0;
        int minValue;
        
        Arrays.sort(people);
        // 가장 날씬한 사람
        minValue = people[0];
        
        while(index != -1){
            int nWeight = people[index--];
            // 구명보트가 하나도 없으면 구명보트 추가
            if (pq.isEmpty()){
                pq.add(nWeight - limit);
                count++;
                continue;
            }
            int maxWeight = -pq.peek();
            // 가장 날씬한 사람도 못타면 구명보트 추가
            if (maxWeight < minValue){
                pq.add(nWeight - limit);
                count++;
            }
            // 가장 지금 빈자리에 못들어가면 구명보트 추가
            else if (maxWeight < nWeight){
                pq.add(nWeight - limit);
                count++;
            }
            // 같이 타서 탈출함.
            else{
                pq.poll();
            }
        }        
        
        int answer = count;
        return answer;
    }
}