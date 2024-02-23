Dynamic Programming (동적 계획법)
복잡한 문제를 풀기위해서 간단한 여러 개의 하위 문제로 나누어 푼 다음, 
그것을 결합하여 목적에 도달하는 방법이다.

1. 큰 문제를 작은 문제로 나눌 수 있어야 한다.
2. 작은 문제들이 반복되어 나타나고 사용되며 작은 문제들의 결괏값은 항상 같아야한다.
3. *메모이제이션 기법을 사용한다.
4. *Top-down 방식과 *Bottom-up 방식으로 구현할 수 있다.

* 메모이제이션
부분 문제를 풀었을 때 이 문제를 DP 테이블에 저장해놓고 다음에 같은 문제가 나왔을때
재계산하지 않고 DP 테이블의 값을 이용하는 것을 말함.

* Top-down
위에서부터 문제를 파악해 내려오는 방식. 재귀함수 형태로 구현함.
가독성이 좋고 이해하기 편한 장점이 있다.

* Bottom-up
가장 작은 문제부터 문제를 해결하며 점점 큰 문제로 확장하는 방식.
반복문의 형태로 구현함.