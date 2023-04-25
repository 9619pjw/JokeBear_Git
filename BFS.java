/*
BFS 너비 우선 탐색
맹목적인 탐색 방법의 하나로, 시작 정점을 방문한 후 
시작 정점에 인접한 모든 정점들을 우선 방문하는 방법
큐를 이용하여 구현한다.

문제) 숫자가 있는 원은 정점(vertex)라고 하고,
정점과 정점을 잇는 연결선을 간선(Edge)라고 한다.
정점의 최대 개수는 30개이다.
정점과 정점의 연결 관계가 인접행렬로 주어졌을 때,
BFS를 이용하여 시작 정점으로부터 모든 정점을 탐색한
결과를 순서대로 화면에 출력하시오.

===================================================
                    입력                           
===================================================
1 // test case 개수                                
8 1 // 정점의 개수, 시작 정점  
1 2 // 정점 간 연결 관계                                     
1 3 
2 4
2 5
4 8
5 8
3 6
3 7
6 8
7 8
-1 -1// 입력 끝
===================================================
                    출력
===================================================
#1 1 2 3 4 5 6 7 8 // 방문한 정점 순서

출처 : SW Expert Reference Code_ BFS_Searching
*/


import java.util.Scanner;
 
class Exercise {
 
    static final int MAX_VERTEX = 30;
 
    static int num; // 정점의 개수
    static int map[][]; // 그래프
    static int visit[]; // 방문 여부
    static int queue[]; // 너비 우선 탐색을 위한 큐 성생성
    static int rear, front; // 맨뒤, 맨 앞
 
    static void breadthFirstSearch(int vertex){
        visit[vertex] = 1; // 방문한 정점 1로 표기
        System.out.print(vertex + " ");
        queue[rear++] = vertex; // 큐에 해당 정점 저장
        while (front < rear) {
            vertex = queue[front++];// 큐의 내용물 정점에 저장
            for (int i = 1; i <= num; i++) { // 정점의 개수만큼 반복
                if (map[vertex][i] == 1 && visit[i] == 0) { // 경로가 연결되어있지만 방문을 안한 정점인 경우
                    visit[i] = 1; // 해당 정점 방문으로 바꿔줌
                    System.out.printf("%d ", i); // 출력
                    queue[rear++] = i; // 해당 정점의 값을 큐에 넣어줌
                }
            }
        }
    }
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt(); // 테스트 케이스 입력
 
        for (int test_case = 1; test_case <= T; test_case++){
            map = new int[MAX_VERTEX][MAX_VERTEX];
            visit = new int[MAX_VERTEX];
            queue = new int[MAX_VERTEX];
             
            num = sc.nextInt(); // 정점의 개수 입력
            int start = sc.nextInt(); // 시작 정점 입력
 
            while (true) {
                int v1 = sc.nextInt(); // 정점 간 연결 관계 입력
                int v2 = sc.nextInt();
                if (v1 == -1 && v2 == -1) { // -1 -1 입력시 종료
                    break;
                }
                map[v1][v2] = map[v2][v1] = 1; // 간선 연결
            }
 
            System.out.printf("#%d ", test_case); // 출력시작
            breadthFirstSearch(start); // BFS 탐색 
            System.out.printf("\n"); 
        }
        sc.close();
    }
}
