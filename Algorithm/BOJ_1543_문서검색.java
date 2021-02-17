import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_1543_문서검색 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String document = br.readLine();
		String word = br.readLine();
		int len = word.length();
		int cnt = 0;
		
		for (int i = 0; i < document.length()-len+1; i++) {
			String substr = document.substring(i, i+len);
			if(substr.equals(word)) {
				cnt++;
				i += len-1;
			}
		}
		
		
		System.out.println(cnt);

	}

}
