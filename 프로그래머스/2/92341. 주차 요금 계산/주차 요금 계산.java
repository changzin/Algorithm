import java.util.*;

class Solution {
    int[] inTime = new int[10000];
    int[] allTime = new int[10000];
    
    public int[] solution(int[] fees, String[] records) {
        Set<Integer> set = new HashSet();
        int firstTime = fees[0];
        int firstFee = fees[1];
        int secondTime = fees[2];
        int secondFee = fees[3];
        StringTokenizer st;
        
        for(int i = 0; i < records.length; i++){
            st = new StringTokenizer(records[i], " ");
            
            String time = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            String door = st.nextToken();
            set.add(number);
            
            int convertTime = convert(time);
            if (door.equals("IN")){
                inTime[number] = convertTime;
            }
            else{
                allTime[number] = allTime[number] + (convertTime - inTime[number]);
                inTime[number] = -1;
            }
        }
        
        List<Integer> arr = new ArrayList<>(set);
        arr.sort((a, b)->(a-b));
        int[] answer = new int[arr.size()];
        
        for(int i = 0; i < arr.size(); i++){
            int num = arr.get(i);
            
            if (inTime[num] != -1){
                allTime[num] = allTime[num] + (convert("23:59") - inTime[num]);
            }
            
            allTime[num] -= firstTime;
            answer[i] = firstFee;
            if (allTime[num] > 0){
                if (allTime[num] % secondTime != 0){
                    answer[i] = answer[i] + ((allTime[num] / secondTime) + 1)*secondFee;
                }
                else{
                    answer[i] = answer[i] + (allTime[num] / secondTime)*secondFee;
                }
            }
        }
        
        
        
        return answer;
    }
    
    int convert(String str){
        StringTokenizer st = new StringTokenizer(str, ":");
        int a = 0;
        
        a += Integer.parseInt(st.nextToken()) * 60;
        a += Integer.parseInt(st.nextToken());
        return a;
    }
}