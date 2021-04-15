
import java.util.*;
class PROG_42840_모의고사 {
    public int[] solution(int[] answers) {
        int[] a1 = {1,2,3,4,5};
		int[] a2 = {2,1,2,3,2,4,2,5};
		int[] a3 = {3,3,1,1,2,2,4,4,5,5};
		ArrayList<Integer> list = new ArrayList<Integer>();
        
        int a1_cnt = 0;
		int a2_cnt = 0;
		int a3_cnt = 0;
		for(int i=0; i<answers.length; i++) {
			if(answers[i] == a1[i%5]) {
				a1_cnt++;
			}
			if(answers[i] == a2[i%8]) {
				a2_cnt++;
			}
			if(answers[i] == a3[i%10]) {
				a3_cnt++;
			}
		}
        
        int max = (((a1_cnt<a2_cnt)?a2_cnt:a1_cnt)<a3_cnt)?a3_cnt:(a1_cnt<a2_cnt)?a2_cnt:a1_cnt;
		
		if(a1_cnt == max) 
			list.add(1);
		if(a2_cnt == max) 
			list.add(2);
		if(a3_cnt == max)
			list.add(3);
		
		int[] answer = new int[list.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}