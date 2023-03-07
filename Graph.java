import java.util.Scanner;
 
class Graph{
    class AdjlistNode { 
        // 정점을 가지는 노드 AdjlistNode
        int vertex;       // 정점
        AdjlistNode next;// 다음 노드
         
        public AdjlistNode(int v){  // 간선을 가지는 노드 생성
            vertex = v;   
            next = null;  
        }
    }
     
    class AdjList{ 
        // AdjlistNode를 가리킬 수 있는 head, tail노드 
        int num_members; // 해당 노드와 연결된 개수도 저장
        AdjlistNode head;
        AdjlistNode tail;
         
        public AdjList(){
            num_members = 0; // 간선 개수 0개
            head = tail = null; // head와 tail 초기화
        }
    }
      
    int num_vertices; // 노드의 개수
    AdjList []adjListArr; 
     
    public Graph(int n){ // 정점, 간선, head와 tail을 가지는 노드 -> 그래프
        num_vertices = n; // 정점 개수 대입
        adjListArr = new AdjList[n]; // 정점 개수만큼 AdjList 생성
        for (int i = 0; i < n; i++){
            adjListArr[i] = new AdjList(); // adjListArr[] 초기화
        }
    }
     
    void addEdge(int src, int dest){  // 양방향으로 간선 추가 (출발 정점, 도착 정점)
        AdjlistNode newNode = new AdjlistNode(dest); 
        // 노드 생성시 도착 정점을 newNode로 넘김
        if (adjListArr[src].tail != null){ 
            // 출발 정점을 인덱스로 하여 tail 노드가 NULL이 아닐 경우,
            adjListArr[src].tail.next = newNode;  // tail의 다음 노드와
            adjListArr[src].tail = newNode;  // tail 노드가 도착 정점과 연결 
        }
        else{
            // 출발 정점을 인덱스로 하는 노드의 tail 노드가 NULL일 경우,
            adjListArr[src].head = adjListArr[src].tail = newNode;
            // head와 tail 모두 도착 정점과 연결
        }
        adjListArr[src].num_members++; // 연결 후 해당 정점의 간선 개수 증가
         
        newNode = new AdjlistNode(src); 
        // 도착 정점에서 출발 정점을 이어주는 동작
        if (adjListArr[dest].tail != null){
            // 도착 정점을 인덱스로 하여 tail 노드가 출발 정점노드를 가리킴
            adjListArr[dest].tail.next = newNode; // tail의 다음 노드와
            adjListArr[dest].tail = newNode; // tail 노드가 출발 정점과 연결
        }
        else{
            // 도착 정점을 인덱스로 하는 노드의 tail 노드가 NULL일 경우
            adjListArr[dest].head = adjListArr[dest].tail = newNode;
            // head와 tail 모두 출발 정점과 연결
        }
        adjListArr[dest].num_members++; // 연결 후 해당 정점의 간선 개수 증가
    }
     
    void display(int i){ // 그래프 출력
        AdjlistNode adjList = adjListArr[i].head; 
        // 그래프 헤드가 가리키는 노드를 대입함
        while (adjList != null){
            System.out.printf("%d ", adjList.vertex); // 정점 출력
            adjList = adjList.next; // 정점이 가리키는 다음 노드로 이동
        }
        System.out.printf("\n");
    }
}
 
class Exercise{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 입력
        for (int test_case = 1; test_case <= T; test_case++){
            int V = sc.nextInt(); // 정점 개수
            int E = sc.nextInt(); // 간선 개수
            int Q = sc.nextInt(); // 쿼리 개수
            Graph graph = new Graph(V); // 그래프 생성
            for (int i = 0; i < E; i++){ // 간선 정보 입력
                int sv = sc.nextInt(); 
                int ev = sc.nextInt();
                graph.addEdge(sv, ev); // 그래프에 간선 추가
            }
            System.out.printf("#%d\n", test_case);
            for (int i = 0; i < Q; i++){
                int sv = sc.nextInt();  // 쿼리 입력
                graph.display(sv); // 연결된 정점출력
            }
        }
        sc.close();
    }
}

/* 
===================================================
                     입력
===================================================
2     // 테스트 케이스 T
6 7 3 // 정점 개수V, 간선 개수E, 쿼리 개수Q
0 1   // 간선 정보 7개
0 2
0 3
1 2
1 4
3 4
4 5
0      // 쿼리1 : 정점 번호
2      // 쿼리2	
4      // 쿼리3
9 10 3 // 정점 개수V, 간선 개수E, 쿼리 개수Q
0  1   // 간선 정보 10개
0 2
0 6
1 3
1 4
1 7
2 4
4 5
6 7
7 8
0	// 쿼리1
1	// 쿼리2
7	// 쿼리3
===================================================
                    출력
===================================================
#1
1 2 3 // 정점0에 인접한 정점리스트
0 1   // 정점2에 인접한 정점리스트
1 3 5 // 정점4에 인접한 정점리스트
#2
1 2 6    // 정점 0에 인접한 정점리스트
0 3 4 7  // 정점 1에 인접한 정점리스트
1 6 8    // 정점 7에 인접한 정점리스트

출처 : SW Expert Reference Code_ Graph
*/
