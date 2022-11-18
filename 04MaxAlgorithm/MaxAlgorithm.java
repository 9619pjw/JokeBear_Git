/*[?] 주어진 데이터 중에서 가장 큰 값
 * 최댓값 알고리즘
 */

public class MaxAlgorithm{
    public static void main(String[] args){
        //[0] initialize
        int max = Integer.MIN_VALUE; // 정수 형식의 데이터 중 가장 작은 값으로 초기화
        //[1] input
        int[] numbers = {-2,-3,-5,-7,-1};

        //[2] process
        for(int i = 0; i<numbers.length; i++){
          if(numbers[i] > max)
            max = numbers[i]; // 더 큰 값으로 할당
        }
        //[3] output
        System.out.println("최댓값 :" + max);
    }
}