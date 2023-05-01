/*
Hash table (해시 테이블)
키를 값에 매핑할 수 있는 구조인 연관 배열 추가에 사용되는 자료구조.
Hash 함수를 사용하여 색인(index, key)을 버킷(Bucket)이나 슬롯(slot)의 배열로 계산한다.

문제)
주어진 N개의 key, data 쌍을 Hash table에 입력한 후,
Q개의 key를 입력 받아 key에 해당하는 data를 각 줄에 출력하세요.
(1 <= N,Q <= 4096)
(Key : 최대 64개의 문자열)
(Data : 최대 128개의 문자열)
===================================================
                    입력                           
===================================================
2 // test case 개수 T                               
4 // 입력할 데이터 수 N 
A a // key, data                                    
B b // key, data 
C c // key, data 
D d// key, data            
2 // 검색할 데이터 수 Q
A
C
3 // 입력할 데이터 수 N
hello world
code jam
google banana
2 // 검색할 데이터 수 Q
world
google
===================================================
                    출력
===================================================
#1
a
c
#2 
not find
banana
출처 : SW Expert Reference Code_ Priority_Queue
*/

import java.util.Scanner;
class Hashtable{
    class Hash {
        String key;  // 데이터를 식별하는 key
        String data; // 데이터
    }
    
    int capacity; // 해시 테이블 용량
    Hash tb[]; // 해시 테이블
    
    // 해시 테이블 생성자
    public Hashtable(int capacity){ 
        this.capacity = capacity;
        tb = new Hash[capacity];
        for (int i = 0; i < capacity; i++){
            tb[i] = new Hash(); // 해시 테이블의 각 요소를 초기화
        }
    }
    
    //key를 입력받아 해시 값을 반환하는 함수
    private int hash(String str){ 
        int hash = 5381; // 해시값
        
        for (int i = 0; i < str.length(); i++){ // 입력받은 문자열의 길이만큼
            int c = (int)str.charAt(i); // 입력받은 문자열의 아스키값으로
            hash = ((hash << 5) + hash) + c; // 해시값 연산
        }
        if (hash < 0) hash *= -1; // 해시 값이 음수인 경우 부호 변경
        return hash % capacity; // 해시 테이블의 크기에 맞게 해시값 조정하여 반환
    }
  
    // key를 검색하여 해당 data를 반환하는 함수
    public String find(String key){ 
        int h = hash(key);   // key의 해시값 계산
        int cnt = capacity;  // 해시 테이블 크기
        while(tb[h].key != null && (--cnt) != 0){ //해시 테이블의 요소가 null이 아니거나 모두 탐색할 때까지 반복
            if (tb[h].key.equals(key)){ // 해시 테이블에 존재 시
                return tb[h].data; // 해당 키에 맞는 값을 반환함
            }
            h = (h + 1) % capacity; // 다음 요소로 넘어감
        return null;    // 테이블에 해당 키가 없으면 null 반환
    }
    
    // 해시 테이블에 키와 값 추가하는 함수
    boolean add(String key, String data){ 
        int h = hash(key); // key의 해시값 계산
        while(tb[h].key != null){  // 해시 테이블의 요소를 처음부터 끝까지 차례대로 탐색
            if (tb[h].key.equals(key)){ // 해시테이블에 이미 존재하는 값이면 false 반환
                return false;
            }
            h = (h + 1) % capacity; // 해시값 갱신
        }
        tb[h].key = key;  // 해시 테이블에 키와 값을 추가해줌
        tb[h].data = data;
        return true; // 추가 성공시 true 반환
    }
}

class Exercise{
    final static int MAX_TABLE = 4096; // 테이블 최대값
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 횟수
        for (int test_case = 1; test_case <= T; test_case++){
            Hashtable tb = new Hashtable(MAX_TABLE);
            int N = sc.nextInt(); // 입력할 데이터 수
            for (int i = 0; i < N; i++){ // 키와 값 입력
                String k = sc.next();
                String d = sc.next();
                tb.add(k, d);
            }
            System.out.printf("#%d\n", test_case);
            int Q = sc.nextInt(); // 검색할 데이터 수
            sc.nextLine(); // 테스트 케이스 다음 입력으로 넘어가도록 추가함
            for (int i = 0; i < Q; i++){
                String k = sc.next();
                String d = tb.find(k); // 해당 데이터가 존재하는지 find
                if (d != null){
                    System.out.printf("%s\n", d); // 키 존재시 값 출력
                }
                else{
                    System.out.printf("not find\n"); // 키 부재시 not find
                }
            }
        }
        sc.close();
    }
}
