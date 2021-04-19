import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {
	
	
	static int[][][] d = {
			// 상 하 좌 우
			{{}},
			{{-1,0}, {1,0}, {0, -1}, {0, 1}},
			{{-1, 0}, {1,0}},
			{{0, -1}, {0, 1}},
			{{-1, 0}, {0, 1}},
			{{1,0}, {0,1}},
			{{1,0}, {0, -1}},
			{{-1,0}, {0, -1}}
	};
	private static int[][] map;
	private static boolean[][] visited;
	private static int ans;
	private static int L;
	private static int N;
	private static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(R, C, 1);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited[i][j]) ans++;
				}
			}
			
			System.out.println("#"+tc+ " " +ans);
		}
		
	}
	private static void bfs(int r, int c, int l) {
		Queue<int[]> q = new LinkedList<>();
		
		visited[r][c] = true;
		q.add(new int[] {r,c,l});
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int x = arr[0];
			int y = arr[1];
			if(arr[2] == L) {
				break;
			}
			
			if(map[x][y] > 0) {
				int num = map[x][y];
				
				for (int k = 0; k < d[num].length; k++) {
					
					int nx = x + d[num][k][0];
					int ny = y + d[num][k][1];
					
					if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1) continue;
					if(visited[nx][ny] || map[nx][ny] == 0) continue;
					
					// 연결되어있는지 확인하기 위한 변수
					int tmp = map[nx][ny];
					if(num == 1) {
						if(k==0 && (tmp == 3 || tmp == 4 || tmp == 7)) continue;
						if(k==1 && (tmp == 3 || tmp == 5 || tmp == 6)) continue;
						if(k==2 && (tmp == 2 || tmp == 6 || tmp == 7)) continue;
						if(k==3 && (tmp == 2 || tmp == 4 || tmp == 5)) continue;
					}
					
					
					if(num == 2) {
						if(k==0 && (tmp == 3 || tmp == 4 || tmp == 7)) continue;
						if(k==1 && (tmp == 3 || tmp == 5 || tmp == 6)) continue;
					}
					
					else if(num == 3) {
						if(k==0) 
							if(tmp == 2 || tmp == 6 || tmp == 7) continue;
						if(k==1)
							if(tmp == 2 || tmp == 4 || tmp == 5) continue;
					}
					
					else if(num == 4) {
						if(k==0) 
							if(tmp == 3 || tmp == 4 || tmp == 7) continue;
						if(k==1)
							if(tmp == 2 || tmp == 4 || tmp == 5) continue;
					}
					
					else if(num == 5) {
						if(k==0) 
							if(tmp == 3 || tmp == 5 || tmp == 6) continue;
						if(k==1)
							if(tmp == 2 || tmp == 4 || tmp == 5) continue;
					}
					
					else if(num == 6) {
						if(k==0) 
							if(tmp == 3 || tmp == 5 || tmp == 6) continue;
						if(k==1)
							if(tmp == 2 || tmp == 6 || tmp == 7) continue;
					}
					
					else if(num == 7) {
						if(k==0) 
							if(tmp == 3 || tmp == 4 || tmp == 7) continue;
						if(k==1)
							if(tmp == 2 || tmp == 6 || tmp == 7) continue;
					}
					q.add(new int[] {nx, ny, arr[2]+1});
					visited[nx][ny] = true;
				}
			}
			
		}
		
		
	}

}
