class Solution {
    boolean[] duplicateCheck = new boolean[257];
    boolean[] visit = new boolean[8];
    String[] global_user_id;
    String[] global_banned_id;
    int answer = 0;
    int user_length;
    int banned_length;
    
    public int solution(String[] user_id, String[] banned_id) {
        global_user_id = user_id;
        global_banned_id = banned_id;
        user_length = user_id.length;
        banned_length = banned_id.length;
        
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int depth, int result){
        // 엔딩 조건 1 : 밴 아이디를 모두 적용했을 때
        if (depth == banned_length){
            if (!duplicateCheck[result]){
                duplicateCheck[result] = true;
                answer++;
            }
            return;
        }
        
        int num = 1;
        for(int i = 0; i < user_length; i++){
            // 기록하기 위한 코드이다. 2진수느낌으로 더해나가서 결과를 확인할 꺼기 때문에...
            if (i != 0){
                num *= 2;
            }
            
            // 이미 밴에 해당한다는 의미
            if (visit[i]){
                continue;
            }
            // 밴이 되지 않았으며, 지금 체크하는 걸로 밴할 수 있을 때
            if (checkUserId(global_user_id[i], global_banned_id[depth])){
                // 밴을 하고, 백트래킹으로 체크하자
                visit[i] = true;
                dfs(depth+1, result + num);
                visit[i] = false;
            }
        }
        return;
    }
    
    // user_id가 banned_id에 해당될 수 있는지 판단하는 함수
    public boolean checkUserId(String user_id, String banned_id){
        // 길이가 다르면 해당 안됨
        if (user_id.length() != banned_id.length()){
            return false;
        }
        // 한글자씩 매칭
        for(int i = 0; i < user_id.length(); i++){
            // 별이면 어떤 문자가 와도 상관 X
            if (banned_id.charAt(i) == '*'){
                continue;
            }
            // 그 외 문자가 다르다면 해당되지 않는다.
            if (user_id.charAt(i) != banned_id.charAt(i)){
                return false;
            }
        }
        return true;
    }
}