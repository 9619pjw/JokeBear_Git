/*
우선순위 큐 (Priority Queue)
높은 우선순위를 가진 원소는 낮은 우선순위를 가진 원소보다 먼저 처리되는 자료구조


문제)
주어진 N(2 <= N <= 100)개의 수를 작은 숫자가 높은 우선순위를 갖는
Priority Queue에 저장하고, 우선순위가 높은 숫자부터 차례로 출력하시오.
이때, @최소 힙을 이용하여 구현한다.

@ 최소 힙
완전 이진 트리 ... 단말 노드를 제외한 나머지 노드가 두 개의 자식 노드를 가지고 있는 트리
부모 노드의 값이 왼쪽 자식과 오른쪽 자식노드의 값보다 작게 트리를 구성하여 
루트 노드는 입력된 값들 중 가장 작은 값이 저장되어 있음.
키 값이 작을수록 높은 우선순위를 지님.
===================================================
                    입력                           
===================================================
2 // test case 개수                                
10 // 입력 수  
10 49 38 17 56 92 8 1 13 55 // 입력 데이터                                     
13 // 입력 수                 
4 22 50 13 5 1 22 35 21 7 99 100 14 // 입력 데이터
===================================================
                    출력
===================================================
#1 1 8 10 13 17 38 49 55 56 92
#2 1 4 5 7 13 14 21 22 22 35 50 99 100
출처 : SW Expert Reference Code_ Priority_Queue
*/

import java.util.Scanner;

class Exercise{
    static Scanner sc;
    static final int MAX_SIZE = 100;
    static int heap[] = new int[MAX_SIZE];
    static int heapSize = 0;

    static void heapInit(){ // heap 초기화
        heapSize = 0;
    }
    // push 연산  ← 힙의 마지막 노드 바로 다음 원소에 저장, 루트노드 방향으로 올라가며 스왑 
    static void heapPush(int value){ 
        if (heapSize + 1 > MAX_SIZE){ // heap이 가득찼을 경우 함수종료
            return;
        }
        heap[heapSize] = value; // 들어온 새 값 push .. 우선순위가 낮다고 가정하여 맨 끝에 저장함
        int current = heapSize;
        while (current > 0 && heap[current] < heap[(current - 1) / 2]){ // 최소 힙 조건을 만족하지 않는 경우,
            int temp = heap[(current - 1) / 2]; // 자식노드와 부모 노드의 변경
            heap[(current - 1) / 2] = heap[current];
            heap[current] = temp; 
            current = (current - 1) / 2; // 노드의 위치를 변경하여 최소 힙 조건을 만족함
        }
        heapSize = heapSize + 1; // 힙의 크기 증가
    }
    // pop 연산 ← 루트노드 삭제, 마지막 노드를 루트로 옮기고 작은 자식들과 비교하여 스왑
    static int heapPop(){ 
        if (heapSize <= 0){ // heap 크기가 0인 경우 예외 처리
            return -1;
        }
        int value = heap[0];    // 가장 우선순위가 높은 데이터 value에 저장
        heapSize = heapSize - 1; // 힙의 크기 감소
        heap[0] = heap[heapSize]; // 마지막 노드를 루트 노드 자리로 옮김
        int current = 0;
        while (current < heapSize && current * 2 + 1 < heapSize){ // 최소 힙 조건을 만족하지 못하는 경우
            int child;
            if (current * 2 + 2 >= heapSize){ // 오른쪽 자식 노드가 없을 경우
                child = current * 2 + 1; // 왼쪽 자식 노드 선택함
            }else{ // 오른쪽 자식 노드가 있을 경우 두 자식 노드 중 작은 값을 선택함
                child = heap[current * 2 + 1] < heap[current * 2 + 2] ? current * 2 + 1 : current * 2 + 2;
            }

            if (heap[current] < heap[child]){ // 최소 힙 조건을 만족하는 경우 반복문 종료
                break;
            }

            int temp = heap[current]; 
            heap[current] = heap[child];
            heap[child] = temp; // 노드의 위치를 변경하여 최소 힙 조건을 만시킴

            current = child;
        }
        return value;
    }
    static void heapPrint(int[] heap, int heap_size){
        for (int i = 0; i < heap_size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String arg[]) throws Exception {
        sc = new Scanner(System.in);
        int T = sc.nextInt(); // Test 케이스 입력
        for (int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();   // 데이터의 개수 입력
            heapInit(); // heap 초기화
            for (int i = 0; i < N; i++){
                int value = sc.nextInt(); // 데이터 입력하여 heap에 삽입
                heapPush(value);
            }

            System.out.print("#" + test_case + " ");            
            for (int i = 0; i < N; i++){
                System.out.print(heapPop() + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
