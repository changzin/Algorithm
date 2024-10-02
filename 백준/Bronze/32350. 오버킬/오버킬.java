import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());


        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
        }

        int count = 0;
        int index = 0;
        int extraDamage = 0;
        int hp = arr.get(index);

        while(true){
            // 때려야 하니까 턴 증가해줌.
            count++;
            
            // 데미지 입힌다.
            hp -= D;
            //System.out.printf("%d턴, %d번쨰 몬스터에게 공격, hp : %d\n", count, index, hp);

            // 몬스터 처치 시
            if (hp <= 0){
                // 오버킬 데미지 계산
                extraDamage = (-hp * p) / 100;
                index++;
                // 전부 처치했다면 반복 종료
                if (index == N){
                    break;
                }
                else{
                    hp = arr.get(index);
                }
            }

            // 오버킬 데미지가 존재할 시 계산
            if(extraDamage != 0){
                hp -= extraDamage;
                // System.out.printf("  %d번째 몬스터에 오버킬 발생, hp : %d, extraDamage : %d\n", index, hp, extraDamage);
                extraDamage = 0;

                // 오버킬로 몬스터를 잡았을 때.
                if (hp <= 0){
                    index++;
                    if (index == N){
                        break;
                    }
                    hp = arr.get(index);
                }
            }
        }
        System.out.print(count);
    }
}
