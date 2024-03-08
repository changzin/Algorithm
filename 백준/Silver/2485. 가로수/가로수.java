import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n, gap, ans;
		int[] arr;
		int[] dist;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dist = new int[n-1];
		ans = 0;

		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(br.readLine());
			if (i!=0){
				dist[i-1] = arr[i] - arr[i-1];
			}
		}
		
		gap = dist[0];
		for(int i = 1; i < n-1; i++){
			gap = gcd(gap, dist[i]);
		}
		
		for(int i = 0; i < n-1; i++){
			ans += (dist[i] / gap) - 1;
		}
		System.out.printf("%d", ans);
	}
	
	public static int gcd(int a, int b){
		int x, y;
		x = Math.max(a, b);
		y = Math.min(a, b);
		
		while(true){
			x = x % y;
			if (x == 0){
				return y;
			}
			y = y % x;
			if (y == 0){
				return x;
			}
		}
	}
}
