import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_20057_마법사상어와토네이도 {

	static int[] arr = {2,10,7,1,5,10,7,1,2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		int first_sum = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				first_sum += map[i][j];
			}
		}
		// 시작 위치
		int x = N/2;
		int y = N/2;
		int cnt = 1; // 같은 방향으로 몇 번 가야하는지
		for (int i = 0; i < 2*N-1; i++) {
			
			
			// 왼쪽으로 이동
			if(i%4 == 0) {
				for (int j = 0; j < cnt; j++) {
					y--;
					double num = (double) map[x][y] / 100;
					
					if(x-2 >= 0)
						map[x-2][y] += num * 2;
					
					if(x-1 >= 0) {
						if(y-1 >= 0)
							map[x-1][y-1] += num * 10;
						map[x-1][y] += num * 7;
						if(y+1 < N)
							map[x-1][y+1] += num * 1;
					}
					
					if(y-2 >= 0)
						map[x][y-2] += num * 5;
					
					if(x+1 < N) {
						if(y-1 >= 0)
							map[x+1][y-1] += num * 10;
						map[x+1][y] += num * 7;
						if(y+1 < N)
							map[x+1][y+1] += num * 1;
					}
					
					if(x+2 < N)
						map[x+2][y] += num * 2;
					
					int sum = 0;
					for (int k = 0; k < 9; k++) {
						sum += num * arr[k];
					}
					
					if(y-1 >= 0)
						map[x][y-1] += map[x][y] - sum;
					
					map[x][y] = 0;
					if(x == 0 && y == 0) break;
					
				}
			}
			// 아래로 이동
			if(i%4 == 1) {
				for (int j = 0; j < cnt; j++) {
					x++;
					
					double num = (double) map[x][y] / 100;
					
					if(x-1 >= 0) {
						if(y-1 >= 0)
							map[x-1][y-1] += num * 1;
						if(y+1 < N)
							map[x-1][y+1] += num * 1;
					}
					
					if(y-2 >= 0)
						map[x][y-2] += num * 2;
					if(y-1 >= 0)
						map[x][y-1] += num * 7;
					if(y+1 < N)
						map[x][y+1] += num * 7;
					if(y+2 < N)
						map[x][y+2] += num * 2;
					
					if(x+1 < N) {
						if(y-1 >= 0)
							map[x+1][y-1] += num * 10;
						if(y+1 < N)
							map[x+1][y+1] += num * 10;
					}
					
					if(x+2 < N)
						map[x+2][y] += num * 5;
					
					int sum = 0;
					for (int k = 0; k < 9; k++) {
						sum += num * arr[k];
					}
					
					if(x+1 < N)
						map[x+1][y] += map[x][y] - sum;
					
					map[x][y] = 0;
					
					
				}
				
			}
			// 오른쪽으로 이동
			if(i%4 == 2) {
				for (int j = 0; j < cnt; j++) {
					y++;
					
					double num = (double) map[x][y] / 100;
					
					if(x-2 >= 0)
						map[x-2][y] += num * 2;
					
					if(x-1 >= 0) {
						if(y-1 >= 0)
							map[x-1][y-1] += num * 1;
						map[x-1][y] += num * 7;
						if(y+1 < N)
							map[x-1][y+1] += num * 10;
					}
					
					if(y+2 < N)
						map[x][y+2] += num * 5;
					
					if(x+1 < N) {
						if(y-1 >= 0)
							map[x+1][y-1] += num * 1;
						map[x+1][y] += num * 7;
						if(y+1 < N)
							map[x+1][y+1] += num * 10;
					}
					
					if(x+2 < N)
						map[x+2][y] += num * 2;
					
					int sum = 0;
					for (int k = 0; k < 9; k++) {
						sum += num * arr[k];
					}
					
					if(y+1 < N)
						map[x][y+1] += map[x][y] - sum;
					
					map[x][y] = 0;
					

				}
			}
			// 위로 이동
			if(i%4 == 3) {
				for (int j = 0; j < cnt; j++) {
					x--;
					
					double num = (double) map[x][y] / 100;
					
					if(x-2 >= 0)
						map[x-2][y] += num * 5;
					
					if(x-1 >= 0) {
						if(y-1 >= 0)
							map[x-1][y-1] += num * 10;
						if(y+1 < N)
							map[x-1][y+1] += num * 10;
					}
					
					if(y-2 >= 0)
						map[x][y-2] += num * 2;
					if(y-1 >= 0)
						map[x][y-1] += num * 7;
					if(y+1 < N)
						map[x][y+1] += num * 7;
					if(y+2 < N)
						map[x][y+2] += num * 2;
					
					if(x+1 < N) {
						if(y-1 >= 0)
							map[x+1][y-1] += num * 1;
						if(y+1 < N)
							map[x+1][y+1] += num * 1;
					}
					
					int sum = 0;
					for (int k = 0; k < 9; k++) {
						sum += num * arr[k];
					}
					if(x-1 >= 0)
						map[x-1][y] += map[x][y] - sum;
					
					map[x][y] = 0;
					
				}
			}
			
			
			// 같은 방향으로 몇 번 갈 것인지 정해줌
			if(i > 0 && i%2 == 1) {
				cnt++;
			}
		}
		
		
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sum += map[i][j];
			}
		}


		System.out.println(first_sum - sum);
		
	}

}
