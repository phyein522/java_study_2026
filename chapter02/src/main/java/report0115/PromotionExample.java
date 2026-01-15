package report0115;

public class PromotionExample {
    public static void main(String[] args) {
        byte byteValue = 10;
        int intValue = byteValue;
        System.out.println("byteValue: " + byteValue +" intValue: " + intValue);

        char charValue = '가';
        intValue = charValue;
        System.out.println("charValue: " + charValue + ", \'가\'의 유니코드: " + intValue);

        intValue = 50;
        long longValue = intValue;
        System.out.println("intValue: " + intValue + ", longValue: " + longValue);

        longValue = 100;
        float floatValue = longValue;
        System.out.println("longValue: " + longValue + ", floatValue: " + floatValue);

        floatValue = 100.5f;
        double doubleValue = floatValue;
        System.out.println("floatValue: " + floatValue + ", doubleValue: " + doubleValue);
    }
}
