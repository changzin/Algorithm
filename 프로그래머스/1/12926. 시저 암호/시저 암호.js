function solution(s, n) {
    var answer = '';
    
    for(let i = 0; i < s.length; i++){
        let x = s[i].charCodeAt();
        if (x >= "a".charCodeAt() && x <= "z".charCodeAt()){
            x += n;
            if (x > "z".charCodeAt()){
                x = "a".charCodeAt() + (x % "z".charCodeAt())-1;
            }
            answer += String.fromCharCode(x);
        }
        else if (x >= "A".charCodeAt() && x <= "Z".charCodeAt()){
            x += n;
            if (x > "Z".charCodeAt()){
                x = "A".charCodeAt() + (x % "Z".charCodeAt())-1;
            }
            answer += String.fromCharCode(x);
        }
        else{
            answer += " ";
        }
    }
    
    return answer;
}