/*
 * 최솟값 알고리즘(Min Algorithm)
 * 주어진 범위 + 주어진 조건의 자료들의 가장 작은 값 
    주어진 데이터 중 가장 작은 짝수 값 구하기
 */


public class MinAlgorithm{
    public static void main(String[] args){
        //[1] Initialize
        int min = Integer.MAX_VALUE; // 정수형식 데이터 중 가장 큰 값으로 초기화
        
        //[2] Input
        int[] numbers = {0b0010, 0b0101, 0b0011,0b0111, 0b0000_0001};
        
        //[3] Pro cess
        for(int i=0;i<numbers.length; i++){
            if(numbers[i]<min && numbers[i]%2 == 0){
                min = numbers[i];
            }
        }

        //[4] Output
        System.out.println("짝수 최솟값 : " + min);
    }
}