/*
 * 순위 알고리즘 - 점수 데이터에 대한 순위를 구함
 * [?] 주어진(지정한 범위) 데이터의 순위(등수)를 구하는 로직
 */
public class RankAlgorithm{

    public static void main(String[] args){
        //[1] Input
        int[] scores = {90, 87, 100, 95, 80}; // 등수 : 3, 4, 1, 2, 5
        int[] rankings = {1,1,1,1,1}; // 모두 1등으로 초기화
        
        //[2] Process
        for(int i = 0; i<scores.length; i++){
            rankings[i] = 1; // 순위배열을 매 회전마다 1등으로 초기화
            for(int j = 0; j<scores.length; j++){
                if(scores[i] < scores[j]){ // 현재(i)와 나머지들(j)의 비교
                    rankings[i]++; // RANK: 나보다 큰 점수가 나오면 순위를 1 증가시켜줌
                }
            }
        }
        //[3] Output
        for(int i=0; i<scores.length; i++){
            System.out.println(String.format("%3d점 : %1d", scores[i], rankings[i]));
        }
    }
}