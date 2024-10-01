class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i = 0; i < babbling.length; i++){
            if (checkStr(babbling[i])){
                answer++;
            }
        }
        
        return answer;
    }
    
    boolean checkStr(String str){
        // aya, ye, woo, ma 중 안들어간 것이 있는지 확인해야함.
        boolean aya = false;
        boolean ye = false;
        boolean woo = false;
        boolean ma = false;
        
        int i = 0;
        while(true){
            if (i == str.length()){
                return true;
            }
            
            if (str.charAt(i) == 'a' && !aya){
                if (i + 2 < str.length()){
                    if (str.charAt(i+1) == 'y' && str.charAt(i+2) == 'a'){
                        i += 3;
                        aya = true;
                    }
                    else{
                        return false;    
                    }
                }
                else{
                    return false;
                }
            }
            else if (str.charAt(i) == 'y' && !ye){
                if (i + 1 < str.length()){
                    if (str.charAt(i+1) == 'e'){
                        i += 2;
                        ye = true;
                    }
                    else{
                        return false;    
                    }
                }
                else{
                    return false;
                }
            }
            else if (str.charAt(i) == 'w' && !woo){
                if (i + 2 < str.length()){
                    if (str.charAt(i+1) == 'o' && str.charAt(i+2) == 'o'){
                        i += 3;
                        woo = true;
                    }
                    else{
                        return false;    
                    }
                }
                else{
                    return false;
                }
            }
            else if (str.charAt(i) == 'm' && ! ma){
                if (i + 1 < str.length()){
                    if (str.charAt(i+1) == 'a'){
                        i += 2;
                        ma = true;
                    }
                    else{
                        return false;    
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }    
    }
}