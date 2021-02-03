import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_회의실배정 {

	static class Class implements Comparable<Class>{
		int start;
		int end;

		public Class(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Class o) {
			if(this.start != o.start)
				return this.start - o.start;
			else 
				return this.end - o.end;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> unused = new PriorityQueue<>();
		
		ArrayList<Class> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Class(start, end));
		}
		
		Collections.sort(list);
		
		int cnt = 1;
		unused.add(list.get(0).end);
		for (int i = 1; i < list.size(); i++) {
			
			int num = unused.peek();
			
			if(list.get(i).start < num) {
				cnt++;
				
			}else {
				unused.poll();
			}
			
			unused.add(list.get(i).end);
			
		}
		
		System.out.println(cnt);
		
	}

}
