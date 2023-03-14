#include <stdio.h>
#include <stdlib.h>

#define STACK_SIZE 10

int *stack;
int top = -1;
int size = 1;

int isEmpty(){ // 스택이 비었는지 확인함
   if (top == -1)
        return 1;
    else
        return 0;
}


int isFull(){    // 스택이 꽉 찼는지 확인함
     if(top % STACK_SIZE == STACK_SIZE -1)
        return 1;
    else 
        return 0;
}

void push(int item){ // push 연산
    int *temp;
    if(isFull()){    // 스택이 가득 찼을 경우 <- 크기 +1 인 스택을 생성해야함
	  printf("Full Stack ");
        temp = (int*)malloc((STACK_SIZE * size)*sizeof(int));  // STACK_SIZE * size 만큼의 임시배열 할당
        for(int i = 0; i < top+1; i++)
            temp[i] = stack[i]; // 현재 스택값을 임시 배열로 복사  
        stack = (int*)malloc((STACK_SIZE * (size + 1))*sizeof(int));//STACK_SIZE * (size + 1) 만큼의 새 스택 할당
        for(int i = 0; i <= top; i++)
            stack[i] = temp[i]; // 임시 배열에 복사된 값을 새로 생성된 스택으로 다시 옮김
        stack[++top] = item; // 새로 생성된 스택의 맨 위에 item 추가 
        size++;               // 스택 사이즈 증가
        free(temp);            // temp에 할당된 메모리 반환
    }
    else{ // 스택이 가득 안찼을 경우
        stack[++top] = item;// 스택의 맨 위에 item 추가
    }
}

void insert(int item, int pos) { // 삽입할 데이터 item, 삽입할 데이터의 위치 pos 입력받음
    if (isFull()) { // 스택이 가득 차 있을 경우
        int *temp = (int*) malloc((STACK_SIZE * size) * sizeof(int)); // 임시 배열 temp 생성
        for (int i = 0; i <= top; i++) {
            temp[i] = stack[i];	// 기존 스택에 저장되어 있는 값들 temp에 저장
        }
        size++;	// 사이즈 1 증가시켜줌
        stack = (int*) malloc((STACK_SIZE * size) * sizeof(int)); // 새로운 스택 동적할당함
        for (int i = 0; i < pos; i++) {
            stack[i] = temp[i];	// 처음부터 pos 이전까지 temp에 저장되어 있던 값들 새로운 스택에 저장 
        }
        stack[pos] = item;	//  pos위치에 삽입할 데이터 item 넣음
        for (int i = pos + 1; i <= top + 1; i++) {
            stack[i] = temp[i - 1];	// pos 이후부터 끝까지 temp에 저장되어 있던 값들 새로운 스택에 저장
        }
        free(temp);	// 임시 배열에 할당된 메모리 반환
    } else {	// 스택이 가득 안찼을 경우
        for (int i = top + 1; i > pos; i--) { // 맨 위에서부터 삽입할 데이터의 위치 전까지
            stack[i] = stack[i - 1]; // 기존 스택에 있던 값들 한칸씩 미뤄줌
        }
        stack[pos] = item; // pos 위치에 삽입할 데이터 item 넣음
        top++;	// 값이 하나 추가되었으므로 top 갱신해줌
    }
}

int pop(){
    int data; 
    if(isEmpty()){
        printf("Stack Empty!");
        return -1;
    }
    else{
        data = stack[top]; // 스택 맨 위의 값을 저장
        top--;             // pop연산이므로 최상단 요소를 줄여서 없앰
        return data;       // data 반환
    }
}

void printStack() {
    printf("STACK_SIZE [%d]\n", STACK_SIZE * size);	// 스택 사이즈 출력
    printf("\n STACK [");
    for (int i = 0; i <= top; i++) {
        printf("%d ", stack[i]);	// 스택의 각 요소 출력
    }
    printf("]\n");
}

void main(void) {
    stack = (int*) malloc(STACK_SIZE * sizeof(int)); // 메모리 할당
    for (int i = 0; i < 44; i++) {
        push(i + 1); // 1부터 44까지 push 연산
    }
    printStack(); // 스택 출력
    for (int i = 0; i < 7; i++) {	// 상위 7개의 요소 pop 연산
        printf("pop data [%d]\n", pop());
    }
    printStack();
    insert(84, 20); // 20번째 위치에 84 삽입
    printStack();
    free(stack);	// stack에 할당된 동적 메모리 반환 
}
