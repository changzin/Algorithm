import java.util.*;

class Solution {
    int[] label = new int[2501];
    String[] values = new String[2501];
    List<String> ans = new ArrayList<>();
    
    public String[] solution(String[] commands) {
        int x, y, nx, ny;
        String command, value, nextValue;
        StringTokenizer st;
        for(int i = 1; i <= 2500; i++){
            label[i] = i;
        }
        for(int i = 0; i < commands.length; i++){
            st = new StringTokenizer(commands[i], " ");
            command = st.nextToken();
            if (command.equals("UPDATE")){
                if(st.countTokens() == 2){
                    value = st.nextToken();
                    nextValue = st.nextToken();
                    for(int j = 0; j <= 2500; j++){
                        if (values[j] != null){
                            if (values[j].equals(value)){
                                values[j] = nextValue;
                            }
                        }
                    }
                }                
                else{
                    x = Integer.parseInt(st.nextToken())-1;
                    y = Integer.parseInt(st.nextToken())-1;
                    value = st.nextToken();
                    int index = find(convertIndex(x, y));
                    values[index] = value;
                }
            }
            else if (command.equals("MERGE")){
                x = Integer.parseInt(st.nextToken())-1;
                y = Integer.parseInt(st.nextToken())-1;
                nx = Integer.parseInt(st.nextToken())-1;
                ny = Integer.parseInt(st.nextToken())-1;
                combine(x, y, nx, ny);
            }
            else if (command.equals("UNMERGE")){
                x = Integer.parseInt(st.nextToken())-1;
                y = Integer.parseInt(st.nextToken())-1;        
                int index = convertIndex(x, y);
                int root = find(index);
                value = values[root];
                List<Integer> arr= new ArrayList<>();
                
                for(int j = 0; j <= 2500; j++){
                    if (find(j) == root){
                        arr.add(j);
                    }
                }     
                for(int j = 0; j < arr.size(); j++){
                    label[arr.get(j)] = arr.get(j);
                    values[arr.get(j)] = null;
                }
                values[index] = value;
            }
            else{
                x = Integer.parseInt(st.nextToken())-1;
                y = Integer.parseInt(st.nextToken())-1;
                String result = values[find(convertIndex(x, y))];
                if (result == null){
                    ans.add("EMPTY");
                }
                else{                
                    ans.add(result);
                }
            }
            // print();
        }
        String[] answer = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    void print(){
        for(int i = 0; i < 2; i++){
            for(int j = 0; j <2; j++){
                System.out.print(values[convertIndex(i, j)] + " ");
            }
            System.out.println();
        }
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(find(convertIndex(i, j)) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    void combine(int x, int y, int nx, int ny){
        int a = find(convertIndex(x, y));
        int b = find(convertIndex(nx, ny));
        
        if (values[a] == null && values[b] != null){
            merge(b, a);
        }
        else{
            merge(a, b);
        }
    }    
    int convertIndex(int x, int y){
        return (x * 50) + y;
    }    
    
    void merge(int a, int b){
        int x = find(a);
        int y = find(b);
        
        label[y] = x;
    }
    
    int find(int x){
        if (label[x] == x){
            return x;
        }
        return label[x] = find(label[x]);
    }    
}