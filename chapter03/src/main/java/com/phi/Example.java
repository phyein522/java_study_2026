package com.phi;

public class Example {
    public void compareOperatorExample() {
        System.out.println("\nCompareOperatorExample");

        int num1 = 10;
        int num2 = 10;
        boolean result1 = (num1 == num2);
        boolean result2 = (num1 != num2);
        boolean result3 = (num1 <= num2);
        System.out.println("(10 == 10) = " + result1);
        System.out.println("(10 != 10) = " + result2);
        System.out.println("(10 <= 10) = " + result3);

        char char1 = 'A';
        char char2 = 'B';
        boolean result4 = (char1 < char2);
        System.out.println("(\'A(65)\' < \'B(66)\') = " + result4);

        int num3 = 1;
        double num4 = 1.0;
        boolean result5 = (num3 == num4);
        System.out.println("(1 == 1.0) = " + result5);

        float num5 = 0.1f;
        double num6 = 0.1;
        boolean result6 = (num5 == num6);
        boolean result7 = (num5 == (float)num6);
        System.out.println("(0.1f == 0.1) = " + result6);
        System.out.println("(0.1f == (float)0.1) = " + result7);

        String str1 = "자바";
        String str2 = "Java";
        boolean result8 = (str1.equals(str2));
        boolean result9 = (!str1.equals(str2));
        System.out.println("\"자바\".equals(\"Java\") = " + result8);
        System.out.println("!\"자바\".equals(\"Java\") = " + result9);
    }
    public void logicalOperatorExample() {
        System.out.println("\nLogicalOperatorExample");

        int[] charCodes = {'A', 'a', '5'};
        for(int charCode : charCodes) {
            if((65 <= charCode) & (charCode <= 90)) {
                System.out.println((char)charCode + "(" + charCode + "): 대문자이군요.");
            }
            if((97 <= charCode) && (charCode <= 122)) {
                System.out.println((char)charCode + "(" + charCode + "): 소문자이군요.");
            }
            if((48 <= charCode) && (charCode <= 57)) {
                System.out.println((char)charCode + "(" + charCode + "): 0~9 숫자자이군요.");
            }
        }

        int[] values = {6, 7};
        for(int value : values) {
            if((value % 2 == 0) | (value % 3 == 0)) {
                System.out.println(value + ": 2 또는 3의 배수이군요.");
            }

            boolean result = (value % 2 == 0) || (value % 3 == 0);
            if(!result) {
                System.out.println(value + ": 2 또는 3의 배수가 아니군요.");
            }
        }
    }
    public void bitLogicExample() {
        System.out.println("\nBitLogicExample");

        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25));
        System.out.println("~45 = " + (~45));

        byte receiveData = -120;
        int unsignedInt1 = receiveData & 255;
        System.out.println("1. 비트 논리곱 연산으로 Unsigned 정수 얻기: -120 & 255 = " + unsignedInt1);

        int unsignedInt2 = Byte.toUnsignedInt(receiveData);
        System.out.println("2. 자바 API 이용해서 Unsigned 정수 얻기: Byte.toUnsignedInt(-120) = " + unsignedInt2);

        int test = 136;
        byte btest = (byte) test;
        System.out.println("(byte)136 = " + btest);
    }
    public void bitShiftExample1() {
        System.out.println("\nBitShiftExample1");

        int num1 = 1;
        int result1 = num1 << 3;
        int result2 = num1 * (int)Math.pow(2, 3);
        System.out.println("1 << 3 = " + result1);
        System.out.println("1 * 2^3 = " + result2);

        int num2 = -8;
        int result3 = num2 >> 3;
        int result4 = num2 / (int)Math.pow(2, 3);
        System.out.println("-8 >> 3 = " + result3);
        System.out.println("-8 / 2^3 = " + result4);
    }
    public void bitShiftExample2() {
        System.out.println("\nBiteShiftExample2");

        int value = 772;

        //byte -> 맨끝 1 byte 부분만 가져옴

        byte byte1 = (byte)(value >>> 24);
        int int1 = byte1 & 255;
        System.out.println("첫 번째 바이트 부호 없는 값: 772 >>> 24 = " + int1);

        byte byte2 = (byte)(value >>> 16);
        int int2 = Byte.toUnsignedInt(byte2);
        System.out.println("두 번째 바이트 부호 없는 값: 772 >>> 16 = " + int2);

        byte byte3 = (byte)(value >>> 8);
        int int3 = byte3 & 255;
        System.out.println("세 번째 바이트 부호 없는 값: 772 >>> 8 = " + int3);

        byte byte4 = (byte)value;
        int int4 = Byte.toUnsignedInt(byte4);
        System.out.println("네 번째 바이트 부호 없는 값: 772 = " + int4);
    }
    public void assignmentOperatorExample() {
        System.out.println("\nAssignmentOperatorExample");

        int result = 0;
        result += 10;
        System.out.println("0 += 10: " + result);
        result -= 5;
        System.out.println("10 -= 5: " +result);
        result *= 3;
        System.out.println("5 *= 3: " + result);
        result /= 5;
        System.out.println("15 /= 5: " + result);
        result %= 3;
        System.out.println("3 %= 3: " + result);
    }
    public void conditionalOperationExample() {
        System.out.println("\nConditionalOperationExample");

        int score = 85;
        char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
        System.out.println(score + "점은 " + grade + "등급입니다. ((85 > 90) ? \'A\' : ((85 > 80) ? \'B\' : \'C\'))");
    }
}
