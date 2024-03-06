import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] A = new int[1000000];
        int N, B, C, num;
        long ans;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ans = 0;
        for(int i = 0; i < N; i++){
            num = A[i] - B;
            if (num <= 0){
                ans = ans + 1;
                continue;
            }
            else if (num % C != 0){
                ans = ans + 2 + (num / C);
            }
            else{
                ans = ans + 1 + (num / C);
            }
        }

        System.out.print(ans);
    }
}