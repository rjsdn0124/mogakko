import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		int num = Integer.parseInt(st.nextToken());
		int line = Integer.parseInt(st.nextToken());
 
		arr = new int[line];
		visit = new boolean[num];
		dfs(num, line, 0);
		System.out.println(sb);
        
	}
 
	public static void dfs(int num, int line, int depth) {
		if (depth == line) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
 
		for (int i = 0; i < num; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(num, line, depth + 1);
				visit[i] = false;
			}
		}
	}
 
}
