import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {

	private static boolean[] visited;
	private static int N;
	private static int[][] map;
	private static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			visited = new boolean[N];
			dfs(0, 0);
			
			
			System.out.println("#"+tc+ " " +min);
			
		}


	}

	private static void dfs(int start, int cnt) {
		if(cnt == N/2) {
			calc();
			return;
		}
		
		for (int i = start; i < N; i++) {
			visited[i] = true;
			dfs(i+1, cnt+1);
			visited[i] = false;
		}
		
		
	}

	private static void calc() {
		
		int sumA = 0;
		int sumB = 0;
		
		
		for (int i = 0; i < visited.length-1; i++) {
			for (int j = i+1; j < visited.length; j++) {
				if(visited[i] && visited[j]) {
					sumA += (map[i][j] + map[j][i]);
				}
				if(!visited[i] && !visited[j])
					sumB += (map[i][j] + map[j][i]);
			}
		}
		
		
		min = Math.min(min, Math.abs(sumA - sumB));
		
	}

}
