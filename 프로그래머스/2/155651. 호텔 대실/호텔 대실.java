import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        StringTokenizer st;
        List<Pair> arr = new ArrayList<>();
        List<Pair> arr2 = new ArrayList<>();

        for(int i = 0; i < book_time.length; i++){
            int startTime, endTime;
            startTime = endTime = 0;
            for(int j = 0; j < 2; j++){
                st = new StringTokenizer(book_time[i][j], ":");
                String a = st.nextToken();
                String b = st.nextToken();
                if (j==0) startTime = convertTime(a,b);
                else endTime = convertTime(a,b);
            }        
            arr.add(new Pair(startTime, endTime+10));
        }

        arr.sort((a, b) -> {
            if (a.end == b.end)
                return a.start - b.start;
            return a.end - b.end;
        });

        for(int i = 0; i < arr.size(); i++){
            boolean check = false;
            Pair p = arr.get(i);
            for(int j = 0; j < arr2.size(); j++){
                if (p.start >= arr2.get(j).end){
                    arr2.get(j).end = p.end;
                    check = true;
                    // System.out.println("방 업데이트 : " + i + "  // " + p.end);
                    break;
                }
            }
            if (!check){
                // System.out.println("새로운 방 추가");
                arr2.add(new Pair(p.start, p.end));
            }
            
            arr2.sort((a, b) -> {
                if (b.end == a.end)
                    return b.start - a.start;
                return b.end - a.end;
            });
        }
        
        int answer = arr2.size();
        return answer;
    }
    
    
    int convertTime(String hour, String minute){
        return (60 * Integer.parseInt(hour)) + Integer.parseInt(minute);
    }
    
    class Pair {
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}