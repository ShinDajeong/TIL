import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class BOJ_11725_트리의부모찾기 {

	private static int[] parent;
	private static int n;
	private static LinkedList<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new LinkedList[n+1];
		
		for (int i = 1; i <= n; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		parent = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			if(parent[i] == 0) {
				dfs(i);
			}
		}
		
		for (int i = 2; i <= n; i++) {
			System.out.println(parent[i]);
		}

	}

	private static void dfs(int i) {
		
		for (int l : list[i]) {
			if(parent[l] == 0) {
				parent[l] = i;
				dfs(l);
			}
		}
		
	}

}
