import java.util.*;

class Solution {
    int nodeNum, startNode, edgeNum;
    String[] ans;
    int graph[][];
    String strArr[];
    boolean check;
    List<String> arr;
    public String[] solution(String[][] tickets) {
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> hash = new HashMap();
        edgeNum = tickets.length;
        ans = new String[edgeNum+1];
        // 공항을 중복 없이 추출하기 위해 Set 사용
        for(int i = 0; i < tickets.length; i++){
            for(int j = 0; j < tickets[i].length; j++){
                set.add(tickets[i][j]);
            }
        }
        
        // 추출한 공항을 알파벳 순으로 정렬, 숫자->공항 치환
        arr = new ArrayList<>(set);
        arr.sort((a,b)->a.compareTo(b));
        
        // 공항 이름-> 숫자 치환을 위해 해쉬에 넣음
        for(int i = 0; i < arr.size(); i++){
            hash.put(arr.get(i),i);
            if (arr.get(i).equals("ICN")){
                startNode = i;
            }
        }
        nodeNum = arr.size();
        graph = new int[nodeNum][nodeNum];
        
        for(int i = 0; i < nodeNum; i++){
            for(int j = 0; j < nodeNum; j++){
                graph[i][j] = 0;
            }
        }
        
        for(int i = 0; i < tickets.length; i++){
            int x = hash.get(tickets[i][0]);
            int y = hash.get(tickets[i][1]);
            graph[x][y]++;
        }
        
        // for(int i = 0; i < arr.size(); i++){
        //     System.out.println(i + " " + arr.get(i));
        // }
        // print();
        
        dfs(0, startNode);
        String[] answer = ans;
        return answer;
    }
    
    void dfs(int weight, int node){
        ans[weight] = arr.get(node);
        if (weight == edgeNum){
            check = true;
            return;
        }
        for(int i = 0; i < nodeNum; i++){
            if (graph[node][i] > 0){
                if (check){
                    return;
                }
                graph[node][i]--;
                dfs(weight+1, i);
                graph[node][i]++;
            }
        }
    }
    
    void printArr(){
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
    
    void print(){
        for(int i = 0; i < nodeNum; i++){
            for(int j = 0; j < nodeNum; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}