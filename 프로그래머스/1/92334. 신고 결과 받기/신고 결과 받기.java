import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        int[] answer = new int[len];
        List<List<Integer>> arr = new ArrayList<>();
        boolean[][] graph = new boolean[len][len];
        StringTokenizer st;
        HashMap<String, Integer> map = new HashMap();
        
        for(int i = 0; i < id_list.length; i++){
            arr.add(new ArrayList<>());
            map.put(id_list[i], i);
        }
        
        for(int i = 0; i < report.length; i++){
            st = new StringTokenizer(report[i], " ");
            String a = st.nextToken();
            String b = st.nextToken();
            int x = map.get(a);
            int y = map.get(b);
            
            if (!graph[x][y]){
                graph[x][y] = true;
                arr.get(y).add(x);
            }   
        }
        for(int i = 0; i < len; i++){
            if (arr.get(i).size() >= k){
                for(int j = 0; j < arr.get(i).size(); j++){
                    answer[arr.get(i).get(j)]++;
                }
            }
        }
    
        
        
        return answer;
    }
}