// 전보
// N개의 도시와 M개의 통로.  C 도시에서 발생한 상황을 메시지로 전달. 
// C에서 보낸 메시지를 받게되는 도시의 총 개수와 걸리는 시간 출력
// 1 <= N <= 30000, 1 <= M <= 200000, 1 <= C <= N

// 둘째 줄부터 M+1 번째 줄까지 통로에 대한 정보
// x 에서 y로 이어지는 통로의 비용 z
// 1 <= x,y <= N , 1 <= z <= 1000

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

class Main {
    static final int INF = (int) 1e9;
    static int N, M, C; // 도시의 개수 N, 통로의 개수 M, 메시지 전달 도시 C
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>(); // 노드 연결정보
    static int dp[] = new int[30001]; // 최단거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보 입력받기
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            // x번 노드에서 y번 노드로 가는 비용 z
            graph.get(x).add(new Node(y,z));
        }

        // 최단거리 테이블 모두 INF로 초기화
        Arrays.fill(dp, INF);

        // 다익스트라 알고리즘 수행
        dijkstra(C);

        // 도달할 수 있는 노드의 개수
        int cnt = 0;
        // 도달할 수 있는 노드 중 가장 멀리 있는 노드와의 최단거리
        int maxDistance = 0;

        for(int i = 1; i <= N; i++){
            if(dp[i] != INF){
                cnt += 1;
                maxDistance = Math.max(maxDistance, dp[i]);
            }
        }

        bw.write((cnt-1) + " " + maxDistance + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여 큐에 삽입
        pq.offer(new Node(start, 0));
        dp[start] = 0;

        while(!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.getDistance(); // 현재 노드까지의 비용 
            int now = node.getIndex(); // 현재 노드
            
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (dp[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dp[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < dp[graph.get(now).get(i).getIndex()]) {
                    dp[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}
