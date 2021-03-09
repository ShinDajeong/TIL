import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1405_미친로봇 {

	private static int[][] map;
	private static double answer;
	private static int N;
	private static int[] dir;
	private static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		// 동서남북으로 갈 확률
		dir = new int[5];
		for (int i = 1; i < dir.length; i++) {
			dir[i] = Integer.parseInt(st.nextToken());
		}

		map = new int[2*N+1][2*N+1];
		numbers = new int[N];
		answer = 0;
		map[N][N] = 1;
		dfs(N, N, 0);
		System.out.println(answer);
	}

	private static void dfs(int i, int j, int cnt) {
		if(map[i][j] > 1)
			return;
		
		if(cnt == N) {
			// answer(확률) 계산
			double num = 1;
			for (int l = 0; l < numbers.length; l++) {
				num *= (double) dir[numbers[l]]/ 100;
			}
			answer += num;
			return;
		}
		
		
		for (int k = 1; k <= 4; k++) {
			if(dir[k] > 0) {
				// 동
				if(k==1) {
					map[i][j+1] += 1;
					numbers[cnt] = k;
					dfs(i, j+1, cnt+1);
					map[i][j+1] -= 1;
				}
				// 서
				if(k==2) {
					map[i][j-1] += 1;
					numbers[cnt] = k;
					dfs(i, j-1, cnt+1);
					map[i][j-1] -= 1;
				}
				// 남
				if(k==3) {
					map[i+1][j] += 1;
					numbers[cnt] = k;
					dfs(i+1, j, cnt+1);
					map[i+1][j] -= 1;
				}
				// 북
				if(k==4) {
					map[i-1][j] += 1;
					numbers[cnt] = k;
					dfs(i-1, j, cnt+1);
					map[i-1][j] -= 1;
				}
			
				
	
				
			}
		}
		
		
		
	}

}
