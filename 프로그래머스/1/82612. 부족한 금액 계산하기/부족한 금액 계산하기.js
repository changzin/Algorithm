function solution(price, money, count) {
    let sum = 0;
    for(let i = 1; i <= count; i++){
        let newprice = price * i;
        sum += newprice;        
    }
    return (sum <= money) ? 0 : sum - money;
}