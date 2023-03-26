/*
 [?] 무작위 데이터를 순서대로 오름차|내림차순 정렬
 * 정렬 알고리즘 : 가장 작은/큰 데이터를 왼쪽으로 순서대로 이동
 */

public class SortAlgorithm{
    public static void main(String[] args){
        //[1] Input : Data Structure(Array, List, Stack, Queue, Tree, DB, ...)
        int[] data = {3,2,1,5,4};
        int N = data.length; //슈도코드로 알고리즘 표현
        
        //[2] Process : Selection Sort
        for(int i = 0 ; i < N - 1 ; i++){ // i = 0 to N - 1
            for(int j = i+1 ; j < N ; j++){ // j = i+1 to N
                if(data[i]>data[j]){ // > : 오름차순 < : 내림차순
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        } 
        //[3] Output : Console, DeskTop, ...
        for(int i =0; i < N ; i++) {
            System.out.println(data[i]+ "\t");
        }
        System.out.println();
    }
}