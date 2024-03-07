import java.util.HashMap;
import java.util.StringTokenizer;
import java.lang.Math;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[][] giftLog = new int[50][50];
        int[] giftPoint = new int[50];
        int[] gift = new int[50];
        int a, b, maxValue;
        
        HashMap<String,Integer> map = new HashMap<>();
        StringTokenizer st;
        
        for(int i = 0; i < friends.length; i++){
            map.put(friends[i], i);
        }
        
        for(int i = 0; i < gifts.length; i++){
            st = new StringTokenizer(gifts[i], " ");
            
            a = map.get(st.nextToken());
            b = map.get(st.nextToken());
            
            giftPoint[a] = giftPoint[a]+1;
            giftPoint[b] = giftPoint[b]-1;
            giftLog[a][b] = giftLog[a][b]+1;
        }
        
        maxValue = 0;
        
        for(int i = 0; i < friends.length; i++){
            for(int j = 0; j < friends.length; j++){
                if (i==j){
                    continue;
                }
                else if (giftLog[i][j] > giftLog[j][i]){
                    gift[i] = gift[i]+1;
                }
                else if (giftLog[i][j] < giftLog[j][i]){
                    continue;
                }
                else if (giftPoint[i] > giftPoint[j]){
                    gift[i] = gift[i]+1;
                } 
            }
            if (maxValue < gift[i]){
                maxValue = gift[i];
            }
        }
        
        int answer = 0;
        answer = maxValue;
        return answer;
    }
}