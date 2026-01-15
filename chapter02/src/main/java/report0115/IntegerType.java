package report0115;

public class IntegerType {
    public void useInteger() {
        System.out.println("\nIntegerLiteralExample");
        int var1 = 0b1011;
        int var2 = 0206;
        int var3 = 365;
        int var4 = 0xB3;
        System.out.println("var1 (0b1011): " + var1);
        System.out.println("var2 (0206):" + var2);
        System.out.println("var3 (365): " + var3);
        System.out.println("var4 (0xB3): " + var4);

        System.out.println("\nByteExample");
        byte var5 = -128;
        byte var6 = -30;
        byte var7 = 0;
        byte var8 = 30;
        byte var9 = 127;
        //byte vat10 = 128; //컴파일 에러 (Type mismatch)
        System.out.println("var5 (-128): " + var5);
        System.out.println("var6 (-30): " + var6);
        System.out.println("var7 (0): " + var7);
        System.out.println("var8 (30): " + var8);
        System.out.println("var9 (127): " + var9);
        System.out.println("var10 (128): 컴파일 에러 (Type mismatch)");

        System.out.println("\nLongExample");
        long var11 = 10;
        long var12 = 20L;
        //long var13 = 1000000000000; //컴파일 에러 (int로 간주)
        long var14 = 1000000000000L;
        System.out.println("var11 (10): " + var11);
        System.out.println("var12 (20L): " + var12);
        System.out.println("var13 (1000000000000): 컴파일 에러 (int로 간주)");
        System.out.println("var14 (1000000000000L): " + var14);
    }
}
