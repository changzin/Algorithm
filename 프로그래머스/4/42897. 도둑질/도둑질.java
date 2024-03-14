class Solution {
    public int solution(int[] money) {
        // 0, 1, 2 세개를 터는 경우를 딱 해서 하면 될듯
        int answer = 0;
        int n = money.length;
        int[] first = new int[n];
        int[] second = new int[n];
        int[] third = new int[n];
        for(int i = 0; i < n; i++){
            first[i] = 0;
            second[i] = 0;
            third[i] = 0;
        }
        if (n >= 5){
            first[0] = money[0];
            first[1] = first[1];
            first[2] = money[0] + money[2];
            second[1] = money[1];
            second[2] = money[2];
            second[3] = money[1] + money[3];
            third[2] = money[2];
            third[3] = third[3];
            third[4] = money[2] + money[4];
            int fi, si, ti;
            // 메인 알고리즘 : dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i])
            // 첫 번째 집을 무조건 터는 경우, 두 번째 집을 무조건 터는 경우, 세 번째 집을 무조건 터는 경우로 나눈다.
            for(int i = 0; i <= n-5; i++){
                fi = i+3;   // 3 ~ n-2
                si = i+4;   // 4 ~ n-1
                ti = i+5;   // 5 ~ n

                first[fi] = Math.max(first[fi-2] + money[fi], first[fi-3] + money[fi]);
                second[si] = Math.max(second[si-2] + money[si], second[si-3] + money[si]);
                if (ti != n){                
                    third[ti] = Math.max(third[ti-2] + money[ti], third[fi-3] + money[ti]);
                }
                else{   
                    third[0] = Math.max(third[ti-2] + money[0], third[fi-3] + money[0]);
                }
            }
            int fm, sm, tm;
            fm = Math.max(first[n-2], first[n-3]);
            sm = Math.max(second[n-1], second[n-2]);
            tm = Math.max(third[0], third[n-1]);
            answer = Math.max(fm, Math.max(sm, tm));
        }
        else{
            if (n==3){
                answer = Math.max(money[0], Math.max(money[1], money[2]));
            }
            else if (n == 4){
                answer = Math.max(money[0] + money[2], money[1] + money[3]);
            }
        }
        return answer;
    }
}