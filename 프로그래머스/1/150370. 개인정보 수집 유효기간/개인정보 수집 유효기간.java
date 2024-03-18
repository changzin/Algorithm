import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap();
        List<Integer> arr= new ArrayList<>();
        StringTokenizer st;
        int y, m, d;
        
        st = new StringTokenizer(today, ".");
        y = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < terms.length; i++){
            st = new StringTokenizer(terms[i], " ");
            String term = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            map.put(term, a);
        }
        
        for(int i = 0; i < privacies.length; i++){
            st = new StringTokenizer(privacies[i], " ");
            String date = st.nextToken();
            String term = st.nextToken();
            int num = map.get(term);
            int[] dateInt = new int[3];
            st = new StringTokenizer(date, ".");
            for(int j = 0; j < 3; j++){
                dateInt[j] = Integer.parseInt(st.nextToken());
            }
            dateInt[1] += num;
            if (dateInt[1] > 12){
                dateInt[0] += dateInt[1] / 12;
                dateInt[1] %= 12;
                
                if (dateInt[1] == 0){
                    dateInt[1] = 12;
                    dateInt[0]--;
                }
            }
            
            boolean check = false;
            if (y > dateInt[0]){
                check =true;
            }
            else if (y == dateInt[0]){
                if (m > dateInt[1]){
                    check = true;
                }
                else if (m == dateInt[1]){
                    if (d >= dateInt[2]){
                        check = true;
                    }
                }
            }
            if (check){
                arr.add(i+1);
            }
        }
        
        
        
        
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }    
}