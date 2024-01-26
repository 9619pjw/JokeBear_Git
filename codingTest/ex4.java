// 상하좌우
// N * N 크기의 정사각형 지도에서 입력받은 이동방향에 따라 이동 후 현재 위치를 출력
// 현재 위치(1,1)

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = 1, y = 1; // 초기 좌표

        int N = Integer.parseInt(br.readLine());
        String s[] = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < s.length; i++){
            s[i] = st.nextToken();
        }
        // L, R, U, D에 따른 이동 방향
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};
        char move[] = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for(int i = 0; i < s.length; i++){
            char plan = s[i].charAt(0);
            int nx = -1, ny = -1;
            for(int j = 0; j < 4; j++){
                if(plan == move[j]){
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시함.
            if(nx < 1 || ny < 1 || nx > N || ny > N ) continue;

            // 이동 수행
            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);
        br.close();
    }
}
