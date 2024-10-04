import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        List<Music> arr = new ArrayList<>();
        m = m.replace("C#", "H");
        m = m.replace("D#", "I");
        m = m.replace("F#", "J");
        m = m.replace("G#", "K");
        m = m.replace("A#", "L");
        m = m.replace("B#", "M");
        StringTokenizer st;
        String[] scores = new String[musicinfos.length];
        int time;
        String title;
        String score;
        for(int i = 0; i < musicinfos.length; i++){
            st = new StringTokenizer(musicinfos[i], ",");
            
            time = -(timeToInt(st.nextToken()) - timeToInt(st.nextToken()));
            title = st.nextToken();
            score = st.nextToken();
            score = score.replace("C#", "H");
            score = score.replace("D#", "I");
            score = score.replace("F#", "J");
            score = score.replace("G#", "K");
            score = score.replace("A#", "L");
            score = score.replace("B#", "M");
            score = makeScore(score, time);
            
            if (score.contains(m)){
                arr.add(new Music(title, time, i));
            }
        }
        String answer = "(None)";
        if (arr.size() != 0){
            arr.sort((a,b)->{
                if (a.time != b.time){
                    return b.time - a.time;
                }
                return a.index - b.index;
            });    
            answer = arr.get(0).title;
        }
        return answer;
    }
    
    int timeToInt(String time){
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        return (h * 60) + m;   
    }
    
    String makeScore(String notes, int time){
        if (notes.length() >= time){
            return notes.substring(0, time);
        }
        
        String result = notes;
        int a = time % notes.length();
        int b = time / notes.length();
        
        for(int i = 1; i < b; i++){
            result += notes;
        }
        return result + notes.substring(0, a);
    }
    
    class Music{
        Music(String title, int time, int index){
            this.title = title;
            this.time = time;
            this.index = index;
        }
        public String title;
        public int time;
        public int index;
    }
}