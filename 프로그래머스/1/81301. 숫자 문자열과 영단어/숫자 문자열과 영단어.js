function solution(s) {
    let ans = '';
    
    let i = 0;
    while(i < s.length){
        if (s[i] == 'z'){
            ans += '0'; i += 4;
        }
        else if (s[i] == 'o'){
            ans += '1'; i += 3;
        }
        else if (s[i] == 't' && s[i+1] == 'w'){
            ans += '2'; i +=3;
        }
        else if (s[i] == 't' && s[i+1] == 'h'){
            ans += '3'; i += 5;
        }
        else if (s[i] == 'f' && s[i+1] == 'o'){
            ans += '4'; i += 4;
        }
        else if (s[i] == 'f' && s[i+1] == 'i'){
            ans += '5'; i += 4;
        }
        else if (s[i] == 's' && s[i+1] == 'i'){
            ans += '6'; i+= 3;
        }
        else if (s[i] == 's' && s[i+1] == 'e'){
            ans += '7'; i += 5;
        }
        else if (s[i] == 'e' && s[i+1] == 'i'){
            ans += '8'; i+= 5;
        }
        else if (s[i] == 'n'){
            ans += '9'; i += 4;
        }
        else{
            ans += s[i];
            i++;
        }
    }
    
    
    
    var answer = 0;
    return parseInt(ans);
}