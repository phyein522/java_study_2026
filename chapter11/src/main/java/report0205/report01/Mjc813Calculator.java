package report0205.report01;

public class Mjc813Calculator {
	public Long sum( Integer ... arrs ) {
		Long result = 0L;
		// arrs 값들의 모든 합을 구해야 합니다.
		// 다만 arrs 배열이 null 일 수 있으므로 예외처리를 이곳이든 이곳을 호출하는 메소드에서든 꼭 해야 합니다.
		/*
		if(arrs == null || arrs.length == 0) {
			throw new NullPointerException("매개값 null");
		}
		for(Integer n : arrs) {
			if(n == null) {
				throw new NullPointerException("매개값에 null 포함됨");
				//continue;
			}
			result += n;
		}
		*/
		try {
			for(Integer n : arrs) {
				result += n;
			}
		} catch(NullPointerException e) {
			throw new NullPointerException("매개값에 null 포함됨");
		}
		return result;
	}

	public Long sum( Integer[] arrs, Integer start, Integer end) {
		Long result = 0L;
		// arrs 배열중에서 start ~ end 인덱스 까지의 원소들의 모든 합을 구해야 합니다.
		// 다만 arrs 배열이 null 일 수 도 있고, 원소가 null 일 수도 있고
		// 배열 인덱스 start ~ end 가 문제가 생길 수 도 있습니다.
		// 그러므로 예외처리를 꼭 해야 합니다.
		/*
		if(arrs == null || start == null || end == null) {
			throw new NullPointerException("매개값 null");
		}
		if(start < 0 || start >= arrs.length || end >= arrs.length) {
			throw new ArrayIndexOutOfBoundsException("인덱스 범위 초과");
		}
		if(start > end) {
			Integer temp = start;
			start = end;
			end = temp;
		}
		for(int i = start; i <= end; i++) {
			result += arrs[i];
		}
		*/
		try {
			if(start > end) {
				Integer temp = start;
				start = end;
				end = temp;
			}
			for(int i = start; i <= end; i++) {
				result += arrs[i];
			}
		} catch(NullPointerException e) {
			throw new NullPointerException("매개값에 null 포함됨");
		} catch(ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("인덱스 범위 초과");
		}
		return result;
	}
}
