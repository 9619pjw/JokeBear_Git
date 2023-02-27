/*
주어진 입력값으로 트리를 구성하고 
구성된 트리를 전위순회하고 방문한 노드의 번호를 출력하라.
==========입력==========
2 // # 테스트 케이스 횟수
13 12 // # 노드의 총 수 N 간선의 총 수 E
1 2 1 3 2 4 3 5 3 6 4 7 7 12 5 9 5 8 6 11 6 10 11 13// 
11 13 // 간선 정보 (부모 자식 순서)
10 9 // 노드의 총 수 N 간선의 총 수 E
1 2 1 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10
===========출력===========
#1
1 2 4 7 12 3 5 9 8 6 11 13 10
#2
1 2 3 4 5 6 7 8 9 10
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
            if (treenode[parent].child[i] == -1)
            {
                found = i;
                break;
            }
        }
        if (found == -1) return;
         
        treenode[parent].child[found] = child;
        treenode[child].parent = parent;
    }
 
    public int getRoot() 
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
            if (child != -1)
            {
                preOrder(child);
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
                int child = sc.nextInt(); // 자식노드
                tree.addChild(parent, child); //
            }
            int root = tree.getRoot(); // 루트
            System.out.printf("#%d ", test_case);
            tree.preOrder(root);
            System.out.printf("\n");
        }
 
        sc.close();
    }
}
