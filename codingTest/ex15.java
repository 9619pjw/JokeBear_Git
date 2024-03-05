// 1로 만들기
// N가 5로 나누어떨어지면 5로 나눔, 3로 나누어떨어지면 3로 나눔, 2로 나누어떨어지면 2로 나눔
// N에서 1을 뺀다.
// 연산 4개를 최대한 적게 사용해서 1로 만들기
import java.util.*;
import java.io.*;

class Main{
	public static int[] dp = new int[30001];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int N = Integer.parseInt(br.readLine());
		
		    // 다이나믹 프로그래밍(Dynamic Programming)
		    for(int i = 2; i <= N; i++){
			    // 현재의 수에서 1을 빼는 경우
			    dp[i] = dp[i-1] + 1;
		
			    // 현재의 수가 2로 나누어 떨어지는 경우
			    if(i % 2 == 0)
				    dp[i] = Math.min(dp[i], dp[i/2] + 1);
			
			    // 현재의 수가 3로 나누어 떨어지는 경우
			    if(i % 3 == 0)
			  	  dp[i] = Math.min(dp[i], dp[i / 3] + 1);

			    // 현재의 수가 5로 나누어 떨어지는 경우
			    if(i % 5 == 0)
				    dp[i] = Math.min(dp[i], dp[i / 5] + 1);	
		    }
		    
        System.out.println(dp[N]);
        br.close();
    }
}
