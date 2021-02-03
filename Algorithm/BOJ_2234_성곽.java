import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class BOJ_2234_성곽 {
	// 남 동 북 서
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	private static boolean[][] visited;
	private static int[][] map;
	private static int[][][] num;
	static int m, n, room, size, size_tmp, max;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		num = new int[n][m][4]; 
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				String s = Integer.toBinaryString(map[i][j]);
				int nn = 3;
				for (int k = s.length(); k > 0; k--) {
					num[i][j][nn] = s.charAt(k-1) - '0';
					nn--;
				}
			}
		}
		
		visited = new boolean[n][m];
		
		room = 0; // 방 개수
		size = 0; // 젤 큰 방 사이즈
		list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j]) {
					size_tmp = 1; 
					bfs(i, j);
					room++;
					list.add(size_tmp);
					size = Math.max(size, size_tmp);
					
				}
			}
		}
		System.out.println(room);
		System.out.println(size);
		
		solve();
		System.out.println(max);
		
		
	}

	private static void solve() {
		
		
		visited = new boolean[n][m];
		max = 0;
		for (int i = 0; i < n; i++) {
			for(int j=0; j<m; j++) {
				int temp = 0;
				if(!visited[i][j]) {
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if(x < 0 || y < 0 || x > n-1 || y > m-1 || visited[x][y]) continue;
						visited[i][j] = true;
						if(map[x][y] != map[i][j]) {
							temp = list.get(map[x][y]) + list.get(map[i][j]);
							max = Math.max(temp, max);
						}		
					}
				}
			}
		}
		
	}

	private static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a, b});
		visited[a][b] = true;
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int x = t[0];
			int y = t[1];
			
			
			map[x][y] = room; // 몇번째 방인지 넣어줌
			for (int i = 0; i < 4; i++) {
				if(num[x][y][i] == 0) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx < 0 || ny < 0 || nx > n-1 || ny > m-1 || visited[nx][ny]) continue;
					q.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					size_tmp++;
				}
			}
			
		}
		
		
	}

}
