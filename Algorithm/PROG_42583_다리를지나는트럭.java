import java.util.*;

class Truck {
    int weight;	// Ʈ���� ����
    int distance;	// Ʈ���� ������ �Ÿ�
    
    public Truck(int weight, int distance){
        this.weight = weight;
        this.distance = distance;
    }
}
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;	// �ּ� �ð�
        Queue<Truck> q = new LinkedList<>();
        
        int cnt = 0;	// �ٸ��� ���� Ʈ���� ����
        int total = 0;	// �ٸ��� �ִ� Ʈ������ ���� ��
        int idx = 0;	// ��� Ʈ�� ��ȣ (0��° ��� Ʈ������ Ʈ�� �ǳʱ� ����)
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