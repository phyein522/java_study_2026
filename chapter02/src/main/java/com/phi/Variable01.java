package com.phi;

public class Variable01 {
    public void howToUseVariable() {
        System.out.println("\nVariableInitializationExample");
        // int value;   // 컴파일 오류 (변수 초기화 필요)
        int value = 0;
        int result = value + 10;
        System.out.println(result);

        System.out.println("\nVariableUseExample");
        int hour = 3;
        int minute = 5;
        System.out.println(hour + "시간 " + minute + "분");
        int totalMinute = (hour*60)+ minute;
        System.out.println("총 " + totalMinute + "분");

        System.out.println("\nVariableExchangeExample");
        int x = 3;
        int y = 5;
        System.out.println("x: " + x + ", y: " + y);
        int temp = x;
        x = y;
        y = temp;
        System.out.println("x: " + x + ", y: " + y);
    }
}
