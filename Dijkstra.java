
/*
다익스트라 알고리즘 (Dijkstra Algorithm)
어떤 변도 음수 가중치를 갖지 않는 유향 그래프에서 
주어진 출발점과 도착점 사이의 최단 경로 문제를 푸는 알고리즘

예제)
방향이 있는 그래프에서 꼭지점들을 연결하는 비용이 할당 되었을 때 
임의의 꼭지점에서 다른 꼭지점으로 가는 경로들 중에서 
비용이 가장 적게 드는 경로(=두 정점 사이의 최단 경로)를 찾아라. 
첫번째 라인에는 전체 테스트 케이스의 개수가 입력된다. 
두번째 라인에는 정점의 개수, 그리고 시작 정점, 도착 정점이 입력된다. 
(정점의 최대 개수는 100) 
세번째 라인에는 정점을 잇는 간선 개수(m)가 입력된다. 
네번째 라인부터는 연결 된 정점 값 2개와 간선에 할당 된 비용이 m번 들어온다. 
(간선 방향은 첫번째 입력된 정점에서 두번째 입력된 정점으로 가는 방향)

===================================================
                    입력                           
===================================================
1 // test case 개수                                
7 1 7 // 정점의 개수, 그리고 시작 정점, 도착 정점   
9 // 간선 개수                                     
1 2 4 // 1->2, 비용은 4                    
1 3 2
2 4 1
2 5 2
3 4 7
3 6 3
4 7 3
5 7 1
6 7 5
===================================================
                    출력
===================================================
#1 7

출처 : SW Expert Reference Code_ Dijkstra
*/


import java.util.Scanner;
 
class Solution{
    static final int N = 100;       // 정점의 최대 개수
    static final int INF = 100000;  // 비용 초기화값
    static int[][] map = new int[N+1][N+1];  // 연결된 맵
    static boolean[] visit = new boolean[N+1]; // 방문 여부
    static int[] dist = new int[N+1];       // 거리
    static int vertex;      // 정점
    static int edge;        // 간선
    static int start;       // 시작 정점
    static int end;         // 도착 정점
    public static void dijkstra(){
        int v = 0;
        dist[start] = 0;
        for (int i = 1; i <= vertex; i++){
            int min = INF;
            for (int j = 1; j <= vertex; j++){  
                if (visit[j] == false && min > dist[j]){  // 방문 안한 점 & 거리가 min보다 작을 경우
                    min = dist[j]; // min값 업데이트
                    v = j;  // 해당 정점의 값을 v에 업데이트
                }
            }
 
            visit[v] = true;    // 방문 표시해줌
 
            for (int j = 1; j <= vertex; j++){
                if (dist[j] > dist[v] + map[v][j]){
                    dist[j] = dist[v] + map[v][j];  // 최단 거리 업데이트
                }
            }
        }
    }

    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();       // 테스트 케이스 개수
        for (int test_case = 1; test_case <= T; test_case++){
            vertex = sc.nextInt();  // 정점의 개수
            start = sc.nextInt();   // 시작 정점
            end = sc.nextInt();     // 도착 정점
            edge = sc.nextInt();    // 간선의 개수
            for (int i = 1; i <= vertex; i++){  // 비용을 100000로 초기화
                for (int j = 1; j <= vertex; j++){
                    if (i != j){
                        map[i][j] = INF;
                    }
                }
            }

            for (int i = 1; i <= edge; i++) {   // 간선의 개수만큼 반복
                int from = sc.nextInt();    // 시작 정점
                int to = sc.nextInt();      // 도착 정점
                int value = sc.nextInt();   // 비용 입력
                map[from][to] = value;      // 해당 간선의 비용을 조정
            }

            for (int i = 1; i <= vertex; i++){ // 거리와 방문 여부 초기화
                dist[i] = INF;
                visit[i] = false;
            }
            dijkstra(); // 다익스트라 탐색 시작
            System.out.printf("#%d %d\n", test_case, dist[end]);
        }
        sc.close();
    }
}
