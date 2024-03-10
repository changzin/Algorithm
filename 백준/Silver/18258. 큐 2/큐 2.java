import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		Deque<Integer> q = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");	
			switch (st.nextToken()) {
				case "push":
					q.add(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if (q.isEmpty()) {
						sb.append(-1).append('\n');
					}
					else {
						sb.append(q.getFirst()).append('\n');
						q.removeFirst();
					}
					break;
				case "size":
					sb.append(q.size()).append('\n');
					break;
				case "empty":
					if (q.isEmpty()) {
						sb.append(1).append('\n');
					}
					else {
						sb.append(0).append('\n');
					}
					break;
				case "front":
					if (q.isEmpty()) {
						sb.append(-1).append('\n');
					}
					else {
						sb.append(q.getFirst()).append('\n');
					}
					break;
				case "back":
					if (q.isEmpty()) {
						sb.append(-1).append('\n');
					}
					else {
						sb.append(q.getLast()).append('\n');

					}	
			}
		}
		System.out.print(sb);
	}
}
