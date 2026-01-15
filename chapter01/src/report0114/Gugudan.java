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
        System.out.println("--------------------------------------------------\n");
        for (int digit = 2; digit < 9; digit += 3) {
            for (int n = 0; n < 10; n++) {
                System.out.println(
                    (
                        (n == 0)
                            ? String.format("%d단 출력 \t\t%d단 출력 \t\t%s%s", digit, digit + 1, (digit+2<10 ? digit+2+"" : ""), (digit+2<10 ? "단 출력" : ""))    // if 1번째 줄
                            : ((digit < 8) ? String.format("%d * %d = %d \t\t%d * %d = %d \t\t%d * %d = %d" // else 2번째 줄, if 8단 미만
                                , digit, n, digit * n   // d단
                                , digit + 1, n, (digit + 1) * n // d+1단
                                , digit + 2, n, (digit + 2) * n)    //d+2단
                            : String.format("%d * %d = %d \t\t%d * %d = %d" // else 8단 이상
                                , digit, n, digit * n   // d단
                                , digit + 1, n, (digit + 1) * n))   // d+1단
                        )
                );
            }   // for (int n = 0; n < 10; n++)
            System.out.println();
        }   // for (int digit = 2; digit < 9; digit += 3)

    }
}
