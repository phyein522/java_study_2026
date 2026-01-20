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

	public void arrayCreateByValueListExample1() {
		System.out.println("\n\nArrayCreateByValueListExample1");

		String[] season = {"Spring", "Summer", "Fall", "Winter"};

		System.out.println("season[0]: " + season[0]);
		System.out.println("season[1]: " + season[1]);
		System.out.println("season[2]: " + season[2]);
		System.out.println("season[3]: " + season[3]);

		season[1] = "여름";
		System.out.println("\nseason[1]: " + season[1]);
		System.out.println();

		int[] scores = {83, 90, 87};
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			System.out.println(sum + " + " + scores[i] + " = " + (sum + scores[i]));
			sum += scores[i];
		}
		System.out.println("총합: " + sum);
		double avg = (double)sum / 3;
		System.out.println("평균: " + avg);
	}
	public void arrayCreateByValueListExample2() {
		System.out.println("\n\nArrayCreateByValueListExample2");

		int[] scores;
		scores = new int[] {83, 90, 87};
		int sum1 = 0;
		for(int i = 0; i < 3; i++) {
			System.out.println(sum1 + " + " + scores[i] + " = " + (sum1 + scores[i]));
			sum1 += scores[i];
		}
		System.out.println("총합: " + sum1);

		printItem(new int[] {83, 90, 87});
	}
	public static void printItem(int[] scores) {
		for(int i = 0; i < 3; i++) {
			System.out.println("score[" + i + "]: " + scores[i]);
		}
	}
	public void arrayCreateByNewExample() {
		System.out.println("\n\nArrayCreateByNewExample");

		int[] arr1 = new int[3];
		for(int i = 0; i < 3; i++) {
			System.out.println("arr1[" + i + "]: " + arr1[i]);
		}
		System.out.println();

		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		for(int i = 0; i < 3; i++) {
			System.out.println("arr1[" + i + "]: " + arr1[i]);
		}
		System.out.println();

		double[] arr2 = new double[3];
		for(int i = 0; i < 3; i++) {
			System.out.println("arr2[" + i + "]: " + arr2[i]);
		}
		System.out.println();

		arr2[0] = 0.1;
		arr2[1] = 0.2;
		arr2[2] = 0.3;
		for(int i = 0; i < 3; i++) {
			System.out.println("arr2[" + i + "]: " + arr2[i]);
		}
		System.out.println();

		String[] arr3 = new String[3];
		for(int i = 0; i < 3; i++) {
			System.out.println("arr3[" + i + "]: " + arr3[i]);
		}
		System.out.println();

		arr3[0] = "1월";
		arr3[1] = "2월";
		arr3[2] = "3월";
		for(int i = 0; i < 3; i++) {
			System.out.println("arr3[" + i + "]: " + arr3[i]);
		}
	}
	public void arrayLengthExample() {
		System.out.println("\n\nArrayLengthExample");

		int[] scores = {84, 90, 96};

		int sum = 0;
		for(int i = 0; i < scores.length; i++) {
			System.out.println(sum + " + " + scores[i] + " = " + (sum + scores[i]));
			sum += scores[i];
		}
		System.out.println("총합: " + sum);

		double avg = (double)sum / scores.length;
		System.out.println("평균: " + avg);
	}
	public void multidimensionalArrayByValueListExample() {
		System.out.println("\n\nMultidimensionalArrayByValueListExample");

		int[][] scores = {
				{80, 80, 96},
				{76, 88}
		};

		System.out.println("1차원 배열 길이 (반의 수): " + scores.length);
		System.out.println("2차원 배열 길이 (첫 번째 반의 학생 수): " + scores[0].length);
		System.out.println("2차원 배열 길이 (두 번째 반의 학생 수): " + scores[1].length);
		System.out.println();

		System.out.println("scores[0][2] (첫 번째 반의 세 번째 학생 점수): " + scores[0][2]);
		System.out.println("scores[1][1] (두 번째 반의 두 번째 학생 점수): " + scores[1][1]);
		System.out.println();

		int class1Sum = 0;
		for(int i = 0; i < scores[0].length; i++) {
			System.out.println(class1Sum + " + " + scores[0][i] + " = " + (class1Sum + scores[0][i]));
			class1Sum += scores[0][i];
		}
		double class1Avg = (double)class1Sum / scores[0].length;
		System.out.println("첫 번째 반의 평균 점수: " + class1Avg);
		System.out.println();

		int class2Sum = 0;
		for(int i = 0; i < scores[1].length; i++) {
			System.out.println(class2Sum + " + " + scores[1][i] + " = " + (class2Sum + scores[1][i]));
			class2Sum += scores[1][i];
		}
		double class2Avg = (double)class2Sum / scores[1].length;
		System.out.println("두 번째 반의 평균 점수: " + class2Avg);
		System.out.println();

		int totalStudent = 0;
		int totalSum = 0;
		for(int i = 0; i < scores.length; i++) {
			totalStudent += scores[i].length;
			for(int k = 0; k < scores[i].length; k++) {
				System.out.println(totalSum + " + " + scores[i][k] + " = " + (totalSum + scores[i][k]));
				totalSum += scores[i][k];
			}
		}
		double totalAvg = (double)totalSum / totalStudent;
		System.out.println("전체 학생의 평균 점수: " + totalAvg);
	}
	public void multidimensionalArrayByNewExample() {
		System.out.println("\n\nMultidimensionalArrayByNewExample");

		int[][] mathScores = new int[2][3];

		for(int i = 0; i < mathScores.length; i++) {
			for(int k = 0; k < mathScores[i].length; k++) {
				System.out.println("mathScores[" + i + "][" +k + "]: " + mathScores[i][k]);
			}
		}
		System.out.println();

		mathScores[0][0] = 80;
		mathScores[0][1] = 83;
		mathScores[0][2] = 85;
		mathScores[1][0] = 86;
		mathScores[1][1] = 90;
		mathScores[1][2] = 92;

		int totalStudent = 0;
		int totalMathSum = 0;
		for(int i = 0; i < mathScores.length; i++) {
			totalStudent += mathScores[i].length;
			for(int k = 0; k < mathScores[i].length; k++) {
				System.out.println(totalMathSum + " + " + mathScores[i][k] + " = " + (totalMathSum + mathScores[i][k]));
				totalMathSum += mathScores[i][k];
			}
		}
		double totalMathAvg = (double)totalMathSum / totalStudent;
		System.out.println("전체 학생의 수학 평균 점수: " + totalMathAvg);
		System.out.println();

		int[][] englishScores = new int[2][];
		englishScores[0] = new int[2];
		englishScores[1] = new int[3];
		for(int i = 0; i < englishScores.length; i++) {
			for(int k = 0; k < englishScores[i].length; k++) {
				System.out.println("englishScores[" + i + "][" + k + "]: " + englishScores[i][k]);
			}
		}
		System.out.println();

		englishScores[0][0] = 90;
		englishScores[0][1] = 91;
		englishScores[1][0] = 92;
		englishScores[1][1] = 93;
		englishScores[1][2] = 94;

		totalStudent = 0;
		int totalEnglishSum = 0;
		for(int i = 0; i < englishScores.length; i++) {
			totalStudent += englishScores[i].length;
			for(int k = 0; k < englishScores[i].length; k++) {
				System.out.println(totalEnglishSum + " + " + englishScores[i][k] + " = " + (totalEnglishSum + englishScores[i][k]));
				totalEnglishSum += englishScores[i][k];
			}
		}
		double totalEnglishAvg = (double)totalEnglishSum / totalStudent;
		System.out.println("전체 학생의 영어 평균 점수: " + totalEnglishAvg);
	}
}
