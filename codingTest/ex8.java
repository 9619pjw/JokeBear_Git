// 음료수 얼려먹기
// DFS 문제. N X M 크기의 얼음틀에서 구멍이 뚫린 부분 0, 칸막이 부분 1로 표시.
// 구멍이 뚫려있는 부분끼리 상하좌우로 붙어있는 경우 서로 연결된거로 간주
// 얼음틀의 모양이 주어졌을 때 생성되는 아이스크림의 총 개수

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int arr[][] = new int[1000][1000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로 = N, 가로 = M
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        // 생성 가능한 아이스크림 개수
        int result = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(dfs(i,j)){
                    result++;
                }
            }
        }
        System.out.println(result);
        br.close();
    }
    public static boolean dfs(int x, int y){
        // 범위를 벗어날 경우 종료
        if (x <= -1 || x >= N || y <= -1 || y >= M) {
            return false;
        }
        // 미방문 노드일 경우 방문 표시 후 상하좌우 재귀호출
        if(arr[x][y] == 0){
            arr[x][y] = 1;
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
            return true;
        }
        return false;
    }
}
