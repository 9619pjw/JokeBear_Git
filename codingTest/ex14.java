// 떡볶이 떡 만들기
// 떡의 개수 N(1 ~ 1,000,000) 요청한 떡의 길이 M (1 ~ 2,000,000,000)
// arr[] ... 떡의 길이 주어짐
// 요청한 떡의 길이가 M일 때, 적어도 M만큼의 떡을 얻기위해 절단해야할 최댓값은?
// 절단해야할 길이는 10억보다 작음 => 탐색 범위가 크면 이진 탐색을 떠올리기

import java.util.*;
import java.io.*;

class Main{ 
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 이진 탐색을 위한 시작점과 끝점
        int start = 0;
        int end = arr[N-1];
        
        // 이진 탐색 수행
        int result = 0;
        while(start <= end){
            long total = 0;
            int mid = (start + end) / 2;
            
            for(int i = 0; i < N; i++){
                if(arr[i] > mid) 
                    total += arr[i] - mid;
            }

            if (total < M) 
                end = mid - 1;
            else{
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
        br.close();
    }
}
