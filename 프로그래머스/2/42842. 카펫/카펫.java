class Solution {
    public int[] solution(int brown, int yellow) {
        int x = 0;
        int y = 0;
        
        for(int i = 1; i <= yellow; i++){
            if (yellow % i == 0){
                int num = (yellow / i) + 2;
                if (brown == (num * 2) + (i * 2)){
                    x = num;
                    y = i+2;
                    break;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}