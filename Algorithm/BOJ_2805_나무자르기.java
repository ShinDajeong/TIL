import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int min = 0;
		int max = list.get(N-1);
		int result = 0;
		
		while(min <= max) {
			long sum = 0;
			int mid = (min + max) / 2;
			
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i) - mid > 0)
					sum += list.get(i) - mid;
			}
			
			if(sum >= M) {	// 나무의 길이 합이 M 이상이라면
				result = mid;
				min = mid + 1;	// 더 높게 잘라도 답이 될 수 있음
			}
				
			else	// 나무 길이 합이 M이 안된다면
				max = mid - 1;	// 더 낮게 잘라야 답이 존재함
			
		}
		
		System.out.println(result);
	}

}
