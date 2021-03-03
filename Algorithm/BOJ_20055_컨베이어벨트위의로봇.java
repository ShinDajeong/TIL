import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_20055_컨베이어벨트위의로봇 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[2][N];
		boolean[][] robot = new boolean[2][N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[0][i] = Integer.parseInt(st.nextToken());
		}
		for (int i = N-1; i >= 0; i--) {
			arr[1][i] = Integer.parseInt(st.nextToken());
		}
		
		
		int answer = 0;
		
		while(true) {
			
			answer++;
			
			// 땅에 올라가는 위치 값
			int n1 = arr[1][0];
			// 아랫줄
			for(int i=0; i<N-1; i++) {
				arr[1][i] = arr[1][i+1];
			}
			
			// 땅에 내려가는 위치 값
			int n2 = arr[0][N-1];
			// 윗줄 + 로봇도 같이 회전
			for (int i = N-1; i > 0; i--) {
				arr[0][i] = arr[0][i-1];
				robot[0][i] = robot[0][i-1];
			}
			
			// N의 위치에 있을 때 로봇 내려준다
			if(robot[0][N-1])
				robot[0][N-1] = false;
			
			robot[0][0] = false;
			arr[0][0] = n1;
			arr[1][N-1] = n2;
			
			
			// 로봇 이동
			for (int i = N-1; i > 0; i--) {
				if(robot[0][i-1] && !robot[0][i] && arr[0][i] >= 1) {
					robot[0][i] = true;
					robot[0][i-1] = false;
					arr[0][i]--;
				}
			}
						
			
			// 로봇을 올린다
			if(arr[0][0] != 0) {
				robot[0][0] = true;
				arr[0][0]--;
			}
			
			int cnt = 0;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == 0)
						cnt++;
				}
			}
			
			if(cnt >= K) break;
		}

		System.out.println(answer);
		
	}

}
