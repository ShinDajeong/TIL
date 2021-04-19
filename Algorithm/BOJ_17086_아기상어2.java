import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {

	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		int[][] dist = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1)
					q.add(new int[]{i, j});
			}
		}
		
		int max = 0;
		while(!q.isEmpty()) {
			int[] num = q.poll();
			
			for (int k = 0; k < 8; k++) {
				int nx = num[0] + dx[k];
				int ny = num[1] + dy[k];
				
				if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1) continue;
				if(dist[nx][ny] == 0 && arr[nx][ny] != 1) {
					dist[nx][ny] = dist[num[0]][num[1]] + 1;
					max = Math.max(max, dist[nx][ny]);
					q.add(new int[] {nx, ny});	
				}
			}
		}
		System.out.println(max);
		
		
	}

}
