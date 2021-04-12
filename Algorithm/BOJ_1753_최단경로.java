import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 다익스트라 알고리즘
 * 그래프문제
 * 
 * 어떤 한 점에서 다른 점으로의 최단 경로를 알고 싶다!
 * 가중치가 모두 양수이다!
 * 
 * 1. 출발노드 설정
 * 2. 출발 노드 기준으로 각 노드의 최소 비용 저장
 * 3. 방문하지 않은 노드 중 가장 비용이 적은 노드 선택
 * 4. 해당 노드를 거쳐 특정 노드로 가는 경우 최소 비용 갱신
 * 5. 3~4번 반복!
 */


public class BOJ_1753_최단경로 {

	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());		
		
		ArrayList<Node>[] list = new ArrayList[V+1];
		// 잊지않기!!!!!
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			
			list[v1].add(new Node(v2, weight));
		}
		
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		// 출발지만 0으로 설정
		dist[K] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		pq.add(new Node(K, 0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			// 방문했으면 넘어감
			if(visited[n.vertex]) continue;
			visited[n.vertex] = true;
			
			// 방문 안했다면
			// 현재 노드와 연결되어 있는 노드 모두 탐색한다
			for (Node node : list[n.vertex]) {
				// 새로운노드(연결된노드)의 거리가 현재 노드+현재에서 새로운노드로 가는 비용보다 더 크다면 갱신!
				if(dist[node.vertex] > dist[n.vertex] + node.weight) {
					dist[node.vertex] = dist[n.vertex] + node.weight;
					
					// 갱신되었으면 pq에 넣어준다
					pq.add(new Node(node.vertex, dist[node.vertex]));
				}
			}
		}
		
		
		for (int i = 1; i < dist.length; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
		

	}

}
