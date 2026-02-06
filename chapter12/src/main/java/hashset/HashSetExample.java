package hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public void hashSetExample1() {
		System.out.println("\n\nHashSetExample (1)");

		Set<String> set = new HashSet<String>();

		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Java");
		set.add("Spring");

		int size = set.size();
		System.out.println("총 객체 수: " + size);
	}

	public void hashSetExample2() {
		System.out.println("\n\nHashSetExample (2)");

		Set<Member> set = new HashSet<>();

		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));

		System.out.println("총 객체 수: " + set.size());
	}

	public void hashSetExample3() {
		System.out.println("\n\nHashSetExample (3)");

		Set<String> set = new HashSet<>();

		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Spring");

		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);

			if(element.equals("JSP")) {
				iterator.remove();	//next()로 가져온 객체을 Set 컬렉션에서 제거
			}
		}
		System.out.println();

		set.remove("JDBC");

		for(String element : set) {
			System.out.println(element);
		}
	}
}
