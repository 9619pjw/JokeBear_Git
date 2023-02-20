import java.util.Scanner;
 
class Main{
     
    static final int MAX_M = 100;
 
    static int T;     //  # 테스트 케이스 횟수
    static int M;     //  # 배열 크기 M
    static int N;     //  # 찾고자 하는 수의 개수 N
    static int arr[]; //  # 정렬된 숫자 M개 넣을 배열
 
    static void binarySearch(int[] arr, int low, int high, int target)
    {
        int mid;
        if (low > high){ // low 값이 high보다 높으면 유효하지 않은 접근
            System.out.print("-1 ");
            return;
        }
 
        mid = (low + high) / 2; // 중간값
 
        if (target < arr[mid]){ // target이 중간값 보다 작을 경우
            binarySearch(arr, low, mid - 1, target); // low부터 중간값 직전까지 이진탐색 반복
        }
        else if (arr[mid] < target){ // 중간값보다 target이 크면
            binarySearch(arr, mid + 1, high, target); // 중간값+1 부터 high까지 이진탐색 반복
        }
        else{ // 중간값 == target
            System.out.print(mid + " "); // 출력
            return;
        }
    }
 
    public static void main(String arg[]) throws Exception {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) 
        {    
            M = sc.nextInt();// 배열의 크기
            N = sc.nextInt(); // 찾으려는 숫자 개수
 
            arr = new int[M];
            for (int i = 0; i < M; i++)
            {
                arr[i] = sc.nextInt(); // 배열에 숫자 저장
            }

            for (int i = 0; i < N; i++) 
            {
                int targetValue = sc.nextInt(); // 찾으려는 수 입력
                binarySearch(arr, 0, M-1, targetValue); // 이진탐색 시작
            }
            
            System.out.println();
        }
         
        sc.close();
    }
}

/*
=====입력=====
2 // # 테스트 케이스 횟수
12 // # 배열 크기 M
5 // # 찾고자 하는 수의 개수 N
3 7 28 29 43 49 55 58 69 77 79 99 // 정렬된 숫자 M개 배열에 넣기
8 49 58 44 7 // 찾고자 하는 숫자 N개 입력
7 // 배열 크기 M
3 // # 찾고자 하는 수의 개수 N
3 4 5 6 7 8 9  // 정렬된 숫자 M개 배열에 넣기
1 2 3 // 찾고자 하는 숫자 N개 입력 
=====출력=====
-1 5 7 -1 1
-1 -1 0
*/
