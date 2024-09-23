import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int lenNum = timeToInt(video_len);
        int posNum = timeToInt(pos);
        int opStartNum = timeToInt(op_start);
        int opEndNum = timeToInt(op_end);
        
        
        if (posNum < opEndNum && posNum >= opStartNum){
            posNum = opEndNum;
        }
        
        for(String command : commands){
            if (command.equals("next")){
                posNum += 10;
                if (posNum > lenNum){
                    posNum = lenNum;
                }
            }
            else{
                posNum -= 10;
                if (posNum < 0){
                    posNum = 0;
                }
            }
            if (posNum < opEndNum && posNum >= opStartNum){
                posNum = opEndNum;
            }
        }
        
        answer = intToTime(posNum);
        return answer;
    }
    
    int timeToInt(String time){
        StringTokenizer st = new StringTokenizer(time, ":");
        
        int num = 0;
        num += Integer.parseInt(st.nextToken()) * 60;
        num += Integer.parseInt(st.nextToken());
        
        return num;
    }
    
    String intToTime(int num){
        int h = num / 60;
        
        int m = num % 60;
        return ((h >= 10) ? h : "0" + h) + ":" + ((m >= 10) ? m : "0" + m);
    }
    
}