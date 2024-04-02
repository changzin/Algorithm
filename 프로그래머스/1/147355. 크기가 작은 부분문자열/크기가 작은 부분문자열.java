class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        for(int i = 0; i <= t.length()-len; i++){
            long num = 0;
            for(int j = 0; j < len; j++){
                if(j+i >= t.length()){
                    break;
                }
                int a = t.charAt(j+i) - '0';
                num = num * 10 + a;
            }
            // System.out.println(num);
            if (num <= Long.parseLong(p)){
                answer++;
            }
        }
        return answer;
    }
}