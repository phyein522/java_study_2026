package report0114;

public class Gugudan {
    public static void main(String[] args) {
        /*
        for(int x = 2; x < 10; x++) {
            System.out.println(x + "단 출력");
            for(int y = 1; y < 10; y++) {
                System.out.println(x + " * " + y + " = " + x * y);
            }
            System.out.println();
        }
        */
        for(int x = 2; x < 9; x += 3) {
            System.out.print(x + "단 출력 \t\t");
            System.out.print((x+1) + "단 출력 \t\t");
            System.out.println((x+2) >= 10 ? " " : (x+2) + "단 출력");
            for(int y = 1; y < 10; y++) {
                System.out.print(x + " * " + y + " = " + (x * y) + " \t\t");
                System.out.print((x+1) + " * " + y + " = " + (x+1) * y + " \t\t");
                System.out.println((x+2) >= 10 ? " " : (x+2) + " * " + y + " = " + (x+2) * y);
            }
            System.out.println();
        }
    }
}
