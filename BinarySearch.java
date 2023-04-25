/*
Binary Search 이진 탐색
오름차순으로 정렬된 리스트에서 특정한 값의 위치를 찾는 알고리즘
처음 중간의 값을 임의의 값으로 선택하여, 그 값과 찾고자 하는 값의
크고 작음을 비교하는 방식을 채택하고 있다.
처음 선택한 중앙값이 찾는 값보다 크면
그 값은 새로운 최고값이 되며, 작으면 그 값은 새로운 최하값이 된다.


예시 문제) 
정렬된 정수배열에서 Binary Search를 이용하여 제시된 숫자들을 찾아라.
있으면 해당 인덱스를 출력하고 없으면 -1을 출력하라
(2 <= M <= 100)

===================================================
                    입력                           
===================================================
2 // # 테스트 케이스 횟수
12 // # 배열 크기 M
5 // # 찾고자 하는 수의 개수 N
3 7 28 29 43 49 55 58 69 77 79 99 // 정렬된 숫자 M개 배열에 넣기
8 49 58 44 7 // 찾고자 하는 숫자 N개 입력
7 // 배열 크기 M
3 // # 찾고자 하는 수의 개수 N
3 4 5 6 7 8 9  // 정렬된 숫자 M개 배열에 넣기
1 2 3 // 찾고자 하는 숫자 N개 입력 
===================================================
                    출력
===================================================
#1 -1 5 7 -1 1
#2 -1 -1 0
출처 : SW Expert Reference Code_ Binary_Search
*/

import java.util.Scanner;
 
class Main{
     
    static final int MAX_M = 100;
 
    static int T;     //  # 테스트 케이스 횟수
    static int M;     //  # 배열 크기 M
    static int N;     //  # 찾고자 하는 수의 개수 N
    static int arr[]; //  # 정렬된 숫자 M개 넣을 배열
 
    static void binarySearch(int[] arr, int low, int high, int target) {
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
 
        for (int test_case = 1; test_case <= T; test_case++) {    
            M = sc.nextInt();// 배열의 크기
            N = sc.nextInt(); // 찾으려는 숫자 개수
 
            arr = new int[M];
            for (int i = 0; i < M; i++) {
                arr[i] = sc.nextInt(); // 배열에 숫자 저장
            }

            for (int i = 0; i < N; i++) {
                int targetValue = sc.nextInt(); // 찾으려는 수 입력
                binarySearch(arr, 0, M-1, targetValue); // 이진탐색 시작
            }
            
            System.out.println();
        }
         
        sc.close();
    }
}
