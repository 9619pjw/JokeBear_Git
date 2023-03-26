/*
* 연결리스트로 구현한 합집합
*  UnionSet_LinkedList
*/
#include <stdio.h>
struct node			
{
	node* head;		
	node* next;
	char name;	 // 집합연산에 사용될 연결리스트 생성. 원소값은 문자형태로 받는다.
};

struct set			
{	
	int setldx;		// setidx에 집합의 인덱스가, 
	int totalElementNum;	// totalelementNum이 총 원소의 개수를 저장
	node* tail;	 // 이 위치에 새로운 원소를 추가한다.
};

node Node[27];
set Set[27];
int totalNode = 0;		// 총 노드의 개수
int totalSet = 0;			// 총 집합의 개수

void printSet(int set)		// 집합을 출력하는 메소드
{
	node* start = Set[set].tail->head;		// 시작점을 tail이 가리킴
	printf("*** printSet %d: ", set);							
	for (int i = 0; i < Set[set].totalElementNum; i++)
	{
		printf("%c ", start->name);	// 원소의 개수만큼 증가시키며 출력함
		start = start->next;		// 다음 노드로 이동
	}
	printf("\n");
}

void makeSet(char element)
// 집합을 만드는 연산. 인수로 전달받은 element으로 이루어진 집합을 만든다.
{
	Node[totalNode].name = element;
	Node[totalNode].head = &Node[totalNode];	//대표원소는 대표원소 자신을 가리킨다.
	Node[totalNode].next = &Node[totalNode]; 
					//이후 추가된 원소 또한 대표원소를 가리킨다.
	Set[totalSet].setldx = totalSet;	// 해당 집합에 인덱스 기입한다.
	Set[totalSet].totalElementNum = 1;	 
			//단일 원소를 추가하였으므로 totalElementNum은 1이 된다.
	Set[totalSet].tail = &Node[totalNode];  // tail은 대표원소를 가리킨다.
	printSet(totalSet);	// 해당 집합이 생성되었음을 출력하여 보여준다.
	totalNode++;	       // 위의 함수가 실행 시 총 노드의 개수가 1 증가한다.
	totalSet++;	      // 위의 함수가 실행 시 총 집합의 개수가 1 증가한다.
}

int findSet(char element)	    // 해당 원소를 지니는 집합을 찾는 연산
{
	for (int i = 0; i < totalSet; i++)						
	{// set별로 찾기
		node* start = Set[i].tail->head; // tail이 가리키는 곳이 탐색의 시작점
		while (1)
		{
			if (start->name == element) 
				// 시작점에서 해당 원소를 발견 시 실행
			{
				printf("Found! Set : %d\n", i);
				printSet(i);
				return i;
			}
			start = start->next;	// 탐색의 시작점 위치를 옮김
			if (start == Set[i].tail)
				// 탐색을 시작점과 tail이 같으면 탐색을 중단한다.
				break;
		}
	}
	return -1;
}

void unionSet(char element, char element2)	// 원소 element1을 지닌 집합과 원소 element2을 지닌 집합의 합집합 연산
{
	int set1 = findSet(element);
	int set2 = findSet(element2);
	if (Set[set1].totalElementNum < Set[set2].totalElementNum) // set2이 set1보다 큰 경우 set1을 set2 뒤에 붙임
	{
		Set[set2].totalElementNum += Set[set1].totalElementNum;		// set2의 총 원소 개수에 set1의 총 원소 개수 더함
		Set[set2].tail->next = Set[set1].tail->head;		// set2의 next가 가리키는 위치에 set1의 head를 연결
		node* start = Set[set1].tail->head;			// 시작점을 set1의 tail값으로 시작함
		while (1)
		{
			start->head = Set[set2].tail->head;		// 시작점이 가리키는 곳은 set2의 tail이 가리키는 head
			if (start == Set[set1].tail)			// 시작점이 set1의 tail과 같다면 반복문 탈출
				break;
			start = start->next;	// 시작점을 옮김
		}
		Set[set2].tail = Set[set1].tail;	// set1의 tail을 set2의 tail에 갖다붙임

		printSet(set2);		// 합쳐진 set2 출력
	}
	else	// set1이 set2보다 큰 경우 set2를 set1 뒤에 붙임
	{	
		Set[set1].totalElementNum += Set[set2].totalElementNum; // set1의 총 원소 개수에 set2의 총 원소 개수를 더함
		Set[set1].tail->next = Set[set2].tail->head;		// set1의  next가 가리키는 위치에 set2의 head를 연결
		node* start = Set[set2].tail->head;			// 시작점을 set2의 tail값으로 시작함
		while (1)
		{
			start->head = Set[set1].tail->head;		// 시작점이 가리키는 곳은 set1의 tail이 가리키는 head
			if (start == Set[set2].tail)			// 시작점이 set2의 tail과 같다면 반복문 탈출
				break;
			start = start->next;	// 시작점을 옮김
		}
		Set[set1].tail = Set[set2].tail;	// set2의 tail을 set1의 tail에 갖다붙임

		printSet(set1);		// 합쳐진 set1 출력
	}
}

int main(void)
{	
	makeSet('x');
	makeSet('y');
	findSet('x');
	findSet('y');
	unionSet('x', 'y');
	makeSet('z');
	unionSet('x', 'z');

	return 0;
}
