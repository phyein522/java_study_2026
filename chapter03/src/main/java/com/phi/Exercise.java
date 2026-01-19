package com.phi;

public class Exercise {
    public void exercise01() {
        System.out.println("\nexercise01");
        int x = 10;
        int y = 20;
        int z = (++x) + (y--);
        System.out.println("(++x(10)) + (y(20)--) = " + z);
        System.out.println("x: " + x + ", y: " + y);
        //후위 증감 연산자는 ()로 감싸도 ; 만난 후 증감
    }
    public void exercise02() {
        System.out.println("\nexercise02");
        int score = 85;
        String result = (!(score > 90)) ? "가" : "나";
        System.out.println("!(85 > 90) ? \"가\" : \"나\" = " + result);
    }
    public void exercise03() {
        System.out.println("\nexercise03");
        int pencils = 534;
        int students = 30;
        int pencilsPerStudnet = pencils / students;
        System.out.println("534 / 30 = " + pencilsPerStudnet);
        int pencilsLeft = pencils % students;
        System.out.println("534 % 30 = " + pencilsLeft);
    }
    public void exercise04() {
        System.out.println("\nexercise04");
        int value = 356;
        System.out.println("365 / 100 * 100 = " + (value / 100 * 100));
    }
    public void exercise05() {
        System.out.println("\nexercise05");

        int lengthTop = 5;
        int lengthBottom = 10;
        int height = 7;
        double area;

        area = (lengthTop + lengthBottom) * height / 2.0;
        System.out.println("(5 + 10) * 7 / 2.0 = " + area);
        area = (lengthTop + lengthBottom) * height * 1.0 / 2;
        System.out.println("(5 + 10) * 7 * 1.0 / 2 = " + area);
        area = (double)(lengthTop + lengthBottom) * height / 2;
        System.out.println("(double)(5 + 10) * 7 / 2 = " + area);
        area = (double)((lengthTop + lengthBottom) * height / 2);
        System.out.println("(double)((5 + 10) * 7 / 2)) = " + area);
    }
    public void exercise06() {
        System.out.println("\nexercise06");
        int x = 10;
        int y = 5;
        System.out.println("(10 > 7) && (5 <= 5) = " + ((x > 7) && (y <= 5)));
        System.out.println("(10 % 3 == 2) || (5 % 2 != 1) = " + ((x % 3 == 2) || (y % 2 != 1)));
    }
    public void exercise07() {
        System.out.println("\nexercise07");
        double x = 5.0;
        double y = 0.0;
        double z = 5 % y;
        if (Double.isNaN(z)) {
            System.out.println("0.0으로 나눌 수 없습니다.");
        } else {
            double result = z + 10;
            System.out.println("결과: " + result);
        }
    }
}
