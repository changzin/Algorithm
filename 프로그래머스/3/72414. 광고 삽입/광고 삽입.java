import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        // 0초 ~ 100시간 이하니 크기를 이렇게 잡는다..
        // 0은 0~1의 구간을 뜻한다고 생각하기로 했다.
        int[] dp = new int[360001];
        long[] sums = new long[360001];
        
        int totalLength = stringToInt(play_time);
        int advLength = stringToInt(adv_time);
        long maxView = 0;
        int minStart = 0;
        
        for(int i = 0; i < logs.length; i++){
            String[] l = logs[i].split("-");
            int start = stringToInt(l[0]);
            int end = stringToInt(l[1]);
            dp[start] += 1;
            dp[end] += -1;
        }

        sums[0] = dp[0];
        for(int i = 1; i <= totalLength; i++){
            dp[i] = dp[i-1] + dp[i];
        }
        for(int i = 1; i < advLength; i++){
            sums[i] = sums[i-1] + dp[i];
        }
        maxView = sums[advLength-1];
        
        for(int i = advLength; i <= totalLength; i++){
            // 누적합을 이용해서 구해보자.
            sums[i] = sums[i-1] + dp[i];
            if (sums[i] - sums[i - advLength] > maxView){
                // System.out.println(i + " " + maxView);
                maxView = sums[i] - sums[i - advLength];
                minStart = i - advLength + 1;
            }
        }
        String answer = timeToString(minStart);
        if (totalLength <= advLength){
            answer = "00:00:00";
        }
        return answer;
    }
    
    int timeToInt(String time){
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken()) * 3600;
        int m = Integer.parseInt(st.nextToken()) * 60;
        int s = Integer.parseInt(st.nextToken());
        return (h + m + s);
    }
    String intToTime(int time){
        String h = time / 3600 + "";
        if (h.length() == 1){
            h = "0" + h;
        }
        time %= 3600;
        String m = time / 60 + "";
        if (m.length() == 1){
            m = "0" + m;
        }
        time %= 60;
        String s = time + "";
        if (s.length() == 1){
            s = "0" + s;
        }
        return h + ":" + m + ":" + s;
    }
    
    int stringToInt(String time) {
		String[] times = time.split(":");
		int toSec = 3600;
		int totalTime = 0;
		for(String t : times) {
			int num = Integer.parseInt(t);
			totalTime += num*toSec;
			toSec /= 60;
		}
		return totalTime;
	}
	
    String timeToString(int time) {
		String t = "";
		int hour = time/3600;
		time %= 3600;
		if(hour <10) t+= "0"+ hour +":";
		else t += hour+":";
		
		int minute = time/60;
		time %= 60;
		if(minute <10) t+= "0"+ minute+":";
		else t += minute+":";
		
		int second = time;
		if(second <10) t+= "0"+ second;
		else t += second;
		
		return t;
	}
}