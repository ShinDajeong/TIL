import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_19238_스타트택시 {

	static class passenger implements Comparable<passenger>{
		int start_x;
		int start_y;
		int end_x;
		int end_y;
		
		public passenger(int start_x, int start_y, int end_x, int end_y) {
			this.start_x = start_x;
			this.start_y = start_y;
			this.end_x = end_x;
			this.end_y = end_y;
		}

		@Override
		public int compareTo(passenger o) {
			if(this.start_x == o.start_x)
				return this.start_y - o.start_y;
			return this.start_x - o.start_x;
		}
		
		
	}
	
	private static ArrayList<passenger> list;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static int N;
	private static int[][] map;
	static boolean[][] visited;
	private static int fuel;
	private static int t_x, t_y;
	static boolean check, go1, go2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		t_x = Integer.parseInt(st.nextToken());	// �ýð� ����ϴ� ��ġ
		t_y = Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList<passenger>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list.add(new passenger(a,b,c,d));
		}

		Collections.sort(list);
		
		
		while(list.size() != 0) {
			check = true;
			go1 = false;
			go2 = false;
			visited = new boolean[N+1][N+1];
			bfs(t_x,t_y);	// �ýð� �̵��� �ִ� �Ÿ��� �޾ƿ�
			if(!check || !go1 || !go2 ||  fuel < 0) {
				break;
			}
			
		}
		if(!check || !go1 || !go2 ||  fuel < 0) System.out.println("-1");
		else System.out.println(fuel);
		
	}
	private static void bfs(int x, int y) {
		int idx = -1;
		
		int distance = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {x, y, 0});
			visited = new boolean[N+1][N+1];
			while(!q.isEmpty()) {
				int[] loc = q.poll(); // ���� �ý��� ��ġ
				if(distance > loc[2] && loc[0] == list.get(i).start_x && loc[1] == list.get(i).start_y) {
					idx = i;
					distance = loc[2]; 
					break;
				}
				for (int k = 0; k < 4; k++) {
					int nx = loc[0] + dx[k];
					int ny = loc[1] + dy[k];
					
					if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
					if(visited[nx][ny] == true || map[nx][ny] == 1) continue;
					
					q.add(new int[] {nx, ny, loc[2] + 1});
					visited[nx][ny] = true;
				}
				
			}
		}
		
		if(distance != Integer.MAX_VALUE) {
			go1 = true;
			fuel -= distance;
			if(fuel < 0)
				check = false;
		}
		
		if(idx < 0 )
			return;
		
		// �մ� ��������� �մ� ������������ �ִܰ��
		Queue<int[]> q2 = new LinkedList<>();
		visited = new boolean[N+1][N+1];
		q2.add(new int[] {list.get(idx).start_x, list.get(idx).start_y, 0});
		
		while(!q2.isEmpty()) {
			int[] loc = q2.poll(); // ���� �ý��� ��ġ

			if(loc[0] == list.get(idx).end_x && loc[1] == list.get(idx).end_y) {
				go2 = true;
				fuel -= loc[2];
				if(fuel < 0)
					check = false;
				fuel += 2*loc[2];
				break;
			}
			for (int k = 0; k < 4; k++) {
				int nx = loc[0] + dx[k];
				int ny = loc[1] + dy[k];
				
				
				if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
				if(visited[nx][ny] == true || map[nx][ny] == 1) continue;
				
				q2.add(new int[] {nx, ny, loc[2] + 1});
				visited[nx][ny] = true;
			}
		}
		
		t_x = list.get(idx).end_x;
		t_y = list.get(idx).end_y;
		list.remove(idx);
	}

}
