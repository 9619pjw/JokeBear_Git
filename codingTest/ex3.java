/**
* N이 1이 될 때까지 두 연산 중 하나를 반복적으로 선택하여 수행
* - N에서 1을 뺀다
* - N을 K로 나눈다 (나누어 떨어질 때만 가능)
* 1이 될 때까지 수행하는 최소의 연산횟수를 구하시오.
*/


import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;

        while(true){
           // N이 K로 나누어떨어지는 수가 될때까지 1씩 빼기
            int target = (N / K) * K;
            cnt += (N - target);
            N = target;
            // N이 K보다 작을 때 반복문 탈출
            if (N < K) break;
            cnt += 1;
            N /= K;
        }
        // 마지막으로 남은 수에 대해 1씩 뺴기
        cnt += (N -1);
        System.out.println(cnt);
        br.close();
    }
}
