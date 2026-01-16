package report0116;

public class TranslateType {
    public void useTranslate() {
        System.out.println("\nOperationPromotiomExample");

        byte result1 = 10 + 20;
        System.out.println("byte result1 = 10 + 20: " + result1);

        byte v1 = 10;
        byte v2 = 20;
        int result2 = v1 + v2;
        System.out.println("int result2 = 10(byte) + 20(byte): " + result2);

        byte v3 = 10;
        int v4 = 100;
        long v5 = 1000L;
        long result3 = v3 + v4 + v5;
        System.out.println("long result3 = 10(byte) + 100 + 1000L: " + result3);

        char v6 = 'A';
        char v7 = 1;
        int result4 = v6 + v7;
        System.out.println("int result4 = 'A' + 1(char): " + result4);

        int v8 = 10;
        int result5 = v8 / 4;
        System.out.println("int result5 = 10 / 4: " + result5);

        int v9 = 10;
        double result6 = v9 / 4.0;
        System.out.println("double result6 = 10 / 4.0: " + result6);

        int v10 = 1;
        int v11 = 2;
        double result7 = (double) v10 / v11;
        System.out.println("double result7 = (double)1 / 2: " + result7);


        System.out.println("\nStringConcatExample");
        int result11 = 10 + 2 + 8;
        System.out.println("10 + 2 + 8: " + result11);

        String result12 = 10 + 2 + "8";
        System.out.println("10 + 2 + \"8\": " + result12);

        String result13 = 10 + "2" + 8;
        System.out.println("10 + \"2\" + 8: " + result13);

        String result14 = "10" + 2 + 8;
        System.out.println("\"10\" + 2 + 8: " + result14);

        String result15 = "10" + (2 + 8);
        System.out.println("\"10\" + (2 + 8): " + result15);


        System.out.println("\nPrimitiveAndStringConversionExample");

        int value21 = Integer.parseInt("10");
        double value22 = Double.parseDouble("3.14");
        boolean value23 = Boolean.parseBoolean("true");

        System.out.println("Integer.parseInt(\"10\"): " + value21);
        System.out.println("Double.parseDouble(\"3.14\"): " + value22);
        System.out.println("Boolean.parseBoolean(\"true\"): " + value23);

        String str1 = String.valueOf(10);
        String str2 = String.valueOf(3.14);
        String str3 = String.valueOf(true);

        System.out.println("String.valueOf(10): " + str1);
        System.out.println("String.valueOf(3.14): " + str2);
        System.out.println("String.valueOf(true): " + str3);
    }
}
