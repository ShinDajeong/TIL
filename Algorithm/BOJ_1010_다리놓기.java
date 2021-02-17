import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_1010_다리놓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n2 = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			
			double answer = 1;
			n2 = (n2 > n1-n2)?n1-n2:n2;
			
			double r = (double) n2;
			double n = (double) n1;
			
			for (int i = 0; i < n2; i++) {
				answer *= n / r; 
				n--;
				r--;
			}
		
			
			System.out.println(Math.round(answer));
		}
		
	}

}
