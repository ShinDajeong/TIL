import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * 범위 신경쓰기 !!!
 * 최댓값, 최솟값은 9876543210 이 될 수 있고
 * int형의 범위를 넘는다
 * -> long 형! 
 * 
 */



public class BOJ_2529_부등호 {

	static boolean visited[] = new boolean[10];
	static int numbers[];
	private static int n;
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;
	private static char[] ch;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		ch = new char[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < ch.length; i++) {
			ch[i] = st.nextToken().charAt(0);
		}
		
		numbers = new int[n+1];
		
		dfs(0);
		
		String max_value;
		String min_value;
		
		if(max < Math.pow(10, n)) {
			max_value = 0 + Long.toString(max);
		}else {
			max_value = Long.toString(max);
		}
		
		if(min < Math.pow(10, n)) {
			min_value = 0 + Long.toString(min);
		}else {
			min_value = Long.toString(min);
		}
		
		System.out.println(max_value);
		System.out.println(min_value);
	}
	
	private static void dfs(int cnt) {
		if(cnt == n+1) {
			if(check()) {
				long tmp = 0;
				for (int i = 0; i < numbers.length; i++) {
					tmp *= 10;
					tmp += numbers[i];
				}
				
				max = Long.max(max, tmp);
				min = Long.min(min, tmp);
				
				
			}
			return;
		}

		for (int i = 0; i < 10; i++) {
			if(visited[i]) continue;
			numbers[cnt] = i;
			visited[i] = true;
			dfs(cnt+1);
			visited[i] = false;
		}
		
	}

	private static boolean check() {
		for (int i = 0; i < numbers.length-1; i++) {
			if(ch[i] == '<') {
				if(numbers[i] > numbers[i+1]) return false;
			}
			else {
				if(numbers[i] < numbers[i+1]) return false;
			}
		}
		
		return true;
	}

}
