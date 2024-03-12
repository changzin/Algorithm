import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<Pair>> map = new HashMap();        
        HashMap<String, Pair> map2 = new HashMap();        
        List<Integer> arr = new ArrayList<>();
        
        // 해시맵 귀성
        for(int i = 0; i < genres.length; i++){
            Pair p = new Pair(i, plays[i]);
            // 이미 장르가 들어갔을 때
            if (map.containsKey(genres[i])){
                map.get(genres[i]).add(p);  
                map2.get(genres[i]).plus(plays[i]);
            }
            else{
                List<Pair> pairList = new ArrayList<>();
                pairList.add(p);
                map.put(genres[i], pairList);
                map2.put(genres[i], new Pair(p.id, p.count));
            }   
        }
        
        // 장르별로 노래 정렬
        for(String k : map.keySet()){
            List<Pair> pairList = map.get(k);
            pairList.sort(Pair::compareTo);
        }
        
        
        // 장르 순서를 정하기 위한 정렬
        List<String> names = new ArrayList<>(map2.keySet());
        names.sort((s1, s2) -> Long.compare(map2.get(s1).count, map2.get(s2).count) * -1);
        
        // 정답 배열 구성
        for(String s : names){
            arr.add(map.get(s).get(0).id);
            if (map.get(s).size() != 1){
                arr.add(map.get(s).get(1).id);            
            }
        }
        
        int[] answer = new int[arr.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
    
    public class Pair implements Comparable<Pair> {
        public int id;
        public long count;
        
        Pair(int id, long count){
            this.id = id;
            this.count = count;
        }
                
        public void plus(long count){
            this.count += count;
        }
        public int compareTo(Pair p){
            int n = Long.compare(this.count, p.count) * -1;
            
            if (n == 0){
                return Integer.compare(this.id, p.id);
            }
            
            return n;
        }        
    }
}