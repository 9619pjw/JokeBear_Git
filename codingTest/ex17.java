// 바닥 공사
// 가로 N 세로 2의 직사각형 바닥을 1X2, 2X1, 2X2 타일을 이용하여 바닥을 덮는 모든 경우의 수를 구함
// 1 <= N <= 1000 , 출력은 796796으로 나눈 나머지를 출력함

import java.util.*;
import java.io.*;

class Main{
	static int dp[] = new int[1001];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp[1] = 1;
		dp[2] = 3;

		for(int i = 3; i < N + 1; i++){
			// i-1번째까지 채워졌을 경우, 1X2 타일만 사용하면 되므로 1개의 선택지가 있음.
      // i-2번째까지 채워졌을 경우, 1X2 타일 두개로 덮기, 2X2 타일로 덮기를 사용할 수 있으므로 2개의 선택지가 있음
      // dp[i] == dp[i-1] +  2*dp[i-2]
			dp[i] = (dp[i-1] + 2 * dp[i-2]) % 796796;
		}

		System.out.println(dp[N]);
        br.close();
    }
}
