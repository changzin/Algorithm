class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int attI = 0;
        int t, x, y, maxHealth, tx;
        t = bandage[0];
        x = bandage[1];
        y = bandage[2];
        tx = 0;
        maxHealth = health;
        
        for(int i = 1 ; i<= attacks[attacks.length-1][0]; i++){
            if (i==attacks[attI][0]){
                health -= attacks[attI][1];
                attI++;
                tx = 0;
                if (health <= 0){
                    health = -1;
                    break;
                }
            }
            else{
                health += x;
                tx++;
                if (tx == t){
                    health += y;
                    tx = 0;
                }
                if (health > maxHealth){
                    health = maxHealth;
                }
            }
        }
        answer = health;
        return answer;
    }
}