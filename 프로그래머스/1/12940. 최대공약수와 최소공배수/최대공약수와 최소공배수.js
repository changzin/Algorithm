function solution(n, m) {
    
    let gcdNum = gcd(n, m);
    let lcmNum = n * m / gcdNum;
    
    var answer = [gcdNum, lcmNum];
    return answer;
}

function gcd(a, b){
    if (a == 0){
        return 0;
    }    
    if (b == 0){
        return 0;
    }
    while (a != b){
        if (a > b){
            a -= b;
        }
        else if (b > a){
            b -= a;
        }
        
    }
    return a;
}