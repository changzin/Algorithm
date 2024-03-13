import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> sq = new PriorityQueue<>();
        PriorityQueue<Integer> bq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap();
        StringTokenizer st;
        int size = 0;
        for(int i = 0; i < operations.length; i++){
            st = new StringTokenizer(operations[i], " ");
            String o = st.nextToken();
            Integer n = Integer.parseInt(st.nextToken());
            
            if (o.equals("I")){
                sq.add(n);
                bq.add(-n);
                size++;

                if (map.containsKey(n)){
                    map.put(n, map.get(n)+1);
                }
                else{
                    map.put(n, 1);
                }
            }
            else if (o.equals("D")){
                if (n == 1 && !bq.isEmpty()){
                    while(!bq.isEmpty()){
                        int num = -bq.poll();
                        int count = map.get(num);
                        if(count > 0){
                            map.put(num, count-1);
                            size--;
                            break;
                        }
                    }
                }
                else if (n == -1 && !sq.isEmpty()){
                    while(!sq.isEmpty()){
                        int num = sq.poll();
                        int count = map.get(num);
                        if(count > 0){
                            map.put(num, count-1);
                            size--;
                            break;
                        }
                    }
                }
            }   
        }
        int[] answer = new int[2];
        
        if (size==0){
            answer[0] = answer[1] = 0;
        }
        else{
            int a, b;
            while(!bq.isEmpty()){
                b = -bq.peek();
                int count = map.get(b);
                if(count > 0){
                    answer[0] = b;
                    break;
                }
                else{
                    bq.poll();
                }
            }
            while(!sq.isEmpty()){
                a = sq.peek();
                int count = map.get(a);
                if(count > 0){
                    answer[1] = a;
                    break;
                }
                else{
                    sq.poll();
                }
            }
        }
        return answer;
    }
}