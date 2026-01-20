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
}
