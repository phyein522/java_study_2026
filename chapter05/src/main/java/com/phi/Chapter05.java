package com.phi;

public class Chapter05 {
	public void referenceVariableCompareExample() {
		System.out.println("\nReferenceVariableCompareExample");

		int[] arr1;
		int[] arr2;
		int[] arr3;

		arr1 = new int[] {1, 2, 3};
		arr2 = new int[] {1, 2, 3};
		arr3 = arr2;

		System.out.println("arr1 == arr2: " + (arr1 == arr2));
		System.out.println("arr2 == arr3: " + (arr2 == arr3));
	}
	public void nullPointerExceptionExample() {
		System.out.println("\nNullPointerExceptionExample");

		int[] intArray = null;
		//intArray[0] = 10;
		try {
			intArray[0] = 10;
		} catch(NullPointerException e) {
			System.out.println(e);
		}

		String str = null;
		//System.out.println("총 문자 수: " + str.length());
		try {
			System.out.println("총 문자 수: " + str.length());
		} catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	public void garbageObjectExample() {
		System.out.println("\nGarbageObjectExample");

		String hobby = "여행";
		hobby = null;
		System.out.println("hobby: " + hobby);

		String kind1 = "자동차";
		String kind2 = kind1;
		kind1 = null;
		System.out.println("kind2: " + kind2);
	}

	public void hashCodeExample() {
		System.out.println("\nhashCode()");
		String a = "abc";
		String b = "abc";
		System.out.println("a:" + a.hashCode() + ", b: " + b.hashCode());
		b = new String("abc");
		System.out.println("a:" + a.hashCode() + ", b: " + b.hashCode());
	}
	public void equalsExample() {
		System.out.println("\nEqualsExample");

		String strVar1 = "홍길동";
		String strVar2 = "홍길동";

		if(strVar1 == strVar2) {
			System.out.println("strVar1(" + strVar1 + ")과 strVar2(" + strVar2 + ")는 참조가 같음 (strVar1 == strVar2: " + (strVar1 == strVar2) + ")");
		} else {
			System.out.println("strVar1(" + strVar1 + ")과 strVar2(" + strVar2 + ")는 참조가 다름 (strVar1 == strVar2: " + (strVar1 == strVar2) + ")");
		}

		if(strVar1.equals(strVar2)) {
			System.out.println("strVar1과 strVar2는 문자열이 같음 (strVar1.equals(strVar2): " + strVar1.equals(strVar2) + ")");
		}

		String strVar3 = new String("홍길동");
		String strVar4 = new String("홍길동");

		if(strVar3 == strVar4) {
			System.out.println("strVar3(" + strVar3 + ")과 strVar4(" + strVar4 + ")는 참조가 같음 (strVar3 == strVar4: " + (strVar3 == strVar4) + ")");
		} else {
			System.out.println("strVar3(" + strVar3 + ")과 strVar4(" + strVar4 + ")는 참조가 다름 (strVar3 == strVar4: " + (strVar3 == strVar4) + ")");
		}

		if(strVar3.equals(strVar4)) {
			System.out.println("strVar1과 strVar2는 문자열이 같음 (strVar3.equals(strVar4): " + strVar3.equals(strVar4) + ")");
		}
	}
	public void emptyStringExample() {
		System.out.println("\nEmptyStringExample");

		String hobby = "";
		if(hobby.equals("")) {
			System.out.println("hobby 변수가 참조하는 String 객체는 빈 문자열 (hobby.equals(\"\"): " + hobby.equals("") + ")");
		}
	}
	public void charAtExample() {
		System.out.println("\nChatAtExample");

		String ssn = "9506241230123";
		System.out.println("주민등록번호: " + ssn);
		char sex = ssn.charAt(6);
		switch(sex) {
			case '1':
			case '3':
				System.out.println(sex + ": 남자입니다.");
				break;
			case '2':
			case '4':
				System.out.println(sex + ": 여자입니다.");
				break;
		}
	}
	public void lengthExample() {
		System.out.println("\nLengthExample");

		String ssn = "9506241230123";
		System.out.println("주민등록번호: " + ssn);
		int length = ssn.length();
		if(length == 13) {
			System.out.println("주민등록번호 자릿수가 맞습니다. (" + length + "자리)");
		} else {
			System.out.println("주민등록번호 자릿수가 틀립니다. (" + length + "자리)");
		}
	}
	public void replaceExample() {
		System.out.println("\nReplaceExample");

		String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String입니다.";
		System.out.println("oldStr: " + oldStr);

		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println("newStr(oldStr.replace(\"자바\", \"JAVA\")): " + newStr);
	}
	public void subStringExample() {
		System.out.println("\nSubStringExample");

		String ssn = "880815-1234567";
		System.out.println("주민등록번호: " + ssn);

		String firstNum = ssn.substring(0, 6);
		System.out.println("앞 자리 (ssn.substring(0, 6)): " + firstNum);

		String secondNum = ssn.substring(7);
		System.out.println("뒷 자리 (ssn.substring(7)): " + secondNum);
	}
	public void indexOfContainsExample() {
		System.out.println("\nIndexOfContainsExample");

		String subject = "자바 프로그래밍";
		System.out.println("문자열: " + subject);

		int location = subject.indexOf("프로그래밍");
		System.out.println("\"프로그래밍\" 시작 인덱스: " + location);

		String substring = subject.substring(location);
		System.out.println(subject + ".substring(" + location + "): " + substring);

		location = subject.indexOf("자바");
		if(location != -1) {
			System.out.println("자바와 관련된 책이군요. (\"자바\" 시작 인덱스: " + location + ")");
		} else {
			System.out.println("자바와 관련 없는 책이군요.");
		}

		boolean result = subject.contains("자바");
		if(result) {
			System.out.println("자바와 관련된 책이군요. (\"" + subject + "\".contains(\"자바\"): " + result + ")");
		} else {
			System.out.println("자바와 관련 없는 책이군요. (\"" + subject + "\".contains(\"자바\"): " + result + ")");
		}
	}
	public void splitExample() {
		System.out.println("\nSplitExample");

		String board = "1,자바 학습,참조 타입 String을 학습합니다.,홍길동";

		String[] tokens = board.split(",");

		System.out.println("번호: " + tokens[0]);
		System.out.println("제목: " + tokens[1]);
		System.out.println("내용: " + tokens[2]);
		System.out.println("성명: " + tokens[3]);
		System.out.println();

		String[] titles = {"번호", "제목", "내용", "성명"};

		for(int i = 0; i < tokens.length; i++) {
			System.out.println(titles[i] + ": " + tokens[i]);
		}
		System.out.println();

		int i = 0;
		for(String token : tokens) {
			System.out.println(titles[i] + ": " + token);
			i++;
		}
	}
}
