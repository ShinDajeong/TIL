import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1949_등산로조성 {

	private static int[][] map;
	private static int[][] map_copy;
	private static int N;
	private static int K;
	private static boolean[][] visited;
	static int ans;
	// 위 아래 왼 오
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			map_copy = new int[N][N];
			
			int max_height = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max_height = Math.max(max_height, map[i][j]);
				}
			}
			
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == max_height) {
						init();
						visited[i][j] = true;
						dfs(i, j, 0, 1);
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
		
	}

	private static void init() {
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map_copy[i][j] = map[i][j];
			}
		}
	}

	private static void dfs(int x, int y, int cnt, int dist) {
		
		ans = Math.max(ans, dist);
		
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 ) continue;
			if(visited[nx][ny]) continue;
			
			if(map_copy[nx][ny] < map_copy[x][y]) {
				visited[nx][ny] = true;
				dfs(nx, ny, cnt, dist+1);
				visited[nx][ny] = false;
			}
				
			else {
				if(cnt == 0) {
					for(int i=1; i<= K; i++) {
						if(map_copy[nx][ny] - i < map_copy[x][y]) {
							map_copy[nx][ny] -= i;
							visited[nx][ny] = true;
							dfs(nx, ny, cnt+1 , dist+1);
							map_copy[nx][ny] += i;
							visited[nx][ny] = false;
						}
					}
				}
				
			}
			
			
		}
		
	}

}
