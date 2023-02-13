import java.util.Scanner;
 
class Exercise {
 
    static final int MAX_VERTEX = 30;
 
    static int num;
    static int map[][];
    static int visit[];
    static int queue[];
    static int rear, front; // 맨뒤, 맨 앞
 
    static void breadthFirstSearch(int vertex)
    {
        visit[vertex] = 1; // 방문한 정점 1로 표기
        System.out.print(vertex + " ");
        queue[rear++] = vertex;
        while (front < rear)
        {
            vertex = queue[front++];// 큐의 내용물 정점에 저장
            for (int i = 1; i <= num; i++) // 정점의 개수만큼 반복
            {
                if (map[vertex][i] == 1 && visit[i] == 0) // 경로가 연결되어있고 방문을 안한 정점인 경우
                {
                    visit[i] = 1; // 해당 정점 방문으로 바꿔줌
                    System.out.printf("%d ", i);
                    queue[rear++] = i; // 해당 정점의 값을 큐에 넣어줌
                }
            }
        }
    }
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++)
        {
            map = new int[MAX_VERTEX][MAX_VERTEX];
            visit = new int[MAX_VERTEX];
            queue = new int[MAX_VERTEX];
             
            num = sc.nextInt();
            int start = sc.nextInt();
 
            while (true)
            {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                if (v1 == -1 && v2 == -1) // -1 -1 입력시 종료
                {
                    break;
                }
                map[v1][v2] = map[v2][v1] = 1; // 간선 연결
            }
 
            System.out.printf("#%d ", test_case); // 출력시작
            breadthFirstSearch(start); // BFS
            System.out.printf("\n"); 
        }
         
        sc.close();
    }
}
