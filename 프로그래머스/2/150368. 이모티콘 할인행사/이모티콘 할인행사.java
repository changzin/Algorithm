class Solution {
    int[] discounts;
    int[] price;
    int len;
    int join;
    int pay;
    int[][] arr;
    int[] emo;
    public int[] solution(int[][] users, int[] emoticons) {
        arr = users;
        emo = emoticons;
        len = emoticons.length;    
        discounts = new int[len];
        price = new int[len];
        dfs(0);
        int[] answer = {join, pay};
        return answer;
    }
    
    void dfs(int weight){
        if (weight == len){
            int signIn = 0;
            int bill = 0;
            // 새로운 가격 책정
            for(int i = 0; i < len; i++){
                switch (discounts[i]){
                    case 0:
                        price[i] = emo[i];
                        break;
                    case 10:
                        price[i] = emo[i] / 10 * 9;
                        break;
                    case 20:
                        price[i] = emo[i] / 10 * 8;
                        break;
                    case 30: 
                        price[i] = emo[i] / 10 * 7;
                        break;
                    case 40:
                        price[i] = emo[i] / 10 * 6;
                        break;
                }
            }

            
//             for(int i = 0; i < len; i++){
//                 System.out.print(discounts[i] + " ");
//             }
//             System.out.println();
//             for(int i = 0; i < len; i++){                
//                 System.out.print(price[i] + " ");
//             }
//             System.out.println();
//             System.out.println();
            
            for(int i = 0; i < arr.length; i++){
                int s = arr[i][0];
                int p = arr[i][1];
                int payment = 0;
                for(int j = 0; j < price.length; j++){
                    if (s <= discounts[j]){
                        payment+=price[j];
                    }
                    if (payment >= p){
                        payment = 0;
                        signIn++;
                        break;
                    }
                }
                bill += payment;
            }
            
            if (signIn > join){
                join = signIn;
                pay = bill;
            }
            else if (signIn == join){
                pay = Math.max(pay, bill);
            }
            
            return;
        }
        
        for(int j = 0; j < 5; j++){
            discounts[weight] += j * 10;
            dfs(weight+1);
            discounts[weight] -= j * 10;
        }
    }
}