import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class BOJ_14442_벽부수고이동하기2 {

	private static int N, M, K;
	private static int[][] map;
	private static int[][][] dist;
	private static int result;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static class Point {
		int x;
		int y;
		int wall;
		int cnt;
		
		public Point(int x, int y, int wall, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.wall = wall;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dist = new int[N][M][K+1];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		dist[0][0][0] = 1;
		
		result = Integer.MAX_VALUE;
		bfs();
		
		if(result != Integer.MAX_VALUE) 
			System.out.println(result);
		else 
			System.out.println("-1");
	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0, 1));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == N-1 && p.y == M-1 && p.wall <= K) {
				result = Math.min(dist[p.x][p.y][p.wall], result);
			}
			
			for (int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				
				if((nx==0 && ny==0) || nx < 0 || ny < 0 || nx > N-1 || ny > M-1) continue;
				
				if(map[nx][ny] == 0) {
					if(dist[nx][ny][p.wall] == 0 || dist[nx][ny][p.wall] > p.cnt + 1) {
						dist[nx][ny][p.wall] = p.cnt + 1;
						q.add(new Point(nx, ny, p.wall, p.cnt + 1));
					}
				}
				
				else if(map[nx][ny] == 1 && p.wall < K) {
					if(dist[nx][ny][p.wall + 1] == 0 || dist[nx][ny][p.wall + 1] > p.cnt + 1) {
						dist[nx][ny][p.wall+1] = p.cnt + 1;
						q.add(new Point(nx, ny, p.wall + 1 , p.cnt + 1));
					}
				}
			}
		}
		
	}

}
