// 개미 전사
// 일렬로 늘어진 창고를 털어 최대의 식량을 얻기
// 단, 인접한 창고는 털 수 없음
// 식량 창고의 개수 N (3 <= N <= 100) 
// 식량의 개수(0 <= K <= 1000)

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[100]; // dp테이블 

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){	
			arr[i] = Integer.parseInt(st.nextToken());
		}


		// dp 전개 시작
		dp[0] = arr[0]; // 창고가 하나인 경우
		dp[1] = Math.max(arr[0], arr[1]); // 창고가 두 개인 경우

		for(int i = 2; i < N; i++){
			// 직전의 창고를 털었을 경우 vs 직전의 창고를 안털고 현재 창고를 털었을 경우
			dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
		}

		System.out.println(dp[N-1]);
        br.close();
    }
}
