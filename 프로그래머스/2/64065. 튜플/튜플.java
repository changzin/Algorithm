import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 문자열 s를 }로 나눈다.
        s = s.substring(1, s.length()-1);
        StringTokenizer st = new StringTokenizer(s, "}");
        boolean[] visit = new boolean[100001];
        List<String> arr = new ArrayList<>();
        
        String str = st.nextToken();
        arr.add(str.substring(1, str.length()));
        while(st.hasMoreTokens()){
            str = st.nextToken();
            arr.add(str.substring(2, str.length()));
        }
        
        arr.sort((a,b)->a.length()-b.length());
        
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            st = new StringTokenizer(arr.get(i), ",");
            for(int j = 0; j <=i; j ++){
                int num = Integer.parseInt(st.nextToken());
                if (!visit[num]){
                    visit[num] = true;
                    answer[i] = num;
                    break;
                }
            }
        }
        return answer;
    }
}