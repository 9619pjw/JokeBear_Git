// 큰 수의 법칙 ... 주어진 수들을 M번 더하여 가장 큰 수를 만들기
// 배열의 특정한 인덱스에 해당하는 수가 연속해서 K번 초과해서 더할수는 없음
// 배열의 크기 N, 숫자가 더해지는 횟수 M, 연속제한 횟수 K
import java.util.*;
import java.io.*;

class Exercise {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        
        // 배열의 수 저장
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int first = arr[N-1];
        int second = arr[N-2];

    
        // 가장 큰 수를 더할 횟수
        int cnt = (M / (K+1)) * K;
        cnt += M % (K+1);

        // 결괏값 저장
        int result = 0;
        result += cnt * first;
        result += (M - cnt) * second;
        
        System.out.println(result);
        br.close();
    }
}
