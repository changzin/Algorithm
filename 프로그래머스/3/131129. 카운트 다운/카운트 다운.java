import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    Queue<int[]> q = new LinkedList<>();
    
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> arr = new ArrayList<>();
    int[][] distance = new int[100001][2];
    
    public int[] solution(int target) {
        for(int i = 1; i <= 20; i++){
            set.add(i);
            set.add(i*2);
            set.add(i*3);
            map.put(i, 1);
        }
        set.add(50);
        map.put(50, 1);
        
        Iterator<Integer> setIter = set.iterator();
        while(setIter.hasNext()){
            int temp = setIter.next();
            arr.add(temp);
            if (!map.containsKey(temp)){
                map.put(temp, 0);
            }
        }
        bfs(target);
        int[] answer = {distance[target][0], distance[target][1]};
        return answer;
    }
    
    void bfs(int target){
        for(int i = 1; i < distance.length; i++){
            distance[i][0] = Integer.MAX_VALUE;
            distance[i][1] = 0;
        }
        boolean check;        
        int node, weight, specials, next, nWeight, nSpecials;
        // 숫자와 전체 던진 갯수, 특별한 쓰로우 수
        int[] start = {0, 0, 0};
        q.add(start);
        while(!q.isEmpty()){
            int[] temp = q.poll();
            node=temp[0]; weight=temp[1]; specials=temp[2];
            
            for(int i = 0; i < arr.size(); i++){
                next = node+arr.get(i);
                nWeight = weight+1;
                nSpecials = specials + map.get(arr.get(i));
                check = false;
                
                if (next <= target && distance[next][0] > nWeight){
                    check = true;
                }
                else if (next <= target && distance[next][0] == nWeight 
                         && distance[next][1] < nSpecials){
                    check = true;
                }
                
                if (check){
                    int[] temp2 = {next, nWeight, nSpecials};
                    q.add(temp2);
                    distance[next][0] = nWeight;
                    distance[next][1] = nSpecials;
                    // System.out.println(node+":"+weight+":"+specials);
                }
            }
        }
    }
    
}