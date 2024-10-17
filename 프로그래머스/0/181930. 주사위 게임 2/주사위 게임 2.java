class Solution {
    public int solution(int a, int b, int c) {
        // a랑 b가 같고, b랑 c가 같으면 a랑 c도 같겠지?
        // a == b == c 조건
        if (a == b && b == c){
            return (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
        }
        // a != b != c 다 다를때
        else if (a != b && b != c && a != c){
            return (a + b + c);
        }
        else{
            return (a + b + c) * (a * a + b * b + c * c);
        }
    }
}