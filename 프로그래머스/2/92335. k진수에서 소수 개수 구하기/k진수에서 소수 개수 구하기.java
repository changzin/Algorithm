import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String byteStr = "";
        String str;
        StringTokenizer st;
        int rest;
        int count = 0;
        
        
        // 문자열 k진수로 전환
        while(n != 0){
            rest = n % k;
            byteStr = rest + byteStr;
            n /= k;
        }
                
        // "0"을 기준으로 나누어 소수인지 확인
        st = new StringTokenizer(byteStr, "0");
        while(st.hasMoreTokens()){
            str = st.nextToken();
            long num = Long.parseLong(str);
            boolean check = true;
            if (num == 1 || num == 0){
                continue;
            }
            else if (num == 2){
                count++;
                continue;
            }
            for(int i = 2; i < Math.sqrt(num)+1; i++){
                if (num % i == 0){
                    check = false;
                    break;
                }
            }
            if (check){
                count++;
            }
        }
        
        return count;
    }
}