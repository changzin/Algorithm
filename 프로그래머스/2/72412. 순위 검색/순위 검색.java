import java.util.*;

class Solution {
    HashMap<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Arrays.stream(info)
            .forEach(s ->{
                String[] temp = s.split(" ");
                makeInfoValues(temp, 0, "");
            });
        
        map.keySet().iterator()
            .forEachRemaining(s->{
                map.get(s).sort((a, b)->{
                return a - b;
                });
            });
        
        for(int i = 0; i < query.length; i++){
            String[] temp = query[i].split(" ");
            String q = temp[0] + temp[2] + temp[4] + temp[6];
            if(map.containsKey(q)){
                List<Integer> arr = map.get(q);
                int num = Integer.parseInt(temp[7]);
                int s = 0;
                int e = arr.size()-1;

                while(s <= e){
                    int mid = (s+e) / 2;
                    if (arr.get(mid) >= num){
                        e = mid-1;
                    }
                    else{
                        s = mid + 1;
                    }
                }   
                answer[i] = arr.size()-e-1;    
            }
            else{
                answer[i] = 0;
            }
            
        }
        return answer;
    }
    
    public void makeInfoValues(String[] temp, int depth, String str){
        if (depth == 4){
            // 처리하는 로직
            if (map.containsKey(str)){
                map.get(str).add(Integer.parseInt(temp[4]));
            }
            else{
                List<Integer> arr = new ArrayList<>();
                arr.add(Integer.parseInt(temp[4]));
                map.put(str, arr);
            }
            return;
        }
        if (!temp[depth].equals("-")){
            makeInfoValues(temp, depth+1, str+temp[depth]);    
        }
        makeInfoValues(temp, depth+1, str+"-");

    }
}