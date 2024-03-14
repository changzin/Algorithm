import java.util.*;

class Solution {
    int[] root;
    
    public int solution(int n, int[][] costs) {
        root = new int[n];
        int count = 0;
        int answer = 0;

        for(int i = 0; i < n; i++){
            root[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for(int i = 0; i < costs.length; i++){
            if (count == n-1){
                break;
            }
            
            int a = find(costs[i][0]);
            int b = find(costs[i][1]);
            // System.out.println(" 엣지 : " + costs[i][0] + " - " + costs[i][1]);
            // System.out.println("find : " + a + " - " + b);
            if (a != b){
                merge(a, b);
                answer += costs[i][2];
            }
        }        
        return answer;
    }
    
    int find(int x){
        if (root[x] == x){
            return x;
        }
        return root[x] = find(root[x]);
    }
    
    void merge(int a, int b){
        int x = find(a);
        int y = find(b);
        if (x < y){
            root[y] = x;
        }
        else{        
            root[x] = y;
        }
    }
}