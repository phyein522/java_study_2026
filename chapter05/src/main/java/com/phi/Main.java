package com.phi;

public class Main {
	public static void main(String[] args) {
        Chapter05 ch5 = new Chapter05();

		ch5.referenceVariableCompareExample();
		ch5.nullPointerExceptionExample();
		ch5.garbageObjectExample();

		ch5.hashCodeExample();
		ch5.equalsExample();
		ch5.emptyStringExample();
		ch5.charAtExample();
		ch5.lengthExample();
		ch5.replaceExample();
		ch5.subStringExample();
		ch5.indexOfContainsExample();
		ch5.splitExample();

		ch5.arrayCreateByValueListExample1();
		ch5.arrayCreateByValueListExample2();
		ch5.arrayCreateByNewExample();
		ch5.arrayLengthExample();
		ch5.multidimensionalArrayByValueListExample();
		ch5.multidimensionalArrayByNewExample();

		ch5.arrayReferenceObjectExample();
		ch5.arrayCopyByForExample();
		ch5.arrayCopyExample();
		ch5.advancedForExample();
		ch5.mainStringArrayArgument(new String[] {});
		ch5.mainStringArrayArgument(new String[] {"10", "20"});
		ch5.weekExample();

		ch5.exercise07();
		ch5.exercise08();
		ch5.exercise09();
	}
}