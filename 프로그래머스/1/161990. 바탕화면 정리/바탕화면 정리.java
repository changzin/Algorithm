class Solution {
    public int[] solution(String[] wallpaper) {
        int lx, ly, rx, ry;
        
        lx = ly = Integer.MAX_VALUE;
        rx = ry = Integer.MIN_VALUE;
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if (wallpaper[i].charAt(j) == '#'){
                    lx = Math.min(lx, i);
                    ly = Math.min(ly, j);
                    rx = Math.max(rx, i+1);
                    ry = Math.max(ry, j+1);
                }
            }
        }
        int[] answer = {lx, ly, rx, ry};
        
        return answer;
    }
}