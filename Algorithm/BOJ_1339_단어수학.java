import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class BOJ_1339_단어수학 {

	// 0~9까지 
	static boolean[] visited = new boolean[10];
	// 알파벳 리스트!
	static ArrayList<Character> list = new ArrayList<>();
	// 어떤 순서로 담을 것인지
	static int[] numbers;
	
	private static String[] str;
	static int max = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		str = new String[N];
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
			
			for (int j = 0; j < str[i].length(); j++) {
				if(!list.contains(str[i].charAt(j))) {
					list.add(str[i].charAt(j));
					count++;
				}
					
			}
		}
		
		numbers = new int[count];
		
		// 알파벳 오름차순 정렬
		Collections.sort(list);
		dfs(0, count);
		
		System.out.println(max);
		
	}
	
	private static void dfs(int cnt, int N) {
		if(cnt == N) {
			calc();
			
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(visited[i]) continue;
			numbers[cnt] = i;
			visited[i] = true;
			dfs(cnt+1, N);
			visited[i] = false;
		}
		
	}

	private static void calc() {
		int sum = 0;
		for(int i = 0; i<str.length; i++) {
			int temp = 0;
			for(int j=0; j<str[i].length(); j++) {
				temp *= 10;
				temp += numbers[list.indexOf(str[i].charAt(j))];
				
			}
			sum += temp;
		}
		
		max = Math.max(sum, max);
		
	}

}
