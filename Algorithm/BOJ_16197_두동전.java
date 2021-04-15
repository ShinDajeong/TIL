import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16197_두동전 {

	// 사방탐색~!
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[N][M];
		
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i] = str.toCharArray();
				// 동전위치를 찾으면 queue에 넣어줍니다
				if(arr[i][j] == 'o')
					q.add(new int[] {i, j, 0, 1});
			}
		}
		
		int ans = 0;
		
		O : while(!q.isEmpty()) {
			// q에서 2개씩 꺼내줍니다
			int[] a = q.poll();
			int[] b = q.poll();
			
			// ans는 거리로 설정합니다
			ans = a[2];
			
			// 만약에 ans가 10이 되었다면 중단합니다 (0부터 시작했기때문에)
			if(ans > 9) {
				ans = -1;
				break;
			}
			
			
			for (int k = 0; k < 4; k++) {
				// a의 nx, ny
				int nx1 = a[0] + dx[k];
				int ny1 = a[1] + dy[k];
				
				// b의 nx, ny
				int nx2 = b[0] + dx[k];
				int ny2 = b[1] + dy[k];
		
				
				// 만약 동전이 밖으로 빠져나왔다면 a[3]을 0으로 바꿔줍니다
				if(nx1 < 0 || ny1 < 0 || nx1 > N-1 || ny1 > M-1) {
					a[3] = 0;
				}else {
					a[3] = 1;
				}
				
				// 만약 동전이 밖으로 빠져나왔다면 b[3]을 0으로 바꿔줍니다
				if(nx2 < 0 || ny2 < 0 || nx2 > N-1 || ny2 > M-1) {
					b[3] = 0;
				}else {
					b[3] = 1;
				}
				
				// 두 동전이 모두 배열안에 있을때만 
				if(a[3]==1 && b[3]==1) {
					// 벽이라면 원래 초기값을 넣어주고
					if(arr[nx1][ny1] == '#') {
						q.add(new int[] {a[0], a[1], ans+1, a[3]});
					}
					// 벽이 아니라면 새로운 nx ny를 넣어줍니다
					else {
						q.add(new int[] {nx1, ny1, ans+1, a[3]});
					}
					
					if(arr[nx2][ny2] == '#') {
						q.add(new int[] {b[0], b[1], ans+1, b[3]});
					}
					else {
						q.add(new int[] {nx2, ny2, ans+1, b[3]});
					}
				}
				// 만약 하나의 동전만 밖으로 나갔을 때 종료해줍니다
				if( (a[3]==1 && b[3]==0) || (a[3]==0 && b[3]==1)) break O;

			}
			
			
		}
		// 10회이상 탐색해야하면 -1를 출력해주고
		if(ans == -1) System.out.println(ans);
		// 아니라면 ans를 출력해준다 (0부터시작해서 +1해준다)
		else System.out.println(ans+1);
		
	}

}
