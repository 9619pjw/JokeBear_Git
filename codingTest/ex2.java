// 숫자 카드 게임
// N * M 카드를 놓음
// 각 행의 최솟값을 모아, 어떤 행의 최솟값이 가장 큰지 테스트
import java.util.*;
import java.io.*;

public class ex2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;

        for(int i = 0; i < N; i++){
            // 현재 줄에서 가장 작은 수 찾기
            int min_value = 10001;
            st= new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int x = Integer.parseInt(st.nextToken());
                min_value = Math.min(min_value, x);
            }
            // 가장 작은 수들 중 가장 큰 수 찾기
            result = Math.max(result, min_value);
        }
        System.out.println(result);
        br.close();
    }
}
