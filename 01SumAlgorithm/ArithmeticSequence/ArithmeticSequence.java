/* 
    1부터 20까지의 정수 중 홀수의 합을 구하는 프로그램
 * 등차수열 연속하는 두수의 차이가 일정한 수열
 */
public class ArithmeticSequence{
    public static void main(String[] args){
        // [1] Input 
        int sum = 0;
    
        // [2] Process
        for(int i=0; i <=20 ;i++){
            if(i%2 != 0){
                sum += i;
            }
        }
        // [3] Output
        System.out.println("1부터 20까지의 홀수의 합 : " + sum);
    }
}