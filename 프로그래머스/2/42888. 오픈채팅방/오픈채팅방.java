import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> arr = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i], " ");
            StringBuilder sb = new StringBuilder();
            
            String first = st.nextToken();
            String second = st.nextToken();
            
            if (first.equals("Enter")){
                String third = st.nextToken();
                map.put(second, third);
                arr.add(second + "님이 들어왔습니다.");
                
            }
            else if (first.equals("Leave")){
                arr.add(second + "님이 나갔습니다.");
            }
            else{
                String third = st.nextToken();
                map.put(second, third);
            }
        }
        String[] answer = new String[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            int index = 0;
            for(int j = 0; j < arr.get(i).length(); j++){
                if (arr.get(i).charAt(j) == '님'){
                    index = j;
                    break;
                }
            }
            String key = arr.get(i).substring(0, index);
            String value = map.get(key);
            answer[i] = arr.get(i).replace(key, value);
        }
        
        return answer;
    }
}