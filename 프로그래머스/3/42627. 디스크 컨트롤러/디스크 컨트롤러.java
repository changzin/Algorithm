import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        List<Job> arr = new ArrayList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>();
        int time = 0;
        int realTime;
        int index = 1;
        
        for(int i = 0; i < jobs.length; i++){
            arr.add(new Job(jobs[i][0], jobs[i][1]));
        }
        Collections.sort(arr, new Comparator<Job>(){
            @Override
            public int compare(Job o1, Job o2){
                int n = o1.startTime - o2.startTime;
                if (n == 0){
                    return o1.requiredTime - o2.requiredTime;
                }
                return n;
            }
        });
        
        time = arr.get(0).requiredTime;
        realTime = arr.get(0).requiredTime + arr.get(0).startTime;
        
        while(index < jobs.length || !pq.isEmpty()){
            // 현재시간보다 startTime이 작거나 같은경우
            if (index < jobs.length && arr.get(index).startTime <= realTime){
                pq.add(arr.get(index++));
            }        
            // pq가 비어있을경우
            else if (index < jobs.length && pq.isEmpty()){
                realTime = arr.get(index).startTime;
            }
            else{
                // 가장 좋은거 꺼내서 시간 총합과 실시간 업데이트
                Job next = pq.poll();
                realTime += next.requiredTime;
                time += realTime - next.startTime;
            }
            
        }

        
        int answer = time / jobs.length;
        return answer;
    }
    
    class Job implements Comparable<Job>{
        int startTime;
        int requiredTime;
        
        Job(int startTime, int requiredTime){
            this.startTime = startTime;
            this.requiredTime = requiredTime;
        }
        
        @Override
        public int compareTo(Job j){
            int n = this.requiredTime - j.requiredTime;
            
            if (n == 0){
                return this.startTime - j.startTime;
            }
            return n;
        }
    }
}