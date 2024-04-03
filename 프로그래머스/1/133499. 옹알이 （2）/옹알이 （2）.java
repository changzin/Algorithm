class Solution {
    public int solution(String[] babbling) {
        String[] word = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        boolean check;
        for(int i = 0; i < babbling.length; i++){
            check = true;
            int index = 0;
            int lastword = -1;
            
            while(true){
                boolean check2 = false;
                for(int k = 0; k < 4; k++){
                    if (babbling[i].charAt(index) == word[k].charAt(0)){
                        if (k == lastword){
                            check = false;
                            break;
                        }
                        lastword = k;
                        check2 = true;
                        for(int j = 0; j < word[k].length(); j++){
                            if (babbling[i].charAt(index) != word[k].charAt(j)){
                                check = false;
                                break;
                            }
                            index++;
                            if (index == babbling[i].length() && j != word[k].length()-1){
                                check = false;
                                break;
                            }
                        }
                        break;
                    }                    
                }
                if (!check2){
                    check = false;
                    break;
                }
                if (!check || index == babbling[i].length()){
                    break;
                }
            }
            if (check) {
                answer++;
            }
        }
        return answer;
    }
}