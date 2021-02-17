class Solution {
    public int[] solution(int brown, int yellow) {

//         int[] answer = new int[2];
//         int x = 0;
//         int y = 0;
        
//         for(int i=1; i<=brown/2-3; i++){
//             if(i * (brown / 2 - 2 - i) == yellow) {
//                 y = i;
//                 break;
//             }
//         }
        
//         x = yellow / y;
        
//         answer[0] = x + 2;
//         answer[1] = y + 2;
//         return answer;

        int[] answer = new int[2];
		
		int width = 0;
		int height = 0;
		int border = 0;
		
		for(int i=1; i<=yellow; i++) {
			height = i;
			if(yellow%i!=0)
				continue;
			width = yellow/height;
			
			border = 2*width + 2*height + 4;
			if(border == brown)
				break;
		}
		answer[0] = width + 2;
		answer[1] = height + 2;
        return answer;
    }
}