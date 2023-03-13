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

void printStack(){
    printf("STACK_SIZE [%d]\n", (STACK_SIZE * size));  // 스택 사이즈 출력
    printf("\n STACK [");
    for(int i = 0; i <= top; i++)
        printf("%d ", stack[i]);// 스택의 각 요소 출력
    printf("]\n");
}

void main(void){
    
    stack = (int*)malloc(STACK_SIZE * sizeof(int)); // 메모리 할당
    for(int i = 0; i < 44; i++){
        push(i+1); // 1부터 44까지 push 연산
    }
    printStack(); // 스택 출력
    for(int i = 0; i < 7; i++)// 상위 7개 요소 pop 연산 
        printf("pop data [%d]\n", pop());
    printStack();
    free(stack); // stack 메모리 반환
    getchar(); // ?
}
