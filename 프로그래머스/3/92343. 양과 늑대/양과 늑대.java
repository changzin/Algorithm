import java.util.*;

class Solution {
    Queue<Pair> q = new LinkedList<>();
    List<List<Integer>> graph = new ArrayList<>();
    boolean visit[][] = new boolean[1<<17][17];;
    int[] infos;
    
    int check(int bitmask){
        int x = bitmask;
        int wolf = 0;
        int lamb = 0;
        int idx = 0;
        while (bitmask != 0){
            if (bitmask % 2 == 1){
                if (infos[idx] == 1){
                    wolf++;
                }
                else{
                    lamb++;
                }
            }
            idx++;
            bitmask /= 2;
        }
        // System.out.println(Integer.toBinaryString(x) + " " + wolf + " " + lamb);
        if (wolf >= lamb){
            return -1;
        }
        else{
            return lamb;
        }
    }
    
    int bfs(){
        int cur, bitmask, next, nextBitmask, lamb, answer;
        q.add(new Pair(1, 0));
        answer = 0;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            bitmask = p.first;
            cur = p.second;
            
            for(int i = 0; i < graph.get(cur).size(); i++){
                
                next = graph.get(cur).get(i);
                nextBitmask = bitmask | (1 << next);
                lamb = check(bitmask);
                if (!visit[nextBitmask][next] && lamb != -1){
                    answer = Math.max(answer, lamb);
                    visit[nextBitmask][next] = true;
                    q.add(new Pair(nextBitmask, next));
                }
            }
            
        }
        return answer;
    }
    
    public int solution(int[] info, int[][] edges) {
        // 노드들의 방문 여부와 현재 노드를 보자...
        infos = info;
        for(int i = 0; i < info.length; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        int answer = bfs();
        return answer;
    }    
    
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}