// 두 배열의 원소 교체
// N 길이를 가진 두개의 배열 선언, K번만큼 배열의 원소를 맞바꾸어 A 원소들의 합이 최대가 되도록

import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer A[] = new Integer[N];
        Integer B[] = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for(int i = 0; i < K; i++){
            if(A[i] < B[i]){
                int temp = A[i];
                A[i] = B[i];
                B[i] = temp;
            }
            else break;
        }

        long result = 0;
        for(int i = 0; i < N; i++){
            result += A[i];
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
