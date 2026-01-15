package com.phi;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        for(int i = 0; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("\n--------------------------------------------------");

        Variable01 v = new Variable01();
        v.howToUseVariable();
    }
}
