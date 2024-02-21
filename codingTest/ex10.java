//  위에서 아래로
//  내림차순 정렬 문제
//  모든 수는 1부터 100000 이하이므로 기본 정렬 라이브러리를 사용 

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Integer arr[] = new Integer[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());    
        }

        Arrays.sort(arr, Collections.reverseOrder());
        
        for(int i = 0; i < N; i++){
            bw.write(arr[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
