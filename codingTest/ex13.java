// 부품 찾기
// N개의 부품을 정렬하고, M개의 견적을 받아 해당 부품이 있는지 확인
// 이진 탐색 적용

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        int arr2[] = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            int tmp = binarySearch(arr, arr2[i], 0, M-1);
            if(tmp != -1){
                bw.write("yes ");
            }
            else{
                bw.write("no ");
            }
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int binarySearch(int[] array, int target, int start, int end){
        
        while(start <= end){
            int middle = (start + end) / 2;

            if(array[middle] == target)
                return middle;
            else if (array[middle] > target){
                end -= 1;
                continue;
            }
            else{
                start += 1;
                continue;
            }
        }
        return -1;
    }
}
