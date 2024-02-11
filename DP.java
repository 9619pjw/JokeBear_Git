/*
문제)
N개의 숫자 쌍이 주어진다. 숫자 쌍은 두 개의 숫자로 이루어져 있으며, 
첫 번째 숫자를 x라고 하고, 두 번째 숫자를 y라고 했을 때 (x, y)로 표현할 수 있다. 
이때 x는 1 또는 2로만 주어지고 y값은 1부터 100이하의 정수만 주어진다. 
N개의 숫자 쌍의 일부를 선택하여 x값들의 합을 Sx라고 하고, 
선택되지 않은 나머지 숫자 쌍들의 y값들의 합을 Sy라고 할때,
Sx ≥ Sy 를 만족해야 한다.

<< 예시 >> 
N이 5인 숫자 쌍이 (x0, y0), (x1, y1), (x2, y2), (x3, y3), (x4, y4) 와 같이 주어진 경우 
0, 2, 4번째 숫자 쌍을 선택했을 경우 x0+x2+x4 ≥ y1+y3 가 성립되어야 한다. 

주어진 N개의 숫자 쌍 중, 위의 규칙에 맞게 숫자 쌍을 선택하는 방법 중, 
선택된 숫자 쌍의 x의 합이 최소가 되는 경우를 찾고, 이 경우의 x의 합을 구하라.

조건 1) N은 1이상 1,000 이하의 정수. (1 ≤ N ≤ 1,000)
조건 2) 숫자 쌍 (x, y) 의 x, y 는 각각 1 ≤ x ≤ 2와 1 ≤ y ≤ 100를 만족하는 정수
===================================================
                    입력                           
===================================================
2   // 테스트 케이스 작성
5   // N개의 숫자 쌍
1 12 // x와 y 입력
1 3
2 15
2 5
2 1
5   // N개의 숫자 쌍
1 12
1 13
2 15
2 17
2 10
===================================================
                    출력
===================================================
#1 5    // 선택된 숫자 쌍의 x들의 합 (1+2+2) 
#2 8    // 선택된 숫자 쌍의 x들의 합 (1+1+2+2+2)

출처 : SW Expert Reference Code_ Dynamic_Programming
*/

import java.util.Scanner;

class Exercise {
    static final int MAX_X = 2;    // x의 최댓값
    static final int MAX_N = 1001; // 숫자쌍의 최대 개수

    static int N; // 숫자 쌍의 개수
    static int num_pair[][] = new int[MAX_N][2];    // 숫자쌍
    static int dp[][] = new int[MAX_N][MAX_X * MAX_N]; // DP 테이블

    static int max(int a, int b){
        return (a > b) ? a : b; 
    }

    static int solve() {
        int ans = 0;    // 결과값을 저장할 변수 

        // DP 테이블 생성 (테이블 크기 1001 X 2002)
        for (int i = 0; i < MAX_N; i++){
            for (int j = 0; j < MAX_X * MAX_N; j++){
                dp[i][j] = 0;   
            }
        }

        // 숫자쌍의 개수만큼 반복 
        for (int i = 0; i < N; i++){
            ans += num_pair[i][0];  // x값들의 합을 계산하여 ans 변수에 저장함
        }

        // DP 테이블의 초기값 설정 (초기값 = -1)
        for (int i = 0; i < N; i++) { // 입력받은 숫자쌍의 개수만큼
            for (int j = 0; j < ans; j++) { // x값들의 합만큼 반복하여 초기값 설정
                dp[i][j] = -1;
            }
        }

        // 첫 번째 숫자쌍을 선택하지 않은 경우 초기값 설정 ... 선택된 숫자쌍의 x값들의 합이 0인 경우
        dp[0][ans] = 0; 
        // 첫 번째 숫자쌍을 선택한 경우 초기값 설정 ... 첫번째 숫자쌍의 y값을 빼고 x값을 더해준 것.
        dp[0][ans - num_pair[0][0] + num_pair[0][1]] = num_pair[0][0];

        // 동적 계획법 실행
        for (int i = 1; i < N; i++) {
            int sum = num_pair[i][0] + num_pair[i][1];
            for (int j = 0; j <= ans; j++) {
                if (dp[i - 1][j] != -1) {
                    int diff = j - sum;
                    if (diff >= 0) {
                        dp[i][diff] = max(dp[i][diff], dp[i - 1][j] + num_pair[i][0]);
                    }
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // 결과값 계산
        int max_value = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= ans; j++) {
                max_value = max(max_value, dp[i][j]);
            }
        }
        return ans - max_value;

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T; 
        T = sc.nextInt(); // 테스트 케이스 입력
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt(); // 숫자 쌍의 개수 입력

            for (int i = 0; i < N; i++) {
                num_pair[i][0] = sc.nextInt(); // x 입력
                num_pair[i][1] = sc.nextInt(); // y 입력
            }
            System.out.println("#" + test_case + " " + solve()); // DP 결과 출력
        }
        sc.close();
    }
}
