class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int index1 = 0;
        int index2 = 0;
        boolean check = true;
        
        for(int i = 0; i < goal.length; i++){
            check = false;    
            if (index1 != cards1.length){
                if (cards1[index1].equals(goal[i])){
                    check = true;
                    index1++;
                    continue;
                }
            }
            if (index2 != cards2.length){
                if (cards2[index2].equals(goal[i])){
                    check = true;
                    index2++;
                    continue;
                }
            }
            if (!check){
                break;
            }
        }
        
        if (check){
            answer = "Yes";
        }
        else{
            answer = "No";
        }
        
        return answer;
    }
}