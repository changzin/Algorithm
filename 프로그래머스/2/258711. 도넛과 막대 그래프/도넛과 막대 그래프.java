import java.util.*;

class Solution {    
    int[] startEdges = new int[1000001];    
    int[] destEdges = new int[1000001];
    boolean[] visit = new boolean[1000001];
    int startNode;
    List<Integer> arr = new ArrayList<>();
    HashMap<Integer, List<Integer>> graph =  new HashMap();
    
    public int[] solution(int[][] edges) {
        // 정점만 edge출발선을 2개 이상 가지고 있다.
        for(int i = 0; i < edges.length; i++){
            int start, dest;
            start = edges[i][0];
            dest = edges[i][1];
            startEdges[start]++;
            destEdges[dest]++;
            
            if (graph.containsKey(start)){
                List<Integer> arr = graph.get(start);
                arr.add(dest);
            }
            else{
                List<Integer> arr = new ArrayList<>();
                arr.add(dest);
                graph.put(start, arr);
            }
        }
        
        for(int i = 1; i <= 1000000; i++){
            if (destEdges[i] == 0 && startEdges[i] >= 2){
                startNode = i;
                break;
            }
        }
        // 도넛은 edge, node 둘 다 안겹치고 처음 노드로 돌아올 수 있따.
        // 8자는 edge는 겹치지 않지만, node가 중간중간 겹쳐서 돌아온다.
        // 일자는 걍 일자임
        List<Integer> arr = graph.get(startNode);
        int[] answer = new int[4];
        answer[0] = startNode;
        for(int i = 0; i < arr.size(); i++){
            int a = dfs(arr.get(i), 2);
            answer[a]++;
        }
        return answer;
    }
    
    int dfs(int node, int mode){
        visit[node] = true;
        List<Integer> arr;
        
        if (graph.containsKey(node)){
            arr= graph.get(node);
        }
        else{
            return 2;
        }
        
        if (arr.size() >= 2){
            return 3;
        }
        else{
            if (visit[arr.get(0)]){
                return 1;
            }
            mode = dfs(arr.get(0), mode);
        }
        return mode;
    }
}