// 효율적인 화폐 구성
// N 가지 종류 화폐를 최소한의 개수로 이용해서 M원을 만들기. 불가능한 경우, -1을 출력
//  1 <= N <= 100 , 1 <= M <= 10000

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // dp 테이블 정의 및 10001로 초기화
        int dp[] = new int[M+1];
        Arrays.fill(dp,10001);

        dp[0] = 0;
        for(int i = 0; i < N; i++){
            for(int j = arr[i]; j <= M; j++){
                // i - k원을 만드는 방법이 존재하는 경우
                if(dp[j - arr[i]] != 10001)
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        // M원을 만드는 방법이 없는 경우 -1 출력
        if(dp[M] == 10001)
            System.out.println(-1);
        else    
            System.out.println(dp[M]);
        br.close();
    }
}
