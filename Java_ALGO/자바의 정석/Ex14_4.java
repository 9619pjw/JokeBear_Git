import java.util.*;

class Ex14_4 {
	public static void main(String[] args) 	{
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++)
			list.add(i);

		// forEach() ... 모든 요소에 작업을 수행	
		// list의 모든 요소를 출력
		list.forEach(i->System.out.print(i+","));
		System.out.println();

		// removeIf() ... 조건에 맞는 요소를 삭제
		// list에서 2 또는 3의 배수를 제거함.
		list.removeIf(x-> x%2==0 || x%3==0);
		System.out.println(list);

		//replaceAll() ... 모든 요소를 변환하여 대체
		list.replaceAll(i->i*10); // list의 각 요소에 10을 곱한다.
		System.out.println(list);

		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");

		// map의 모든 요소를 {k,v}의 형식으로 출력.
		map.forEach((k,v)-> System.out.print("{"+k+","+v+"},"));
		System.out.println();
	}
}