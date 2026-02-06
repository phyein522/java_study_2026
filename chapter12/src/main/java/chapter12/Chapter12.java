package chapter12;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class Chapter12 {
	public void equalsExample() {
		System.out.println("\n\nEqualsExample");

		Member1 obj1 = new Member1("blue");
		Member1 obj2 = new Member1("blue");
		Member1 obj3 = new Member1("red");

		if(obj1.equals(obj2)) {
			System.out.println("obj1 과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1과 obj2는 도등하지 않습니다.");
		}

		if(obj1.equals(obj3)) {
			System.out.println("obj1과 obj3은 동등합니다.");
		} else {
			System.out.println("obj1과 obj3은 동등하지 않습니다.");
		}
	}

	public void hashCodeExample() {
		System.out.println("\n\nHashCodeExample");

		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");

		if(s1.hashCode() == s2.hashCode()) {
			if(s1.equals(s2)) {
				System.out.println("동등 객체입니다.");
			} else {
				System.out.println("데이터가 다르므로 동등 객체가 아닙니다.");
			}
		} else {
			System.out.println("해시코드가 다르므로 동등 객체가 아닙니다.");
		}
	}

	public void hashSetExample() {
		System.out.println("\n\nHashSetExample");

		HashSet hashSet = new HashSet();

		Student s1 = new Student(1, "홍길동");
		hashSet.add(s1);
		System.out.println("저장된 객체 수: " + hashSet.size());

		Student s2 = new Student(1, "홍길동");
		hashSet.add(s2);
		System.out.println("저장된 객체 수: " + hashSet.size());

		Student s3 = new Student(2, "홍길동");
		hashSet.add(s3);
		System.out.println("저장된 객체 수: " + hashSet.size());
	}

	public void toStringExample() {
		System.out.println("\n\nToStringExample");

		SmartPhone myPhone = new SmartPhone("상성전자", "안드로이드");

		String strObj = myPhone.toString();
		System.out.println(strObj);

		System.out.println(myPhone);
	}

	public void recordExample() {
		System.out.println("\n\nRecordExample");

		Member2 m = new Member2("winter", "눈송이", 25);
		System.out.println(m.id());
		System.out.println(m.name());
		System.out.println(m.age());
		System.out.println(m.toString());
		System.out.println();

		Member2 m1 = new Member2("winter", "눈송이", 25);
		Member2 m2 = new Member2("winter", "눈소이", 25);
		System.out.println("m1.hashCode(): " + m1.hashCode());
		System.out.println("m2.hashCdoe(): " + m2.hashCode());
		System.out.println("m1.equals(m2): " + m1.equals(m2));
	}

	public void errExample() {
		System.out.println("\n\nErrExample");

		try {
			int value = Integer.parseInt("1oo");
		} catch(NumberFormatException e) {
			System.err.println("[에러 내용]");
			System.err.println(e.getMessage());
		}
	}

	public void inExample() throws Exception {
		System.out.println("\n\nInExample");

		int speed = 0;
		int keyCode = 0;

		while(true) {
			if(keyCode != 13 && keyCode != 10) {
				if(keyCode == 49) {
					speed++;
				} else if(keyCode == 50) {
					speed--;
				} else if(keyCode == 51) {
					break;
				}
				System.out.println("\n------------------------------");
				System.out.println("1. 증속 | 2. 감속 | 3. 중지");
				System.out.println("------------------------------");
				System.out.println("현재 속도 = " + speed);
				System.out.print("선택: ");
			}
			keyCode = System.in.read();
		}
	}
	public void exitExample() {
		System.out.println("\n\nExitExample");

		for(int i = 0; i < 10; i++) {
			System.out.println(i);
			if(i == 5) {
				System.out.println("프로세스 강제 종료");
				System.exit(0);
			}
		}
	}

	public void measureRunTimeExample() {
		System.out.println("\n\nMeasureRunTimeExample");

		long time1 = System.nanoTime();

		int sum = 0;
		for(int i = 1; i <= 1000000; i++) {
			sum += i;
		}

		long time2 = System.nanoTime();

		System.out.println("1 ~ 1000000까지의 합: " + sum);
		System.out.println("계산에 " + (time2 - time1) + " 나노초가 소요되었습니다.");
	}

	public void getPropertyExample() {
		System.out.println("\n\nGetPropertyExample");

		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.hone");
		System.out.println(osName);
		System.out.println(userName);
		System.out.println(userHome);

		System.out.println("\n--------------------");
		System.out.println(" key:  value");
		System.out.println("--------------------");

		Properties props = System.getProperties();
		Set keys = props.keySet();
		for(Object objKey : keys) {
			String key = (String)objKey;
			String value = System.getProperty(key);
			System.out.printf("%-40s: %s \n", key, value);
		}
	}

	public void byteToStringExample() {
		System.out.println("\n\nByteToStringExample");

		String data = "자바";

		byte[] arr1 = data.getBytes();	//.getByte("UTF-8")
		System.out.println("arr1: " + Arrays.toString(arr1));

		String str1 = new String(arr1);	//new String(arr1, "UTF-8")
		System.out.println("str1: " + str1);

		byte[] arr2;
		try {
			arr2 = data.getBytes("EUC-KR");
		} catch(UnsupportedEncodingException e) {
			arr2 = data.getBytes();
		}
		System.out.println("arr2: " + Arrays.toString(arr2));

		String str2;
		try {
			str2 = new String(arr2, "EUC-KR");
		} catch(UnsupportedEncodingException e) {
			str2 = new String(arr2);
		}
		System.out.println("str2: " + str2);
	}

	public void stringBuilderExample() {
		System.out.println("\n\nStringBuilderExample");

		String data = new StringBuilder().append("DEF").insert(0, "ABC").delete(3, 4).toString();
		System.out.println(data);
	}

	public void stringTokenizerExample() {
		System.out.println("\n\nStringTokenizerExample");

		String data1 = "홍길동&이수홍,박연수";
		String[] arr = data1.split("&|,");
		for(String token : arr) {
			System.out.println(token);
		}
		System.out.println();

		String data2 = "홍길동/이수홍/박연수";
		StringTokenizer st = new StringTokenizer(data2, "/");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
