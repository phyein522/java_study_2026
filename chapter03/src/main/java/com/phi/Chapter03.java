package com.phi;

public class Chapter03 {
    public void Third01() {
        System.out.println("\nSignOperatorExample");

        int x = -100;
        x = -x;
        System.out.println("x: " + x);

        byte b = 100;
        int y = -b;
        System.out.println("y: " + y);


        System.out.println("\nIncreaseDereaseOperatorExample");

        int x2 = 10;
        int y2 = 10;
        int z;

        x2++;
        ++x2;
        System.out.println("x = " + x2);

        System.out.println("--------------------");
        y2--;
        --y2;
        System.out.println("y = " + y2);

        System.out.println("--------------------");
        z = x2++;
        System.out.println("z = " + z);
        System.out.println("x = " + x2);

        System.out.println("--------------------");
        z = ++x2;
        System.out.println("z = " + z);
        System.out.println("x = " + x2);

        System.out.println("--------------------");
        z= ++x2 + y2++;
        System.out.println("z = " + z);
        System.out.println("x = " + x2);
        System.out.println("y = " + y2);
    }
    public void Third02() {
        System.out.println("\nArithmeticOperatorExample");

        byte v1 = 10;
        byte v2 = 4;
        int v3 = 5;
        long v4 = 10L;

        int result1 = v1 + v2;
        System.out.println("result1 (10(byte) + 4(byte)): " + result1);

        long result2 = v1 + v2 - v4;
        System.out.println("result2 (10(byte) + 4(byte) - 10L): " + result2);

        double result3 = (double) v1 / v2;
        System.out.println("result3 ((double)10(byte) / 4(byte)): " + result3);

        int result4 = v1 % v2;
        System.out.println("result4 (10(byte) % 4(byte)): " + result4);
    }
    public void Third03() {
        System.out.println("\nOverflowUnderflowExample");

        byte var1 = 125;
        for (int i = 0; i < 5; i++) {
            var1++;
            System.out.println("var1: " + var1);
        }

        System.out.println("--------------------");

        byte var2 = -125;
        for (int i = 0; i < 5; i++) {
            var2--;
            System.out.println("var2: " + var2);
        }
    }
    public void Third04() {
        System.out.println("\nAccuracyExample");

        int apple = 1;
        double pieceUnit = 0.1;
        int number = 7;

        double result = apple - number * pieceUnit;
        System.out.println("사과 1개에서 남은 양 (1 - 7 * 0.1): " + result);


        System.out.println("\nAcceracyExample");

        int apple2 = 1;
        int totalPieces = apple2 * 10;
        int number2 = 7;

        int result2 = totalPieces - number2;
        System.out.println("10조각에서 남은 조각 (1 * 10 - 7): " + result2);
        System.out.println("사과 1개에서 남은 양 (3 / 10.0): " + result2 / 10.0);
    }
}
