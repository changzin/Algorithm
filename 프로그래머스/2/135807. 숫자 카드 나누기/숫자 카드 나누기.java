import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Set<Integer> setA = new HashSet<>();

        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        for(int i = 0; i < arrayA.length; i++){
            if (gcdB != 0 && arrayA[i] % gcdB == 0){
                gcdB = 0;
            }
            if (gcdA != 0 && arrayB[i] % gcdA == 0){
                gcdA = 0;
            }
        }
        
        return Math.max(gcdB, gcdA);
    }
    
    int gcd(int a, int b){
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        int rest = x % y;
        while(rest != 0){
            x = rest;
            if (rest < y){
                x = y;
                y = rest;
            }
            rest = x % y;
        }
        return y;
    }
}

