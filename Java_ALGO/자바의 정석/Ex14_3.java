import java.util.function.*;

class Ex14_3 {
	public static void main(String[] args) {
		Function<String, Integer>	f  = (s) -> Integer.parseInt(s, 16);
		Function<Integer, String>	g  = (i) -> Integer.toBinaryString(i);

		Function<String, String>    h  = f.andThen(g); // f 먼저 실행 후 g 실행
		Function<Integer, Integer>  h2 = f.compose(g); // g 먼저 실행 후 f 실행

		System.out.println(h.apply("FF")); // "FF" -> 255 -> "11111111"
		System.out.println(h2.apply(2));   // 2 -> "10" -> 16 

		Function<String, String> f2 = x -> x;   // 항등 함수(identity function)
		System.out.println(f2.apply("AAA"));  // 항등 함수 : 그대로 출력함.

		// Predicate ... 조건식을 표현하는데 사용됨. 매개변수는 하나, 반환타입은 boolean
		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i%2 == 0;
		Predicate<Integer> notP = p.negate(); // i >= 100

		Predicate<Integer> all = notP.and(q.or(r));  // i >= 100 && (i < 200 || i % 2 == 0)
		System.out.println(all.test(150));       // true

		String str1 = "abc";
		String str2 = "abc";
		
		// str1과 str2가 같은지 비교한 결과를 반환함.
		Predicate<String> p2 = Predicate.isEqual(str1); 
		boolean result = p2.test(str2);   
		System.out.println(result); // true
	}
}