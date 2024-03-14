// 미래 도시
// 회사의 개수 N, 경로의 개수 M (1 <= N,M <= 100)
// 2번째 줄부터 M+1번까지 연결된 회사의 번호 입력
// M+2번째 줄에는 X와 K가 공백으로 구분되어 입력 ( 1 <= K <= 100 )


import java.util.*;
import java.io.*;

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값
    
    public static int N, M; // 노드의 개수(N), 간선의 개수(M)
    public static int X, K; // K를 방문하여 X로 도달
    public static int[][] graph = new int[101][101];
    public static int distance = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 초기화
        for(int i = 0; i < 101; i++){
            Arrays.fill(graph[i], INF);
        }

        // 자신에게 가는 비용은 0
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if( i == j ) graph[i][j] = 0;
            }
        }

        // 각 간선의 정보를 입력받음
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 점화식에 따라 플로이드 워셜 알고리즘 수행
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                for(int k = 1; k <= N; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int distance = graph[1][K] + graph[K][X];

        if(distance >= INF)
            System.out.println(-1);
        else    
            System.out.println(distance);
        br.close();
    }
}
