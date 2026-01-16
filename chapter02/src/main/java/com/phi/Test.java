package com.phi;

public class Test {
    public static void main(String[] args) {
        String str = "str";
        char c = str.charAt(0);
        System.out.println(c);
        String ss = """
                %c""".formatted(c);
        System.out.println(ss);
    }
}
