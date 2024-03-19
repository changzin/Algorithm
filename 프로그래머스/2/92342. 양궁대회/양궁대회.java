class Solution {
    // 백트래킹 전용 배열
    int[] arr = new int[11];
    // 어피치를 이길려면 이거 이상 쏴야됨
    int[] needed = new int[11];
    // 정답 배열
    int[] ans = new int[11];
    // 어피치 화살
    int[] verses;
    int gap;
    
    public int[] solution(int n, int[] info) {
        verses = info;
        // 어피치보다 한 발 더 많이 쏘는 것이 가장 적게 쏘고 점수도 먹을 수 있다.
        for(int i = 0; i < 10; i++){
            needed[i] = info[i]+1;
        }
        
        dfs(0, n);

        int[] answer;
        if (gap > 0){
            answer = ans;
        }
        else{
            answer = new int[1];
            answer[0] = -1;
        }
        
        return answer;
    }
    
    void dfs(int weight, int left){
        if (weight == 10){
            if (left != 0){
                arr[10] = left;
            }
            scoreCheck();
            arr[10] = 0;
            return;
        }
        if (left == 0){
            scoreCheck();
            return;
        }
        // 쏠떈쏴
        if (needed[weight] <= left){
            arr[weight] = needed[weight];
            dfs(weight+1, left - needed[weight]);
        }
        // 그냥 갈때
        arr[weight] = 0;
        dfs(weight+1, left);
    }
    
    void scoreCheck(){
        int scoreA = 0;
        int scoreB = 0;

        for(int i = 0; i < 10; i++){
            if (verses[i] == 0 && arr[i] == 0){
                continue;
            }
            if (verses[i] >= arr[i]){
                scoreA += (10 - i);
            }
            else {
                scoreB += (10 - i);
            }
        }
        boolean check = true;
        // 현재 점수차보다 더 벌어지면 true
        if (scoreB - scoreA > gap){
            check = true;
        }
        // 점수차가 동일할 때 낮은 점수대에 얼마나 쐈는지 체크
        else if ((scoreB - scoreA) == gap){
            for(int i = 10; i >= 0; i--){
                if (arr[i] > ans[i]){
                    check = true;
                    break;
                }
                else if (arr[i] < ans[i]){
                    check = false;
                    break;
                }
            }
        }
        else{
            check = false;
        }
        if (check){
            for(int i = 0; i < 11; i++){
                ans[i] = arr[i];
            }
            gap = scoreB - scoreA;
        }
        return;
    }
}