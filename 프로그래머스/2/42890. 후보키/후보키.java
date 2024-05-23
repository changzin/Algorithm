import java.util.*;

class Solution {
    boolean[] visit;
    String[][] rel;
    // 슈퍼키 모음
    Set<String> checkset;
    int ans;
    
    public int solution(String[][] relation) {
        checkset = new HashSet<>();
        ans = 0;
        visit = new boolean[relation[0].length];
        rel = relation;
        
        for(int i = 1; i < relation[0].length; i++){
            dfs(i, 0, 0);    
        }
        
        int answer = ans;
        if (answer == 0){
            answer = 1;
        }
        return answer;
    }
    
    void dfs(int n, int depth, int v){
        if (depth == n){
            int[] result = new int[n];
            int index = 0;
            for(int i = 0; i < visit.length; i++){
                if (visit[i]){
                    result[index] = i;
                    index++;
                }
            }   
            // Arrays.stream(result).forEach((i)->{System.out.print(i);});
            System.out.println();
            // ans 올리고, checkset에 저장
            checkKey(result);
            return;
        }
        
        for(int i = v; i < visit.length; i++){
            if (!visit[i]){
                visit[i] = true;
                dfs(n, depth+1, i);
                visit[i] = false;
            }
        }
        return;
    }
    
    void checkKey(int[] result){
        Set<String> set = new HashSet<>();
        for(int i = 0; i < rel.length; i++){
            String temp = "";
            for(int j = 0; j < result.length; j++){
                // 특문으로 컬럼을 attribute를 구분하며 슈퍼키 문자열 만듦
                temp += rel[i][result[j]] + "$";   
            }
            if (set.contains(temp)){
                return;
            }
            else{
                set.add(temp);
            }
        }
        String key = "";
        for(int i = 0; i < result.length; i++){
            key += result[i];
        }
        boolean b = true;
        for(String s : checkset){
            int checknum = 0;
            
            for(int i = 0; i < s.length(); i++){
                char x = s.charAt(i);
                for(int j = 0; j < key.length(); j++){
                    char y = key.charAt(j);
                    if (x == y){
                        checknum++;
                        break;
                    }
                }
            }
            if (checknum == s.length()){
                return;
            }
        }
        if (b){
            checkset.add(key);
            ans++;
        }
        return;
    }
    
    void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}