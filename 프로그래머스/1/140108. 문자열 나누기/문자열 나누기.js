function solution(s) {
    var answer = 0;

    let num = -1;
    let check = true;
    let same = 0;
    let notSame = 0;
    let lastIndex = -1;
    
    for(let i = 0; i < s.length; i++){
        let temp = s.charCodeAt(i) - 'a'.charCodeAt(0);
        if (check){
            num = temp;
            same = 1;
            notSame = 0;
            check = false;
        }
        else{
            if (num == temp){
                same++;
            }
            else{
                notSame++;
            }
            if (same == notSame){
                check = true;
                answer++;
                lastIndex = i;
            }
        }
    }
    
    if (lastIndex != s.length-1){
        answer++;
    }
    
    return answer;
}