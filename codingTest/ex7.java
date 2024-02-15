// 게임 개발
// 시뮬레이션 문제. N X M 크기의 맵에서 캐릭터가 방문한 칸 수를 출력하는 프로그램

import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, x, y, direction;
    // 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
    public static int[][] d = new int[50][50];
    // 전체 맵 정보
    public static int[][] arr = new int [50][50];

    // 북 동 남 서
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    // 왼쪽으로 회전
    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 맵 크기 설정
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 현재 캐릭터의 방문 좌표, 방향 입력
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());
        d[x][y] = 1; // 현재 좌표 방문 처리

        // 맵의 정보를 입력받기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시뮬레이션 시작
        int cnt = 1; // 방문한 칸의 개수
        int turn_time = 0; // 회전 횟수를 담음.
        while(true){
            // 왼쪽으로 회전
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];
          
            // 회전 이후 정면에 가보지 않은 칸이 존재하면 이동
            if(d[nx][ny] == 0 && arr[nx][ny] == 0){
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt += 1;
                turn_time = 0;
                continue;
            }
            // 회전 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
            else turn_time += 1;
          
            // 네 방향 모두 갈 수 없는 경우
            if(turn_time == 4){
                nx = x - dx[direction];
                ny = y - dy[direction];
                // 뒤로 갈 수 있으면 이동
                if(arr[nx][ny] == 0){
                    x = nx;
                    y = ny;
                }
                // 뒤가 바다로 막혀있는 경우
                else break;
                turn_time = 0;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
