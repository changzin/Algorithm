class Solution {
    public int[] solution(String s) {
        
        
        String str = s;
        int count = 0;
        int cnt = 0;
        
        while (true){
            int num = 0;
            if (str.equals("1")){
                break;
            }
            cnt++;
            for(int i = 0; i < str.length(); i++){
                if (str.charAt(i) == '1'){
                    num++;
                }
                else{
                    count++;
                }
            }
            str = Integer.toBinaryString(num);
        }
        
        int[] answer = {cnt, count};
        return answer;
    }
}