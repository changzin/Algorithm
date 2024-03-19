class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
    
        int second1 = (h1 * 3600) + (m1 * 60) + s1;
        // 12시간(한바퀴)는 43200초, 시침이 한 바퀴 돌 동안 719번 울림, 
        int hp1 = second1 * 719 / 43200;
        // 60분(한바퀴)는 3600초, 분침이 한 바퀴 돌 동안 59번 울림
        int mp1 = second1 * 59 / 3600;
        int point1 = hp1 + mp1;
        if (second1 >= 43200){
            point1--;
        }
        
        int second2 = (h2 * 3600) + (m2 * 60) + s2;
        int hp2 = second2 * 719 / 43200;
        int mp2 = second2 * 59 / 3600;
        int point2 = hp2 + mp2;
        if (second2 >= 43200){
            point2--;
        }
        
        System.out.print(point2 + " " + point1);
        
        int answer = point2 - point1;
        
        if (s1 * 720 == (m1*60+s1) * 12 || s1 * 720 == (h1*3600+m1*60+s1)){
            answer++;
        }
        
        return answer;
    }
}