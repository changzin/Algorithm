class Solution {
    String str;
    String[] dict;
    String arr;
    int ans;
    int count;
    
    public int solution(String word) {
        str = word;
        dict = new String[5];
        dict[0] = "A";
        dict[1] = "E";
        dict[2] = "I";
        dict[3] = "O";
        dict[4] = "U";
        ans = -1;
        arr = "";
        
        dfs(0);
        
        
        int answer = ans;
        return answer;
    }
    
    public void dfs(int weight){
        if (arr.equals(str)){
            ans = count;
        }
        if (arr.length() == 5){
            return;
        }
        
        for(int i = 0; i < 5; i++){
            arr += dict[i];
            count++;
            dfs(weight+1);
            arr = arr.substring(0, weight);
        }
    }
}