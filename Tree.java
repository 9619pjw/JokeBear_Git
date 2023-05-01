/*
트리 구조 (Tree)
트리 구조란 그래프의 일종으로, 
여러 노드가 한 노드를 가리킬 수 없는 구조이다. 간단하게는 회로가 없고,
서로 다른 두 노드를 잇는 길이 하나뿐인 그래프를 트리라고 부른다.

문제)
주어진 입력 값으로 트리를 구성하고, 
구성된 트리를 전위순회하고 방문한 노드의 번호를 출력하시오. 
첫 줄에는 전체 테스트 케이스의 수(T), 
두 번째 줄에는 노드의 총 수(nodeNum), 간선의 총 수(edgeNum)가 주어진다. 
그 다음 줄에는 간선이 나열 된다. 간선은 그것을 이루는 두 정점으로 표기된다. 
간선은 항상 “부모 자식” 순서로 표기 된다. 
(예를 들어 “1 2”는 정점 1과 2를 잇는 간선을 의미하며 1이 부모 2가 자식을 의미한다.) 
부모는 최대 2개의 자식 노드를 갖으며, 최대 노드의 개수는 10000개이다.
===================================================
                    입력                           
===================================================
2 // # 테스트 케이스 횟수
13 12 // # 노드의 총 수 N 간선의 총 수 E
1 2 1 3 2 4 3 5 3 6 4 7 7 12 5 9 5 8 6 11 6 10 11 13// 
11 13 // 간선 정보 (부모 자식 순서)
10 9 // 노드의 총 수 N 간선의 총 수 E
1 2 1 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10
===================================================
                    출력
===================================================
#1
1 2 4 7 12 3 5 9 8 6 11 13 10
#2
1 2 3 4 5 6 7 8 9 10

출처 : SW Expert Reference Code_ Tree
*/

import java.util.Scanner;
 
class Tree {
 
    static final int MAX_CHILD_NUM = 2; // 자식은 최대 2개
     
    class TreeNode { 
        int parent; // 부모노드
        int []child = new int[MAX_CHILD_NUM]; // 자식노드
        public TreeNode(int parent)
        {
            this.parent = parent; // 부모 노드 지정
            for (int i = 0; i < MAX_CHILD_NUM; i++)
            {
                child[i] = -1; // 자식 노드 -1로 초기화 
            }
        }
    }
 
    TreeNode []treenode;
    int nodeNum;
 
    public Tree(int nodeNum) {
        this.nodeNum = nodeNum;
        treenode = new TreeNode[nodeNum+1];
        for (int i = 0; i <= nodeNum; i++)
        {
            treenode[i] = new TreeNode(-1);
        }
    }
 
    public void addChild(int parent, int child) 
    {
        int found = -1;
        for (int i = 0; i < MAX_CHILD_NUM; i++)
        {
            if (treenode[parent].child[i] == -1) // 해당 노드의 자식노드가 비어있으면
            {
                found = i; // 넣을 자리를 found에 대입
                break;
            }
        }
        if (found == -1) return; // 넣을 자리 못찾았으면 -1 반환
         
        treenode[parent].child[found] = child; // parent의 자식 노드 자리에 child 넣음
        treenode[child].parent = parent; // child의 부모 노드 자리에 parent 넣
    }
 
    public int getRoot()  // 전위 순행 출발점 구하기
    {
        for (int i = 1; i < nodeNum; i++) 
        {
            if (treenode[i].parent == -1) // 부모가 -1인 노드 (부모가 없는 노드)가 루트
            {
                return i;
            }
        }
        return -1;
    }
 
    public void preOrder(int root) // 전위순행
    {
        System.out.printf("%d ", root); // 루트 출력
 
        for (int i = 0; i < MAX_CHILD_NUM; i++) 
        {
            int child = treenode[root].child[i];
            if (child != -1) // 자식 노드가 존재하면
            {
                preOrder(child); // 해당 자식 노드로 전위순행 함계속함
            }
        }
    }
}
 
class Main{
     
    public static void main(String arg[]) throws Exception {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt(); // 테스트 케이스 입력
 
        for (int test_case = 1; test_case <= T; ++test_case) 
        {
            int node = sc.nextInt(); // 노드의 총 수
            int edge = sc.nextInt(); // 간선의 총 수
             
            Tree tree = new Tree(node); // 노드 수만큼 트리 생성
 
            for (int i = 0; i < edge; i++) // 간선의 수만큼 반복
            {
                int parent = sc.nextInt(); // 부모 노드
                int child = sc.nextInt(); // 자식 노드
                tree.addChild(parent, child); // 부모 노드에 자식 노드 추가함
            }
            int root = tree.getRoot(); // 루트
            System.out.printf("#%d ", test_case);
            tree.preOrder(root);
            System.out.printf("\n");
        }
 
        sc.close();
    }
}
