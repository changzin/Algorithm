import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int first = map.get(ext);
        int second = map.get(sort_by);
        
        
        ArrayList<int[]> arr = new ArrayList<>();
        
        for(int i = 0; i < data.length; i++){
            if (data[i][first] < val_ext){
                arr.add(data[i]);
            }
        }
        
        arr.sort((a,b)->a[second] - b[second]);
        
        int[][] answer = new int[arr.size()][];
        
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}