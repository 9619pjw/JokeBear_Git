import java.util.Scanner;
 
class Main {
 
    static final int MAX_VERTEX = 30;
 
    static int vertex; // 정점
    static int map[][] = new int[MAX_VERTEX][MAX_VERTEX]; // 간선
    static int visit[] = new int[MAX_VERTEX]; // 방문 노드
 
    static void depthFirstSearch(int v)
    {
        visit[v] = 1; // v번째 노드 방문. 1로 바꾸어 방문했음을 표기함
        for (int i = 1; i <= vertex; i++)
        {
            if (map[v][i] == 1 && visit[i] == 0) // 간선이 존재 && 방문한적 없는 노드면 출력
            {
                System.out.printf("%d ", i);
                depthFirstSearch(i);
            }
        }
    }
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt(); // 테스트 케이스 개수 입력
 
        for (int test_case = 1; test_case <= T; test_case++)
        {
            vertex = sc.nextInt(); // 정점의 개수
            int start = sc.nextInt(); // 시작 정점
 
            map = new int[30][30]; 
            visit = new int[30];
             
            while (true)
            {
                int v1 = sc.nextInt(); 
                int v2 = sc.nextInt();// 정점 간 연결관계 입력
                if (v1 == -1 && v2 == -1)
                {
                    break; // 입력 끝
                }
                map[v1][v2] = map[v2][v1] = 1; // 간선개수 1개
            }
            System.out.printf("#%d ", test_case);
            System.out.printf("%d ", start);
            depthFirstSearch(start);
            System.out.printf("\n");
        }
 
        sc.close();
    }
}
