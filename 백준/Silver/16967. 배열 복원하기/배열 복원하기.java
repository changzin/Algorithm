import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int h, w, x, y, eh, ew;
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        // 겹쳐지는 배열은 x ~ eh, y ~ ew에 위치함
        eh = h + x;
        ew = w + y;


        int[][] arr = new int[eh][ew];
        int[][] ans = new int[h][w];

        for(int i = 0; i < eh; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < ew; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if (i < x || j < y){
                    ans[i][j] = arr[i][j];
                }
                else{
                    ans[i][j] = arr[i][j] - ans[i-x][j-y];
                }
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.printf(ans[i][j] + " ");
            }
            System.out.printf("\n");
        }

    }
}