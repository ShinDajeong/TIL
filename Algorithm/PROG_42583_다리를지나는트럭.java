import java.util.*;

class Truck {
    int weight;	// 트럭의 무게
    int distance;	// 트럭이 움직인 거리
    
    public Truck(int weight, int distance){
        this.weight = weight;
        this.distance = distance;
    }
}
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;	// 최소 시간
        Queue<Truck> q = new LinkedList<>();
        
        int cnt = 0;	// 다리를 지난 트럭의 개수
        int total = 0;	// 다리에 있는 트럭들의 무게 합
        int idx = 0;	// 대기 트럭 번호 (0번째 대기 트럭부터 트럭 건너기 시작)
        while(true){
            answer++;
            
            if(cnt == truck_weights.length)
                break;
            
            if(idx < truck_weights.length && total + truck_weights[idx] <= weight){
                q.add(new Truck(truck_weights[idx], 0));
                total += truck_weights[idx];
                idx++;
            }
            
            int size = q.size();
            for(int i=0; i<size; i++){
                Truck T = q.poll();
                if(T.distance+1 == bridge_length) {
                    total -= T.weight;
                    cnt++;
                }
                else {
                    q.add(new Truck(T.weight, T.distance+1));
                }
            }
        }
        

        return answer;
    }
}