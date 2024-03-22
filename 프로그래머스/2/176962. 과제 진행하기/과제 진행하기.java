import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Stack<Sub> stack = new Stack<>();
        List<Sub> arr = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        StringTokenizer st;
        
        for(int i = 0; i < plans.length; i++){
            String subject = plans[i][0];
            int start = 0;
            st = new StringTokenizer(plans[i][1], ":");
            start += (Integer.parseInt(st.nextToken()) * 60);
            start += (Integer.parseInt(st.nextToken()));
            int playTime = Integer.parseInt(plans[i][2]);
            arr.add(new Sub(subject, start, playTime));
        }
        
        arr.sort((a,b) -> (a.start - b.start));
    
        for(int i = 0; i < arr.size(); i++){
            Sub sub = arr.get(i);
            System.out.println("이름 : "  + sub.name + " // 시작시간 : " + sub.start + " // 쇼요시간 : " + sub.len);
        }
        
        stack.add(arr.get(0));
        
        int index = 1;
        int time = stack.peek().start;
        int length = 0;
        
        while(index != arr.size()){
            Sub sub = stack.peek();
            
            if (sub.start > time){
                time = sub.start;
            }
            
            System.out.println(sub.name + " 하는중");
            
            // 현재시간 - 다음 과제 start로 남은 시간 평가
            length = arr.get(index).start - time;
            
            // 현재 과제 소요시간에 비해 시간이 충분하다면 시간 업데이트하고 빼준다.
            if (length > sub.len){
                time += sub.len;
                System.out.println(time + "에 완료하여 끝냈다.");
                ans.add(stack.pop().name);   
                // 스택에 과목이 없다면 일단 가져온다.
                if (stack.isEmpty()){
                    stack.add(arr.get(index));
                    time = arr.get(index).start;
                    index++;
                }
            }
            // 끝내자마자 다른과목 시작 가능할 경우
            else if (length == sub.len){
                time += sub.len;
                System.out.println(time + "에 완료하여 끝냈다.");
                ans.add(stack.pop().name);   
                stack.add(arr.get(index));
                index++;
            }
            // 중간에 끊어야 하는 경우
            else{
                sub.len -= length;
                time += length;
                stack.add(arr.get(index));
                System.out.println(time + "까지하고 " + sub.len + "남기고 스택에 냄겼다.");
                index++;
            }
        }
        
        while(!stack.isEmpty()){
            ans.add(stack.pop().name);
        }
        
        
        
        String[] answer = new String[plans.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    class Sub{
        public String name;
        public int start;
        public int len;
        Sub(String name, int start, int len){
            this.name = name;
            this.start = start;
            this.len = len;
        }
        
    }
}